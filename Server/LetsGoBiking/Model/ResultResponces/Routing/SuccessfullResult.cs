using RoutingServer.JCDecauxService;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace RoutingServer.Model
{
    [DataContract]
    public class SuccessfullResult
    {
        [DataMember]
        [JsonPropertyName("fullRoute")]
        public List<RoutePart> FullRoute { get; private set; } = new List<RoutePart> ();

        [DataMember]
        [JsonPropertyName("startStation")]
        public Station StartStation { get; set; }

        [DataMember]
        [JsonPropertyName("endStation")]
        public Station EndStation { get; set; }

        public void AddRoute(RoutePart routePart)
        {
            this.FullRoute.Add(routePart);
        }

        public void AddAllRoute(List<RoutePart> routePart)
        {
            this.FullRoute.AddRange(routePart);
        }

        public double RouteDuration()
        {
            return FullRoute.Sum(x => x.Path.Features.Sum(y=> y.Properties.Segments.Sum(j => j.Duration)));
        }

        public double RouteDistances()
        {
            return FullRoute.Sum(x => x.Path.Features.Sum(y => y.Properties.Segments.Sum(j => j.Distance)));
        }
    }
}
