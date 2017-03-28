package oip;

import java.util.Vector;

import functions.Easom;
import objects.God;
import objects.Individual;

public class TestEasom {
private static God g = new God(-100, 100, 10000, 30, 450, 2);
	
	public static void main(String[] args) {
		
		Vector<Individual> population = new Vector<Individual>();

		g.init();
		
		population = g.getPopulation();
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population = sendToEasom(population);
		
		masterRace = g.getMasterRace(population);
		
		g.print(masterRace);
		
		population =  g.evolvePopulation(population);
		
		int i = 0;
		
		while (masterRace.elementAt(0).getResultValue() > -0.9999999){
			
			System.out.println("Generation " + i);
			
			population = sendToEasom(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population =  g.evolvePopulation(population);
			
			i++;
		}
		
		System.out.println("Done after Generation " + i);
		
	}
	
	
	private static Vector<Individual> sendToEasom(Vector<Individual> pop){
		Vector<Individual> fittedPopulation = new Vector<Individual>();
		Easom e = new Easom();
		
		for (int i = 0; i < pop.size(); i++){
			Individual individual = pop.elementAt(i);
			
			Double result = e.compute(individual.getSolutionVector()[0], individual.getSolutionVector()[1]);
			
			individual.setResultValue(result);
			
			fittedPopulation.addElement(individual);
			
		}
		
		return fittedPopulation;
	}
}
