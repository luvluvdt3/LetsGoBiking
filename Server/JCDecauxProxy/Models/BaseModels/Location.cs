using System.Globalization;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace JCDecauxProxy.Models
{
    [DataContract]
    public class Location
    {
        [DataMember]
        [JsonPropertyName("latitude")]
        public double Latitude { get; set; }

        [DataMember]
        [JsonPropertyName("longitude")]
        public double Longitude { get; set; }

        public override string ToString()
        {
            return $"latitude: {Latitude}\nlongitude: {Longitude}";
        }
    }
}
