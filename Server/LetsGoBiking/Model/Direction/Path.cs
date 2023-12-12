using System;
using System.Collections.Generic;
using System.Runtime.Serialization;
using System.Text.Json.Serialization;

namespace RoutingServer.Model
{

    [DataContract]
    public class Step
    {
        [DataMember]
        [JsonPropertyName("distance")]
        public double Distance { get; set; }

        [DataMember]
        [JsonPropertyName("duration")]
        public double Duration { get; set; }

        [DataMember]
        [JsonPropertyName("type")]
        public int Type { get; set; }

        [DataMember]
        [JsonPropertyName("instruction")]
        public string Instruction { get; set; }

        [DataMember]
        [JsonPropertyName("name")]
        public string Name { get; set; }

        [DataMember]
        [JsonPropertyName("way_points")]
        public List<int> WayPoints { get; set; }
    }

    [DataContract]
    public class Segment
    {
        [DataMember]
        [JsonPropertyName("distance")]
        public double Distance { get; set; }

        [DataMember]
        [JsonPropertyName("duration")]
        public double Duration { get; set; }

        [DataMember]
        [JsonPropertyName("steps")]
        public List<Step> Steps { get; set; }
    }

    [DataContract]
    public class Properties
    {
        [DataMember]
        [JsonPropertyName("transfers")]
        public int Transfers { get; set; }

        [DataMember]
        [JsonPropertyName("fare")]
        public int Fare { get; set; }

        [DataMember]
        [JsonPropertyName("segments")]
        public List<Segment> Segments { get; set; }
    }

    [DataContract]
    public class Feature
    {
        [DataMember]
        [JsonPropertyName("properties")]
        public Properties Properties { get; set; }

        [DataMember]
        [JsonPropertyName("geometry")]
        public Geometry Geometry { get; set; }

    }

    [DataContract]
    public class Geometry
    {
        [DataMember]
        [JsonPropertyName("coordinates")]
        public List<List<double>> Coordinates { get; set; }

        [DataMember]
        [JsonPropertyName("type")]
        public string Type { get; set; }
    }

    [DataContract]
    public class Path
    {
        [DataMember]
        [JsonPropertyName("features")]
        public List<Feature> Features { get; set; }
    }

    [DataContract]
    public class RoutePart
    {
        [DataMember]
        [JsonPropertyName("wayOfTransport")]
        public WayOfTransport WayOfTransport { get; set; }

        [DataMember]
        [JsonPropertyName("path")]
        public Path Path { get; set; }

        public RoutePart(WayOfTransport wayOfTransport, Path path)
        {
            this.Path = path;
            this.WayOfTransport = wayOfTransport;
        }
    }

    public enum WayOfTransport
    {
        [StringValue("foot-walking")]
        WALK,

        [StringValue("cycling-regular")]
        CYCLING
    }

    [AttributeUsage(AttributeTargets.Field, Inherited = false, AllowMultiple = false)]
    sealed class StringValueAttribute : Attribute
    {
        public string Value { get; }

        public StringValueAttribute(string value)
        {
            Value = value;
        }
    }

    public static class WayOfTransportExtensions
    {
        public static string GetStringValue(this WayOfTransport wayOfTransport)
        {
            var type = typeof(WayOfTransport);
            var memberInfo = type.GetMember(wayOfTransport.ToString());
            var attributes = memberInfo[0].GetCustomAttributes(typeof(StringValueAttribute), false);

            return attributes.Length > 0 ? ((StringValueAttribute)attributes[0]).Value : null;
        }
    }
}
