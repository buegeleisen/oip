package api;

import com.rabbitmq.client.ConnectionFactory;
import objects.Individual;
import com.rabbitmq.client.Connection;
import com.google.gson.Gson;
import com.rabbitmq.client.Channel;

public class PopulationPusher {
	
	private String queueName="Inbound";
	private String host;

	public PopulationPusher(String host){
		this.host=host;
	}
	
	public PopulationPusher(String host, String queueName){
		this.host = host;
		this.queueName = queueName;
	}
		
	public void sendIndividual(Individual individual){
		try{
			ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost(host);
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    channel.queueDeclare(queueName,false, false, false, null);
		    
		    String message = makejson(individual);
		    
		    channel.basicPublish("", queueName, null, message.getBytes());
		    System.out.println(" Connector has sent: "+message+" ! (nice)");
		    
		    channel.close();
		    connection.close();
		}
		catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
		}
		
		
	}
		
	private String makejson(Individual individual){
			Gson g = new Gson();
			String individualAsJson = g.toJson(individual);			
			return individualAsJson;
		}
		

}
