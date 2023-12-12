using JCDecauxProxy.Models;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Threading.Tasks;

namespace JCDecauxProxy
{
    [ServiceContract]
    public interface IProxyService
    {

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "get_contracts", BodyStyle = WebMessageBodyStyle.Wrapped, ResponseFormat = WebMessageFormat.Json)]
        Task<List<Contract>> GetContractsAsync();

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "get_stations?contractName={contractName}", BodyStyle = WebMessageBodyStyle.Wrapped, ResponseFormat = WebMessageFormat.Json)]
        Task<List<Station>> GetStationsAsync(string contractName);

        [OperationContract()]
        [WebInvoke(Method = "POST", UriTemplate = "closest_bikes_station", BodyStyle = WebMessageBodyStyle.Wrapped, ResponseFormat = WebMessageFormat.Json, RequestFormat = WebMessageFormat.Json)]
        Task<Station> FindClosestStationWithBikesAsync(string contractName, Location origin);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "closest_stands_station", BodyStyle = WebMessageBodyStyle.Wrapped, ResponseFormat = WebMessageFormat.Json, RequestFormat = WebMessageFormat.Json)]
        Task<Station> FindClosestStationWithStandsAsync(string contractName, Location origin);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "update_bikes_station", BodyStyle = WebMessageBodyStyle.Wrapped, ResponseFormat = WebMessageFormat.Json, RequestFormat = WebMessageFormat.Json)]
        Task<Station> UpdateStationWithBikesStateOrFindClosestAsync(Station station, Location location);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "update_stands_station", BodyStyle = WebMessageBodyStyle.Wrapped, ResponseFormat = WebMessageFormat.Json, RequestFormat = WebMessageFormat.Json)]
        Task<Station> UpdateStationWithStandsStateOrFindClosestAsync(Station station, Location location);

        [OperationContract]
        Task<CompositeType> GetDataUsingDataContractAsync(CompositeType composite);

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
}
