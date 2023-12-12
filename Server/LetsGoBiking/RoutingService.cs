using RoutingServer.JCDecauxService;
using RoutingServer.Model;
using RoutingServer.Model.ResultResponces.Routing;
using RoutingServer.OpenStreetMapAPI;
using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.ServiceModel;
using System.Threading.Tasks;

namespace RoutingServer
{
    public class RoutingService : IRoutingService
    {
        private readonly ActiveMqManager activeMq = new ActiveMqManager();
        private static Dictionary<string, SuccessfullResult> resultDictionary = new Dictionary<string, SuccessfullResult>();

        public static readonly HttpClient httpClient = new HttpClient();

        private static BasicHttpBinding binding = new BasicHttpBinding();
        private static EndpointAddress endpointAddress = new EndpointAddress("http://localhost:8090/LetsGoBiking/ProxyService/");
        private static ProxyServiceClient proxyServiceClient = new ProxyServiceClient(binding, endpointAddress);

        private static Contract[] contracts;

        public const int ACCEPTABLE_WALKING_DURATION = 3;

        private async Task InitializeContractsAsync()
        {
            httpClient.DefaultRequestHeaders.Add("User-Agent", "LetsGoBiking");

            contracts = await proxyServiceClient.GetContractsAsync();
        }

        public static string DoubleToString(double coordinate)
        {
            return coordinate.ToString(CultureInfo.InvariantCulture);
        }

        public Task<CompositeType> GetDataUsingDataContract(CompositeType composite)
        {
            return Task.Run(() =>
            {
                if (composite == null)
                {
                    throw new ArgumentNullException("composite");
                }

                if (composite.BoolValue)
                {
                    composite.StringValue += "Suffix";
                }

                return composite;
            });
        }

        public Task<PartialRoutingResult> GetPartialRouteAsync(double originLat, double originLon, double destLat, double destLon, string guiId, int stepCount)
        {
            var routeRequest = new RouteRequest
            {
                Origin = new Location { Latitude = originLat, Longitude = originLon },
                Destination = new Location { Latitude = destLat, Longitude = destLon }
            };

            return PostPartialRouteAsync(routeRequest, guiId, stepCount);
        }

        public Task<Result> GetItineraryAsync(double originLat, double originLon, double destLat, double destLon)
        {
            var routeRequest = new RouteRequest
            {
                Origin = new Location { Latitude = originLat, Longitude = originLon },
                Destination = new Location { Latitude = destLat, Longitude = destLon }
            };

            return PostItineraryAsync(routeRequest);
        }
        public async Task<PartialRoutingResult> PostPartialRouteAsync(RouteRequest routeRequest, string guiId, int stepCount)
        {
            if (guiId == null)
            {
                return await getFirstTimePartialRoute(routeRequest);
            }

            SuccessfullResult successfullResult = resultDictionary[guiId];
            if (stepCount == 1)
            {
                return await renewRouteFromStation(routeRequest, guiId, successfullResult);
            }
            else if (stepCount == 2)
            {
                return await renewRouteToStation(successfullResult, routeRequest, guiId);
            }

            return new PartialRoutingResult(new ErrorResult(HttpStatusCode.BadRequest, "Invalid stepCount value"));
        }

        public async Task<Result> PostItineraryAsync(RouteRequest routeRequest)
        {
            if (contracts == null)
            {
                InitializeContractsAsync().Wait();
            }
            var cityNameOriginTask = OpenStreetMapCityRESTServer.GetNearestCity(routeRequest.Origin);
            var cityNameDestTaskTask = OpenStreetMapCityRESTServer.GetNearestCity(routeRequest.Destination);

            await Task.WhenAll(cityNameOriginTask, cityNameDestTaskTask);

            ResultNearestCity cityNameOrigin = null;
            ResultNearestCity cityNameDest = null;

            if (cityNameOriginTask.Status == TaskStatus.RanToCompletion &&
                cityNameDestTaskTask.Status == TaskStatus.RanToCompletion)
            {
                cityNameOrigin = cityNameOriginTask.Result;
                cityNameDest = cityNameDestTaskTask.Result;
            }

            if (cityNameOrigin == null)
            {
                return new Result(new ErrorResult(HttpStatusCode.NotFound, "Cannot find the city of origin"));
            }

            if (cityNameDest == null)
            {
                return new Result(new ErrorResult(HttpStatusCode.NotFound, "Cannot find the city of destination"));
            }

            if (cityNameOrigin.HasErrorResult() || cityNameDest.HasErrorResult())
            {
                return new Result(cityNameOrigin.ErrorResult ?? cityNameDest.ErrorResult);
            }

            if (!contracts.Any(x => cityNameOrigin.CityName.Contains(x.Name)))
            {
                return new Result(new ErrorResult(HttpStatusCode.NotImplemented, "There is no bikes in city " + cityNameOrigin.CityName));
            }

            if (!contracts.Any(x => cityNameDest.CityName.Contains(x.Name)))
            {
                return new Result(new ErrorResult(HttpStatusCode.NotImplemented, "There is no bikes in city " + cityNameDest.CityName));
            }

            var stationFromTask = proxyServiceClient.FindClosestStationWithBikesAsync(cityNameOrigin.CityName, routeRequest.Origin);

            var stationToTask = proxyServiceClient.FindClosestStationWithStandsAsync(cityNameDest.CityName, routeRequest.Destination);

            await Task.WhenAll(stationFromTask, stationToTask);

            Station stationFrom;
            Station stationTo;

            if (stationFromTask.Status == TaskStatus.RanToCompletion &&
                stationToTask.Status == TaskStatus.RanToCompletion)
            {
                stationFrom = stationFromTask.Result;
                stationTo = stationToTask.Result;

                if (stationFrom == null)
                {
                    return new Result(new ErrorResult(HttpStatusCode.NotFound, "There is no stations in origin city: " + cityNameOrigin));
                }

                if (stationTo == null)
                {
                    return new Result(new ErrorResult(HttpStatusCode.NotFound, "There is no stations in destination city: " + cityNameDest));
                }

            }
            else
            {
                return new Result(new ErrorResult(HttpStatusCode.BadRequest, "Unknown service error"));
            }

            return await getRoute(routeRequest, stationFrom, stationTo);
        }

        private async static Task<Result> getRoute(RouteRequest routeRequest, Station stationFrom, Station stationTo)
        {
            var fullWalkingRootTask = OpenStreetMapRouteRESTServer.GetPath(routeRequest.Origin, routeRequest.Destination, WayOfTransport.WALK);
            var routeToStationTask = OpenStreetMapRouteRESTServer.GetPath(routeRequest.Origin, stationFrom.Position, WayOfTransport.WALK);
            var routeBetweenStationsTask = OpenStreetMapRouteRESTServer.GetPath(stationFrom.Position, stationTo.Position, WayOfTransport.CYCLING);
            var routeFromStationTask = OpenStreetMapRouteRESTServer.GetPath(stationTo.Position, routeRequest.Destination, WayOfTransport.WALK);

            await Task.WhenAll(fullWalkingRootTask, routeToStationTask, routeBetweenStationsTask, routeFromStationTask);

            if (fullWalkingRootTask.Status == TaskStatus.RanToCompletion &&
                routeToStationTask.Status == TaskStatus.RanToCompletion &&
                routeBetweenStationsTask.Status == TaskStatus.RanToCompletion &&
                routeFromStationTask.Status == TaskStatus.RanToCompletion)
            {
                var fullWalkingRoot = fullWalkingRootTask.Result;

                var routeToStation = routeToStationTask.Result;
                var routeBetweenStations = routeBetweenStationsTask.Result;
                var routeFromStation = routeFromStationTask.Result;

                var successfulResult = new SuccessfullResult();


                if (routeToStation.HasErrorResult())
                {
                    return returnWalkingResultOrError(fullWalkingRoot, routeToStation.ErrorResult);
                }

                if (!isWalkingOk(routeToStation.SuccessfullResult.RouteDuration()))
                {
                   return returnWalkingResultOrError(fullWalkingRoot, new ErrorResult(HttpStatusCode.NotAcceptable, "The distance to the closest station from origin is too big! " + routeToStation.SuccessfullResult.RouteDuration() + "s"));
                }
            
                if (routeBetweenStations.HasErrorResult())
                {
                    return returnWalkingResultOrError(fullWalkingRoot, routeBetweenStations.ErrorResult);
                }

                if (routeFromStation.HasErrorResult())
                {
                    return returnWalkingResultOrError(fullWalkingRoot, routeFromStation.ErrorResult);
                }

                if (!isWalkingOk(routeFromStation.SuccessfullResult.RouteDuration()))
                {
                    return returnWalkingResultOrError(fullWalkingRoot, new ErrorResult(HttpStatusCode.NotAcceptable, "The distance from the closest station to destination is too big! " + routeFromStation.SuccessfullResult.RouteDuration() + "s"));
                }

                successfulResult.AddAllRoute(routeToStation.SuccessfullResult.FullRoute);
                successfulResult.AddAllRoute(routeBetweenStations.SuccessfullResult.FullRoute);
                successfulResult.AddAllRoute(routeFromStation.SuccessfullResult.FullRoute);

                if (fullWalkingRoot.HasSuccessfulResult() && fullWalkingRoot.SuccessfullResult.RouteDuration() < successfulResult.RouteDuration())
                {
                    return fullWalkingRoot;
                }

                successfulResult.StartStation = stationFrom;
                successfulResult.EndStation = stationTo;

                return new Result(successfulResult);
            }
            else
            {
                return new Result(new ErrorResult(HttpStatusCode.BadRequest, "Unknown service error"));
            }
        }

        private static Result returnWalkingResultOrError(Result walkResult, ErrorResult error)
        {
            return walkResult.HasSuccessfulResult() && isWalkingOk(walkResult.SuccessfullResult.RouteDuration()) ? walkResult : new Result(error);
        }


        private static bool isWalkingOk(double duration)
        {
            return duration < ACCEPTABLE_WALKING_DURATION * 3600;
        }


        private async Task<PartialRoutingResult> getFirstTimePartialRoute(RouteRequest routeRequest)
        {
            string guiId = Guid.NewGuid().ToString();
            var itineraryBuilding = await PostItineraryAsync(routeRequest);
            if (itineraryBuilding.HasSuccessfulResult())
            {
                resultDictionary.Add(guiId, itineraryBuilding.SuccessfullResult);
                activeMq.Send(guiId, itineraryBuilding.SuccessfullResult.FullRoute[0]);

                return new PartialRoutingResult(new PartialRoutingSuccessfulResult(guiId, 0));
            }
            else
            {
                return new PartialRoutingResult(itineraryBuilding.ErrorResult);
            }
        }

        private async Task<PartialRoutingResult> renewRouteFromStation(RouteRequest routeRequest, string guiId, SuccessfullResult successfullResult)
        {
            Station station = await proxyServiceClient.UpdateStationWithBikesStateOrFindClosestAsync(successfullResult.StartStation, routeRequest.Origin);
            if (station.Number == successfullResult.StartStation.Number)
            {
                activeMq.Send(guiId, successfullResult.FullRoute[1]);

                return new PartialRoutingResult(new PartialRoutingSuccessfulResult(guiId, 1));
            }
            else
            {
                Result result = await getRoute(routeRequest, station, successfullResult.EndStation);
                if (result.HasSuccessfulResult())
                {
                    resultDictionary[guiId] = result.SuccessfullResult;
                    activeMq.Send(guiId, successfullResult.FullRoute[0]);
                    return new PartialRoutingResult(new PartialRoutingSuccessfulResult(guiId, 0));
                }
                return new PartialRoutingResult(result.ErrorResult);
            }
        }

        private async Task<PartialRoutingResult> renewRouteToStation(SuccessfullResult successfullResult, RouteRequest routeRequest, string guiId)
        {
            Station station = await proxyServiceClient.UpdateStationWithStandsStateOrFindClosestAsync(successfullResult.EndStation, routeRequest.Destination);
            if (station.Number == successfullResult.EndStation.Number)
            {
                activeMq.Send(guiId, successfullResult.FullRoute[2]);
                resultDictionary.Remove(guiId);
                return new PartialRoutingResult(new PartialRoutingSuccessfulResult(guiId, 3));
            }
            else
            {
                var routeBetweenStationsTask = OpenStreetMapRouteRESTServer.GetPath(routeRequest.Origin, station.Position, WayOfTransport.CYCLING);
                var routeFromStationTask = OpenStreetMapRouteRESTServer.GetPath(station.Position, routeRequest.Destination, WayOfTransport.WALK);

                await Task.WhenAll(routeBetweenStationsTask, routeFromStationTask);

                if (routeBetweenStationsTask.Status == TaskStatus.RanToCompletion &&
                    routeFromStationTask.Status == TaskStatus.RanToCompletion)
                {
                    var routeBetweenStations = routeBetweenStationsTask.Result;
                    var routeFromStation = routeFromStationTask.Result;

                    var successfulResult = new SuccessfullResult();

                    if (routeBetweenStations.HasErrorResult())
                    {
                        return new PartialRoutingResult(routeBetweenStations.ErrorResult);
                    }

                    if (routeFromStation.HasErrorResult())
                    {
                        return new PartialRoutingResult(routeFromStation.ErrorResult);
                    }
                    successfulResult.FullRoute.RemoveRange(1, 2);
                    successfulResult.AddAllRoute(routeBetweenStations.SuccessfullResult.FullRoute);
                    successfulResult.AddAllRoute(routeFromStation.SuccessfullResult.FullRoute);

                    successfulResult.EndStation = station;

                    activeMq.Send(guiId, successfullResult.FullRoute[1]);
                    return new PartialRoutingResult(new PartialRoutingSuccessfulResult(guiId, 1));
                }
                else
                {
                    return new PartialRoutingResult(new ErrorResult(HttpStatusCode.BadRequest, "Unknown service error"));
                }
            }
        }

        public void GetOptions()
        {
            // This method is intentionally left empty.
        }
    }
}
