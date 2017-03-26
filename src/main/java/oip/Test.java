package oip;

import java.util.Vector;

import api.PopulationPusher;
import functions.Rosenbrock;
import objects.God;
import objects.Individual;

public class Test {
	private static God g = new God();
	
	public static void main(String[] args) {
		
		
		Vector<Individual> population = new Vector<Individual>();
//		PopulationPusher pusher = new PopulationPusher("localhost", "Inbound");
		
		g.init();
		
		population = g.getPopulation();
		
//		pusher.sendIndividual(individual);
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population = sendToRosenbrock(population);
		
		masterRace = g.getMasterRace(population);
		
		g.print(masterRace);
		
		population =  g.evolvePopulation(population);
		
		while (masterRace.elementAt(0).getResultValue() > 0.5 ){
			population = sendToRosenbrock(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population =  g.evolvePopulation(population);
			
		}
		
		
		
		
		System.out.println("Done");
		
	}
	
	
	private static Vector<Individual> sendToRosenbrock(Vector<Individual> pop){
		Vector<Individual> fittedPopulation = new Vector<Individual>();
		Rosenbrock r = new Rosenbrock();
		
		for (int i = 0; i < pop.size(); i++){
			Individual individual = pop.elementAt(i);
			
			Double result = r.compute(individual.getSolutionVector()[0], individual.getSolutionVector()[1]);
			
			individual.setResultValue(result);
			
			fittedPopulation.addElement(individual);
			
		}
		
		return fittedPopulation;
	}
	
	
}
