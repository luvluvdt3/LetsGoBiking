using JCDecauxProxy.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JCDecauxProxy
{
    internal class JCDecauxContracts
    {
        public List<Contract> Contracts { get; private set; }
        public JCDecauxContracts()
        {
            InitializeStationsAsync().Wait();
        }

        private async Task InitializeStationsAsync()
        {
            Contracts = await JCDecauxRESTServer.GetContracts();
        }
    }
}
