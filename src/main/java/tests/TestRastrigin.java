package tests;

import java.util.Vector;

import functions.Rastrigin;
import objects.God;
import objects.Individual;

public class TestRastrigin {
private static God g = new God(-100, 100, 10000, 30, 450, 2);
	
	public static void main(String[] args) {
		
		Vector<Individual> population = new Vector<Individual>();

		g.init();
		
		population = g.getPopulation();
		
		Vector<Individual>  masterRace = new Vector<Individual>();
		
		population = sendToRastrigin(population);
		
		masterRace = g.getMasterRace(population);
		
		g.print(masterRace);
		
		population =  g.evolvePopulation(population);
		
		int i = 0;
		
		//while (masterRace.elementAt(0).getResultValue() > 0.0001){
		while(i < 10){
			
			System.out.println("Generation " + i);
			
			population = sendToRastrigin(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population =  g.evolvePopulation(population);
			
			i++;
		}
		
		System.out.println("Done after Generation " + i);
		
	}
	
	
	private static Vector<Individual> sendToRastrigin(Vector<Individual> pop){
		Vector<Individual> fittedPopulation = new Vector<Individual>();
		Rastrigin r = new Rastrigin(100);
		
		for (int i = 0; i < pop.size(); i++){
			Individual individual = pop.elementAt(i);
			
			Double result = r.compute(individual.getSolutionVector()[0], individual.getSolutionVector()[1]);
			
			individual.setResultValue(result);
			
			fittedPopulation.addElement(individual);
			
		}
		
		return fittedPopulation;
	}
}
