package oip;

import java.util.Vector;

import functions.Eggholder;
import objects.God;
import objects.Individual;

public class TestEggholder {
private static God g = new God(-512, 512, 100000, 30, 1000, 2);
	
	public static void main(String[] args) {
		
		
		Vector<Individual> population = new Vector<Individual>();
//		PopulationPusher pusher = new PopulationPusher("localhost", "Inbound");
		
		g.init();
		
		population = g.getPopulation();
		
//		pusher.sendIndividual(individual);
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population = sendToEggholder(population);
		
		masterRace = g.getMasterRace(population);
		
		g.print(masterRace);
		
		population =  g.evolvePopulation(population);
		
		int i = 0;
		
		while (masterRace.elementAt(0).getResultValue() > -959){
			
			System.out.println("Generation " + i);
			
			population = sendToEggholder(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population =  g.evolvePopulation(population);
			
			i++;
		}
		
		
		
		
		System.out.println("Done after Generation " + i);
		
	}
	
	private static Vector<Individual> sendToEggholder(Vector<Individual> pop){
		Vector<Individual> fittedPopulation = new Vector<Individual>();
		Eggholder e = new Eggholder();
		
		for (int i = 0; i < pop.size(); i++){
			Individual individual = pop.elementAt(i);
			
			Double result = e.compute(individual.getSolutionVector()[0], individual.getSolutionVector()[1]);
			
			individual.setResultValue(result);
			
			fittedPopulation.addElement(individual);
			
		}
		
		return fittedPopulation;
	}
}
