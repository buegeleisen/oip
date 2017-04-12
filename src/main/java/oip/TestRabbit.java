package oip;

import java.util.Vector;

import api.PopulationPusher;
import api.PopulationReceiver;
import objects.God;
import objects.Individual;

public class TestRabbit {
	private static God g = new God(-100, 100, 10000, 30, 450, 17);
	
	public static void main(String[] args) {
		
		Vector<Individual> population = new Vector<Individual>();

		g.init();
		
		population = g.getPopulation();
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population= sendToRabbit(population);
		
		masterRace= g.getMasterRace(population);
		
		g.print(masterRace);
		
		population= g.evolvePopulation(population);
		
		int i = 0;
		
		while(masterRace.elementAt(0).getResultValue() > 0){
			
			System.out.println("Generation " + i);
			
			population=sendToRabbit(population);
			
			masterRace=g.getMasterRace(population);
			
			g.print(masterRace);
			
			population= g.evolvePopulation(population);
			
			i++;
		}
	
	}
	
	private static Vector<Individual> sendToRabbit(Vector<Individual> pop){
		Vector<Individual> fittedPopulation= new Vector<Individual>();
		PopulationPusher pp= new PopulationPusher("localhost", "Inbound");
		PopulationReceiver pr=new PopulationReceiver("localhost");
		pr.receivePopulation();
		
		pp.sendAllIndividuals(pop);
		
		fittedPopulation=pr.getFittedPopulation();
		
		return fittedPopulation;
	}

}
