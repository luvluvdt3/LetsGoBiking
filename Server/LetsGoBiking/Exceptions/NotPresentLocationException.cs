using System;

namespace RoutingServer.Exceptions
{
    public class NotPresentLocationException : Exception
    {
        public NotPresentLocationException(string locationName) : base($"Providen {locationName} location does not have any information in an app") { }
    }
}
