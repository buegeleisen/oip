package api;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

import com.rabbitmq.client.Channel;

public class Connector {
	private final static String Queue_name="Inbound";
	JSONParser parser =new JSONParser();
	private String host;
	public Connector(String host){
		this.host=host;
	}
	public void run(){
		try{
			
			ConnectionFactory factory = new ConnectionFactory();
		    factory.setHost(host);
		    Connection connection = factory.newConnection();
		    Channel channel = connection.createChannel();
		    
		    channel.queueDeclare(Queue_name,false, false, false, null);
		    JSONObject json=makejson();
		    
		    String message=json.toString();
		    channel.basicPublish("", Queue_name, null, message.getBytes());
		    System.out.println(" Connector has sent: "+message+" ! (nice)");
		    
		    channel.close();
		    connection.close();
		}
		catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
		}
		
		
	}
	
	public JSONObject makejson() throws Exception{
		Object obj=parser.parse(new FileReader("C:/Users/migue/Documents/dev/oip/json_example.txt"));
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
	
}
