using RoutingServer.JCDecauxService;
using RoutingServer.Model;
using RoutingServer.Model.ResultResponces.Routing;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Threading.Tasks;

namespace RoutingServer
{
    [ServiceContract]
    public interface IRoutingService
    {
        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "/get_partial_itinerary?OriginLatitude={originLat}&OriginLongitude={originLon}&DestinationLatitude={destLat}&DestinationLongitude={destLon}&guiId={guiId}&step={step}", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.Wrapped)]
        Task<PartialRoutingResult> GetPartialRouteAsync(double originLat, double originLon, double destLat, double destLon, string guiId = null, int step = 0);


        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "/post_partial_itinerary", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.Wrapped)]
        Task<PartialRoutingResult> PostPartialRouteAsync(RouteRequest destination, string guiId = null, int step = 0);


        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "/post_itinerary", RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.Wrapped)]
        Task<Result> PostItineraryAsync(RouteRequest destination);

        [OperationContract]
        [WebGet(UriTemplate = "/get_itinerary?OriginLatitude={originLat}&OriginLongitude={originLon}&DestinationLatitude={destLat}&DestinationLongitude={destLon}", ResponseFormat = WebMessageFormat.Json, BodyStyle = WebMessageBodyStyle.Wrapped)]
        Task<Result> GetItineraryAsync(double originLat, double originLon, double destLat, double destLon);

        [OperationContract]
        Task<CompositeType> GetDataUsingDataContract(CompositeType composite);

        [OperationContract]
        [WebInvoke(Method = "OPTIONS", UriTemplate = "*")]
        void GetOptions();
    }

    [DataContract]
    public class CompositeType
    {
        bool boolValue = true;
        string stringValue = "Hello ";

        [DataMember]
        public bool BoolValue
        {
            get { return boolValue; }
            set { boolValue = value; }
        }

        [DataMember]
        public string StringValue
        {
            get { return stringValue; }
            set { stringValue = value; }
        }
    }

    [DataContract]
    public class RouteRequest
    {
        [DataMember]
        public Location Origin { get; set; }

        [DataMember]
        public Location Destination { get; set; }
    }
}
