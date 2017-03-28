package oip;

import java.util.Vector;
import functions.Sphere;
import objects.God;
import objects.Individual;

public class TestSphere {
private static God g = new God(-1000, 1000, 100000, 30, 450, 17);
	
	public static void main(String[] args) {
		try{
			Vector<Individual> population = new Vector<Individual>();

			g.init();
			
			population = g.getPopulation();
			
			Vector<Individual>  masterRace = new Vector<Individual>();
			
			population = sendToSphere(population);
			
			masterRace = g.getMasterRace(population);
			
			g.print(masterRace);
			
			population =  g.evolvePopulation(population);
			
			int i = 0;
			
			while (masterRace.elementAt(0).getResultValue() > 0.1){
				
				System.out.println("Generation " + i);
				
				population = sendToSphere(population);
				
				masterRace = g.getMasterRace(population);
				
				g.print(masterRace);
				
				population =  g.evolvePopulation(population);
				
				i++;
			}
			
			System.out.println("Done after Generation " + i);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	
	private static Vector<Individual> sendToSphere(Vector<Individual> pop) throws Exception{
		Vector<Individual> fittedPopulation = new Vector<Individual>();
		Sphere s = new Sphere(17);
		
		for (int i = 0; i < pop.size(); i++){
			Individual individual = pop.elementAt(i);
			
			Double result = s.compute(individual.getSolutionVector());
			
			individual.setResultValue(result);
			
			fittedPopulation.addElement(individual);
			
		}
		
		return fittedPopulation;
	}
}
