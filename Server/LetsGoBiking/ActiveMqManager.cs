using Apache.NMS;
using Apache.NMS.ActiveMQ;
using Newtonsoft.Json;
using RoutingServer.Model;
using System;

namespace RoutingServer
{
    public class ActiveMqManager
    {
        private Uri connecturi = new Uri("activemq:tcp://localhost:61616");
        private ConnectionFactory connectionFactory;
        private IConnection connection;


        public ActiveMqManager()
        {
            connectionFactory = new ConnectionFactory(connecturi);

            connection = connectionFactory.CreateConnection();
            connection.Start();
        }

        public void Send(string queueName, RoutePart result)
        {
            var session = PrepareSend(queueName, out var producer);

            string jsonMessage = JsonConvert.SerializeObject(result);

            ITextMessage message = session.CreateTextMessage(jsonMessage);
            producer.Send(message);

            FinalizeSend(session);
        }

        private void FinalizeSend(ISession session)
        {
            // Don't forget to close your session and connection when finished.
            session.Close();
            connection.Close();
        }

        private ISession PrepareSend(string queueName, out IMessageProducer producer)
        {
            // Create a session from the Connection.
            var session = connection.CreateSession();

            // Use the session to target a queue.
            IDestination destination = session.GetQueue(queueName);

            // Create a Producer targetting the selected queue.
            producer = session.CreateProducer(destination);

            // You may configure everything to your needs, for instance:
            producer.DeliveryMode = MsgDeliveryMode.NonPersistent;
            return session;
        }
    }
}