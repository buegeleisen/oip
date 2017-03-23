package api;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Receiver {
	private final static String Queue_name="Outbound";
	private final static String Exchange_name="results";
	private String host;
	
	public Receiver(String host){
		this.host=host;
	}
	
	public void run(){
		try{
			ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost(host);
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();

		    channel.queueDeclare(Queue_name, true, false, false, null);
		    channel.exchangeDeclare(Exchange_name,"fanout",false);
		    channel.queueBind(Queue_name, Exchange_name, "test");
		    
		    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		    
		    Consumer consumer = new DefaultConsumer(channel) {
		        @Override
		        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
		            throws IOException {
		          String message = new String(body, "UTF-8");
		          System.out.println(" Receiver received: " + message + " !");
		        }
		      };
		      channel.basicConsume(Queue_name, true, consumer);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
