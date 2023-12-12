using JCDecauxProxy.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;

namespace JCDecauxProxy
{
    public  class JCDecauxRESTServer
    {
        private const string API_LINK = "https://api.jcdecaux.com/vls/v3";
        private const string API_KEY = "86959717867b082e1bc538064f93c7f8835d7259";
        
        private static readonly HttpClient httpClient = new HttpClient();

        public static async Task<List<Station>> GetAllStations(string contractName)
        {
            string url = $"{API_LINK}/stations?apiKey={API_KEY}&contract={contractName}";

            var response = await httpClient.GetAsync(url);

            response.EnsureSuccessStatusCode();

            var responseContent = await response.Content.ReadAsStringAsync();

            var stationsWithBikes = JsonSerializer.Deserialize<List<Station>>(responseContent);

            return stationsWithBikes;
        }

        public static async Task<List<Contract>> GetContracts()
        {
            string url = $"{API_LINK}/contracts?apiKey={API_KEY}";

            var response = await httpClient.GetAsync(url);

            response.EnsureSuccessStatusCode();

            var responseContent = await response.Content.ReadAsStringAsync();
            var contracts = JsonSerializer.Deserialize<List<Contract>>(responseContent);

            return contracts;
        }
    }
}
