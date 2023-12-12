using System.Net;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace RoutingServer.Model
{
    [DataContract]
    public class ErrorResult
    {
        [DataMember]
        [JsonPropertyName("errorCode")]
        public HttpStatusCode ErrorCode { get; set; }

        [DataMember]
        [JsonPropertyName("message")]
        public string Message { get; set; }

        public ErrorResult(HttpStatusCode errorCode, string message)
        {
            this.ErrorCode = errorCode;
            this.Message = message;
        }
    }
}
