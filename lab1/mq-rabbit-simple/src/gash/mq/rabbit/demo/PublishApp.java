package gash.mq.rabbit.demo;

import gash.mq.rabbit.core.MQueueFactory;
import gash.mq.rabbit.core.MQueueProducer;
import gash.mq.rabbit.core.MQueuePublisher;

import com.rabbitmq.client.AMQP;
import java.util.Scanner;

public class PublishApp {

  private MQueuePublisher pub;
  private Scanner reader;

  PublishApp() {
    //super(channel, queue);
    String host = "localhost";
    String user = "test";
    String passwd = "test";
    reader = new Scanner(System.in);

    MQueueFactory factory = new MQueueFactory(host, AMQP.PROTOCOL.PORT, user, passwd);
    pub = factory.createPublisher("pubsub-demo");
  }

  public void addBindingFilter(String v) {
    //pub.addTopic(v);
  }

  public void demo(String topic) throws Exception {
    String s = reader.nextLine();
    try {
      pub.publish(s, topic);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    System.out.print("** RabbitMQ pub-sub - Publisher of ");
    System.out.print(args[0]);
    System.out.println("**\n");

    PublishApp pa = new PublishApp();

    while (true) {
      try {
        pa.demo(args[0]);
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }
  }
}
