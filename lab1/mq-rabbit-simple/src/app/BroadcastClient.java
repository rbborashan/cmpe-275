package app;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class BroadcastClient {

  public static void testPostHello() throws Exception {

		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare("hello", false, false, false, null);

		String message = "Hello World!";
		channel.basicPublish("", "hello", null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();

	}

  public static void main(String[] args) {

    try {
      testPostHello();
    } catch(Exception e) {
      e.printStackTrace();
    }

  }
}
