package oip;

import java.util.Vector;
import functions.Rosenbrock;
import objects.God;
import objects.Individual;

public class TestRosenbrock {
	private static God g = new God(-1000, 1000, 50000, 30, 450, 2);
	
	public static void main(String[] args) {
		
		
		Vector<Individual> population = new Vector<Individual>();
		
		g.init();
		
		population = g.getPopulation();
		
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population = sendToRosenbrock(population);
		
		masterRace = g.getMasterRace(population);
		
		g.print(masterRace);
		
		population =  g.evolvePopulation(population);
		
		int i = 0;
		
		while (masterRace.elementAt(0).getResultValue() > 0.01){
			if (i == 500) break;
			System.out.println("Generation " + i);
			
			population = sendToRosenbrock(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population =  g.evolvePopulation(population);
			
			i++;
		}
		
		
		
		
		System.out.println("Done after Generation " + i);
		
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
