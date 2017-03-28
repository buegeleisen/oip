package oip;

import java.util.Vector;
import functions.Himmelblau;
import objects.God;
import objects.Individual;

public class TestHimmelblau {
private static God g = new God(-100, 100, 10000, 30, 450, 2);
	
	public static void main(String[] args) {
		
		Vector<Individual> population = new Vector<Individual>();
		
		g.init();
		
		population = g.getPopulation();
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population = sendToHimmelblau(population);
		
		masterRace = g.getMasterRace(population);
		
		g.print(masterRace);
		
		population =  g.evolvePopulation(population);
		
		int i = 0;
		
		while (masterRace.elementAt(0).getResultValue() > 0.01){
			
			System.out.println("Generation " + i);
			
			population = sendToHimmelblau(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population =  g.evolvePopulation(population);
			
			i++;
		}
		
		
		
		
		System.out.println("Done after Generation " + i);
		
	}
	
	
	private static Vector<Individual> sendToHimmelblau(Vector<Individual> pop){
		Vector<Individual> fittedPopulation = new Vector<Individual>();
		Himmelblau h = new Himmelblau();
		
		for (int i = 0; i < pop.size(); i++){
			Individual individual = pop.elementAt(i);
			
			Double result = h.compute(individual.getSolutionVector()[0], individual.getSolutionVector()[1]);
			
			individual.setResultValue(result);
			
			fittedPopulation.addElement(individual);
			
		}
		
		return fittedPopulation;
	}
}
