using RoutingServer.Model;
using RoutingServer.JCDecauxService;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;

namespace RoutingServer.OpenStreetMapAPI
{
    public class OpenStreetMapRouteRESTServer
    {
        private const string API_ROUTE_LINK = "https://api.openrouteservice.org/";

        private const string API_KEY = "5b3ce3597851110001cf62480a82a61d8305465f89bfc1163a0951d4";

        public static async Task<Result> GetPath(Location coordinate, Location stationPos, WayOfTransport wayOfTransport)
        {
            string link = API_ROUTE_LINK + "v2/directions/" + wayOfTransport.GetStringValue() + "?api_key=" + API_KEY + "&start=" + LocationToString(coordinate) +
                "&end=" + LocationToString(stationPos);
            HttpResponseMessage response = await RoutingService.httpClient.GetAsync(link);

            if(!response.IsSuccessStatusCode)
            {
                ErrorResult errorResult = new ErrorResult(response.StatusCode, response.ReasonPhrase);

                return new Result(errorResult);
            }

            var responseContent = await response.Content.ReadAsStringAsync();
            var path = JsonSerializer.Deserialize<Path>(responseContent);

            if (path == null)
            {
                ErrorResult errorResult = new ErrorResult(HttpStatusCode.InternalServerError, "There is no path between providen locations");

                return new Result(errorResult);
            }

            SuccessfullResult successfullResult = new SuccessfullResult();
            successfullResult.AddRoute(new RoutePart(wayOfTransport, path));

            return new Result(successfullResult);
        }

        public static string LocationToString(Location location)
        {
            return RoutingService.DoubleToString(location.Longitude) + "," + RoutingService.DoubleToString(location.Latitude);
        }
    }
}
