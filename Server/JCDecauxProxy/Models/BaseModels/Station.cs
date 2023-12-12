using JCDecauxProxy.Models.BaseModels;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace JCDecauxProxy.Models
{
    [DataContract]
    public class Station
    {
        [DataMember]
        [JsonPropertyName("number")]
        public int Number { get; set; }

        [DataMember]
        [JsonPropertyName("status")]
        [JsonConverter(typeof(JsonStringEnumConverter))]
        public StationStatus Status { get; set; }

        [DataMember]
        [JsonPropertyName("contractName")]
        public string ContractName { get; set; }

        [DataMember]
        [JsonPropertyName("cities")]
        public List<string> Cities { get; set; }

        [DataMember]
        [JsonPropertyName("position")]
        public Location Position { get; set; }

        [DataMember]
        [JsonPropertyName("banking")]
        public bool Banking { get; set; }

        [DataMember]
        [JsonPropertyName("bonus")]
        public bool Bonus { get; set; }

        [DataMember]
        [JsonPropertyName("totalStands")]
        public Stand TotalStands { get; set; }

        public override string ToString()
        {
            return $"number: {Number}\n" +
                $"contactName: {ContractName}\n" +
                $"position: {Position}\n" +
                $"banking: {Banking}\n" +
                $"bonus: {Bonus}\n";
        }
    }

    public enum StationStatus
    {
        OPEN,
        CLOSED
    }
}
