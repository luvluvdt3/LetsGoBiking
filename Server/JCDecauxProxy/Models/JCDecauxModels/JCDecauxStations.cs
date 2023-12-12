using JCDecauxProxy.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace JCDecauxProxy
{
    internal class JCDecauxStations
    {
        public List<Station> Stations { get; private set; }
        public JCDecauxStations() 
        {
            InitializeStationsAsync().Wait(); 
        }

        private async Task InitializeStationsAsync()
        {
            Stations = await JCDecauxRESTServer.GetAllStations(ProxyService.contractNameToFetchFrom.Value);
        }
    }
}
