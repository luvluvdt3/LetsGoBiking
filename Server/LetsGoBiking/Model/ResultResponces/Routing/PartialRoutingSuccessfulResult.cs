using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace RoutingServer.Model.ResultResponces.Routing
{
    [DataContract]
    public class PartialRoutingSuccessfulResult
    {
        [DataMember]
        [JsonPropertyName("guiId")]
        public string GuiId { get; set; }

        [DataMember]
        [JsonPropertyName("step")]
        public int Step { get; set; }

        public PartialRoutingSuccessfulResult(string guiId, int step)
        {
            this.GuiId = guiId;
            this.Step = step;
        }
    }
}