using System.Collections.Generic;
using System.Text.Json.Serialization;

namespace JCDecauxProxy.Models
{
    public class Contract
    {
        [JsonPropertyName("name")]
        public string Name { get; set; }

        [JsonPropertyName("commercial_name")]
        public string CommercialName { get; set; }

        [JsonPropertyName("cities")]
        public List<string> Cities { get; set; }

        [JsonPropertyName("country_code")]
        public string CountryCode { get; set; }
    }
}
