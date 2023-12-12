using System;
using System.ServiceModel.Description;
using System.ServiceModel;

namespace JCDecauxProxy
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Uri baseAddress = new Uri("http://localhost:8090/LetsGoBiking/ProxyService/");

            ServiceHost host = new ServiceHost(typeof(ProxyService), baseAddress);

            ServiceMetadataBehavior smb = new ServiceMetadataBehavior
            {
                HttpGetEnabled = true,
                HttpsGetEnabled = true
            };
            host.Description.Behaviors.Add(smb);

            ServiceDebugBehavior debugBehavior = host.Description.Behaviors.Find<ServiceDebugBehavior>();
            if (debugBehavior == null)
            {
                debugBehavior = new ServiceDebugBehavior
                {
                    IncludeExceptionDetailInFaults = true
                };
                host.Description.Behaviors.Add(debugBehavior);
            }
            else
            {
                debugBehavior.IncludeExceptionDetailInFaults = true;
            }
            host.Open();

            Console.WriteLine("Service is hosted at " + DateTime.Now.ToString());
            Console.WriteLine("Host is running... Press <Enter> key to stop");
            Console.ReadLine();
        }
    }
}
