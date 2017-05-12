package oip;

import java.util.Vector;

import api.PopulationPusher;
import api.PopulationReceiver;
import objects.God;
import objects.Individual;

public class GodThread extends Thread {
	private God g;
	private String inboundName = "Inbound";
	private String outboundName = "Outbound";
	private String exchangeName = "result";
	private String host = "localhost";
	private int stop = 0;
	
	public GodThread(God g) {
		this.g = g;
	}
	
	@Override
	public void run() {
		Vector<Individual> population = new Vector<Individual>();

		g.init();
		
		population = g.getPopulation();
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population= sendToRabbit(population);
		
		masterRace= g.getMasterRace(population);
		
		g.print(masterRace);
		
		population= g.evolvePopulation(population);
		
		int i = 0;
		
		while(masterRace.elementAt(0).getResultValue() > stop){
			
			System.out.println("Computing Generation " + i);
			
			population=sendToRabbit(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population = g.evolvePopulation(population);
			
			i++;
		}
		super.run();
	}
	
	private Vector<Individual> sendToRabbit(Vector<Individual> pop){
		Vector<Individual> fittedPopulation= new Vector<Individual>();
		PopulationPusher pp= new PopulationPusher(host, inboundName);
		PopulationReceiver pr=new PopulationReceiver(host, outboundName, exchangeName);
		pr.receivePopulation();
		
		pp.sendAllIndividuals(pop);
		
		fittedPopulation = pr.getFittedPopulation();
		
		return fittedPopulation;
	}
	
	

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	public God getG() {
		return g;
	}

	public void setG(God g) {
		this.g = g;
	}

	public String getInboundName() {
		return inboundName;
	}

	public void setInboundName(String inboundName) {
		this.inboundName = inboundName;
	}

	public String getOutboundName() {
		return outboundName;
	}

	public void setOutboundName(String outboundName) {
		this.outboundName = outboundName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getStop() {
		return stop;
	}

	public void setStop(int stop) {
		this.stop = stop;
	}
	
	
}
