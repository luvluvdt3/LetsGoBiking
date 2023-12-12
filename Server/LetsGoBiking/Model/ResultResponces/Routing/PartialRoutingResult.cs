using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace RoutingServer.Model.ResultResponces.Routing
{
    [DataContract]
    public class PartialRoutingResult
    {
        [DataMember]
        [JsonPropertyName("success")]
        public PartialRoutingSuccessfulResult PartialRoutingSuccessfulResult { get; private set; }

        [DataMember]
        [JsonPropertyName("error")]
        public ErrorResult ErrorResult { get; private set; }

        public PartialRoutingResult(PartialRoutingSuccessfulResult successfullResult)
        {
            this.PartialRoutingSuccessfulResult = successfullResult;
        }

        public PartialRoutingResult(ErrorResult errorResult)
        {
            this.ErrorResult = errorResult;
        }

        public bool HasSuccessfulResult()
        {
            return PartialRoutingSuccessfulResult != null;
        }

        public bool HasErrorResult()
        {
            return ErrorResult != null;
        }
    }
}