using JCDecauxProxy.Models;
using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using System.Device.Location;
using System.Linq;
using System.Threading;

namespace JCDecauxProxy
{
    public class ProxyService : IProxyService
    {
        public Task<CompositeType> GetDataUsingDataContractAsync(CompositeType composite)
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

        public static readonly ThreadLocal<string> contractNameToFetchFrom = new ThreadLocal<string>();

        private readonly GenericProxyCache<JCDecauxStations> stationsCache = new GenericProxyCache<JCDecauxStations>();
        private readonly GenericProxyCache<JCDecauxContracts> contractsCache = new GenericProxyCache<JCDecauxContracts>();

        public async Task<Station> FindClosestStationWithBikesAsync(string contractName, Location origin) 
            => findClosestStation(await getStationsWithBikes(contractName), origin);

        public async Task<Station> FindClosestStationWithStandsAsync(string contractName, Location origin) 
            => findClosestStation(await getStationsWithStands(contractName), origin);
        

        public async Task<List<Station>> GetStationsAsync(string contractName)
        {
            contractNameToFetchFrom.Value = contractName ?? string.Empty;
            return stationsCache.Get("stations_" + contractName, DateTimeOffset.Now.AddMinutes(3)).Stations;
        }

        public async Task<List<Contract>> GetContractsAsync() => contractsCache.Get("contracts").Contracts;


        public async Task<Station> UpdateStationWithBikesStateOrFindClosestAsync(Station stationFrom, Location location)
        {
            var stations = await getStationsWithBikes(stationFrom.ContractName);

            return stations.FirstOrDefault(s => s.Number == stationFrom.Number) ?? findClosestStation(stations, location);
        }

        public async Task<Station> UpdateStationWithStandsStateOrFindClosestAsync(Station stationFrom, Location location)
        {
            var stations = await getStationsWithStands(stationFrom.ContractName);

            return stations.FirstOrDefault(s => s.Number == stationFrom.Number) ?? findClosestStation(stations, location);
        }

        private async Task<List<Station>> getStationsWithBikes(string contractName)
        {
            return (await GetStationsAsync(contractName)).Where(
                                                                x => x.Status == StationStatus.OPEN
                                                                    && x.TotalStands.Availability.NumberOfBikesAvailable() > 0
                                                               ).ToList();
        }

        private async Task<List<Station>> getStationsWithStands(string contractName)
        {
            return (await GetStationsAsync(contractName)).Where(
                                                                x => x.Status == StationStatus.OPEN
                                                                    && x.TotalStands.Availability.NumberOfStandsAvailable() > 0
                                                                ).ToList();
        }

        private Station findClosestStation(List<Station> stations, Location origin)
        {
            GeoCoordinate targetLocation = new GeoCoordinate(origin.Latitude, origin.Longitude);
            Station closestStation = null;
            double closestDistance = double.MaxValue;

            foreach (var station in stations)
            {
                GeoCoordinate stationLocation = new GeoCoordinate(station.Position.Latitude, station.Position.Longitude);
                double distance = targetLocation.GetDistanceTo(stationLocation);

                if (distance < closestDistance)
                {
                    closestDistance = distance;
                    closestStation = station;
                }
            }

            return closestStation;
        }
    }
}
