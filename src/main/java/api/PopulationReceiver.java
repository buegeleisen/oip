package api;

import java.io.IOException;
import java.util.Vector;

import com.google.gson.Gson;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import objects.Individual;

public class PopulationReceiver {
	private String Queue_name="Outbound";
	private String Exchange_name="results";
	private String host;
	private Gson gson = new Gson();
	Vector<Individual> fittedPopulation = new Vector<Individual>();
	
	public PopulationReceiver(String host){
		this.host=host;
	}
	
	public void receivePopulation(){
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
		          Individual individual = gson.fromJson(message, Individual.class);
		          
		          
		          fittedPopulation.addElement(individual);
		          
		          //System.out.println(" Receiver received: " + message + " !");
		        }
		      };
		      
		      channel.basicConsume(Queue_name, true, consumer);
		    
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Vector<Individual> getFittedPopulation() {
		return fittedPopulation;
	}

	public void setFittedPopulation(Vector<Individual> fittedPopulation) {
		this.fittedPopulation = fittedPopulation;
	}
}
