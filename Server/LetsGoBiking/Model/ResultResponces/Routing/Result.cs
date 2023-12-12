using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace RoutingServer.Model
{
    [DataContract]
    public class Result
    {
        [DataMember]
        [JsonPropertyName("success")]
        public SuccessfullResult SuccessfullResult { get; private set; }

        [DataMember]
        [JsonPropertyName("error")]
        public ErrorResult ErrorResult { get; private set; }

        private Result(ErrorResult errorResult, SuccessfullResult successfullResult)
        {
            this.SuccessfullResult = successfullResult;
            this.ErrorResult = errorResult;
        }

        public Result(SuccessfullResult successfullResult) 
        {
            this.SuccessfullResult = successfullResult;
        }

        public Result(ErrorResult errorResult)
        {
            this.ErrorResult = errorResult;
        }

        public bool HasSuccessfulResult()
        {
            return SuccessfullResult != null;
        }

        public bool HasErrorResult()
        {
            return ErrorResult != null;
        }
    }
}
