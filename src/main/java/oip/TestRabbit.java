package oip;

import java.util.Vector;

import api.PopulationPusher;
import api.PopulationReceiver;
import objects.God;
import objects.Individual;

public class TestRabbit {
	
	public static void main(String[] args) {
		God g = new God(-30, 30, 10000, 30, 300, 17);
		
		Vector<Individual> population = new Vector<Individual>();

		g.init();
		
		population = g.getPopulation();
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population= sendToRabbit(population);
		
		masterRace = g.getMasterRace(population);
		
		g.print(masterRace);
		
		population= g.evolvePopulation(population);
		
		int i = 1;
		
		while(masterRace.elementAt(0).getResultValue() > -1000){
			
			System.out.println("Generation " + i);
			
			population=sendToRabbit(population);
			
			masterRace=g.getMasterRace(population);
			
			//g.print(masterRace);
			g.printBest(masterRace);
			
			System.out.println(masterRace.elementAt(0).isFeasable());
			
			population= g.evolvePopulation(population);
			
			i++;
		}
	
	}
	
	private static Vector<Individual> sendToRabbit(Vector<Individual> pop){
		Vector<Individual> fittedPopulation= new Vector<Individual>();
		PopulationPusher pp= new PopulationPusher("192.168.99.100", "Inbound");
		PopulationReceiver pr=new PopulationReceiver("192.168.99.100");
		pr.receivePopulation();
		
		pp.sendAllIndividuals(pop);
		
		fittedPopulation = pr.getFittedPopulation();
		
		return fittedPopulation;
	}

}
