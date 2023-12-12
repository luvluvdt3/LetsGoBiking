using System;
using System.ServiceModel.Description;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.ServiceModel.Channels;
using System.ServiceModel.Dispatcher;
using System.ServiceModel.Configuration;

namespace RoutingServer
{
    public class Program
    {
        public static void Main(string[] args)
        {
            using (ServiceHost host = new ServiceHost(typeof(RoutingService)))
            {

                // Open the ServiceHost to start listening for messages. Since
                // no endpoints are explicitly configured, the runtime will create
                // one endpoint per base address for each service contract implemented
                // by the service.
                host.Open();
                Console.WriteLine("Routing working...");
                Console.WriteLine("Press <Enter> to stop the service.");
                Console.ReadLine();

                // Close the ServiceHost.
                host.Close();
            }
        }
    }


    public class CorsMessageInspector : IDispatchMessageInspector
    {
        public object AfterReceiveRequest(ref Message request, IClientChannel channel, InstanceContext instanceContext)
        {
            Console.WriteLine("I am here");
            return null;
        }

        public void BeforeSendReply(ref Message reply, object correlationState)
        {
            Console.WriteLine("I am here too");
            HttpResponseMessageProperty responseProperty;

            if (reply.Properties.TryGetValue(HttpResponseMessageProperty.Name, out object httpResponseObject))
            {
                responseProperty = (HttpResponseMessageProperty)httpResponseObject;
            }
            else
            {
                responseProperty = new HttpResponseMessageProperty();
                reply.Properties.Add(HttpResponseMessageProperty.Name, responseProperty);
            }

            responseProperty.Headers.Add("Access-Control-Allow-Origin", "*");
            responseProperty.Headers.Add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            responseProperty.Headers.Add("Access-Control-Allow-Headers", "Content-Type, Accept");

            WebOperationContext.Current?.OutgoingResponse.Headers.Add("Access-Control-Allow-Credentials", "true");
        }
    }

    public class CorsBehaviorExtensionElement : BehaviorExtensionElement, IEndpointBehavior
    {
        public override Type BehaviorType { get => typeof(CorsBehaviorExtensionElement); }

        protected override object CreateBehavior() => new CorsBehaviorExtensionElement();

        public void AddBindingParameters(ServiceEndpoint endpoint, BindingParameterCollection bindingParameters) { }

        public void ApplyClientBehavior(ServiceEndpoint endpoint, ClientRuntime clientRuntime) { }

        public void ApplyDispatchBehavior(ServiceEndpoint endpoint, EndpointDispatcher endpointDispatcher)
        {
            endpointDispatcher.DispatchRuntime.MessageInspectors.Add(new CorsMessageInspector());
        }

        public void Validate(ServiceEndpoint endpoint) { }
    }


}
