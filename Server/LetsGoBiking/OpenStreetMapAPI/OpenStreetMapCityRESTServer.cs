using RoutingServer.JCDecauxService;
using RoutingServer.Model;
using Newtonsoft.Json.Linq;
using RoutingServer;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;

namespace RoutingServer.OpenStreetMapAPI
{
    public  class OpenStreetMapCityRESTServer
    {
        private static readonly string API_CITY_LINK = "https://nominatim.openstreetmap.org";
        public static async Task<ResultNearestCity> GetNearestCity(Location location)
        {
            string apiUrl = $"{API_CITY_LINK}/reverse?format=json&lat={RoutingService.DoubleToString(location.Latitude)}&lon={RoutingService.DoubleToString(location.Longitude)}";

            HttpResponseMessage response = await RoutingService.httpClient.GetAsync(apiUrl);

            if(!response.IsSuccessStatusCode) 
            {
                return new ResultNearestCity(new ErrorResult(response.StatusCode, response.ReasonPhrase));
            }

            string jsonResult = await response.Content.ReadAsStringAsync();
            JObject jsonObject = JObject.Parse(jsonResult);
            string locationCity = jsonObject["address"]["town"]?.ToString() ?? jsonObject["address"]["city"]?.ToString() ?? jsonObject["address"]["district"]?.ToString() ?? jsonObject["address"]["municipality"]?.ToString();

            if (locationCity == null) 
            {
                return new ResultNearestCity(new ErrorResult(HttpStatusCode.NotFound, "You are located not in the city"));
            }

            return new ResultNearestCity(locationCity?.Split(' ')[0].ToLower());
        }
    }
}
