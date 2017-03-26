package objects;

import java.util.Collections;
import java.util.Vector;

public class God {
	
	/***
	 *  Default Constructor using default values
	 */
	
	public God() {
		
	}
	
	/***
	 * Constructor to specify algorithm
	 * @param rangeMin The min value of the internal Individual values
	 * @param rangeMax The max value of the internal Individual values
	 * @param populationCount The size of the Population
	 * @param survivor Value of the survivors
	 * @param dimension Size of dimensions of the Individuals
	 */
	public God(int rangeMin, int rangeMax, int populationCount, int survivor, int dimension){
		this.populationCount = populationCount;
		this.survivor = survivor;
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.dimension = dimension;
	}
	
	//initial value of candidate counts
	private int populationCount = 120; 
	
	//set the count of surviving Individuals
	private int survivor = 10;
	
	//max value of candidate values
	private int rangeMax = 100;
	
	//min value of  candidate values
	private int rangeMin = 0;
	
	//set dimensions of Candidates
	private int dimension = 2;
	
	//set count of mutation clones
	private int mutation = 20;
	
	//population is stored here
	private Vector<Individual> population = new Vector<Individual>();
	
	/***
	 * initializes the Population
	 */
	public void init(){
		for(int i = 0; i < populationCount; i++){
			Double[] values = new Double[dimension];
			
			for (int j = 0; j < dimension; j++){
				values[j] = (rangeMin+(rangeMax-rangeMin)*Math.random()); 
			}
			
			Individual ind = new Individual("id" + i, values, 0.0, false, false);
			
			population.addElement(ind);
		}
	}
	
	/***
	 * Evolves the population for a better result set
	 * 
	 * @param fittedPopulation
	 * @return a new and better population
	 */
	
	public Vector<Individual> evolvePopulation(Vector<Individual> fittedPopulation){
		Vector<Individual> evolvedPopulation = new Vector<Individual>();
		
		try {
			evolvedPopulation = mutatePopulation(crossoverPopulation(getMasterRace(fittedPopulation)));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return evolvedPopulation;
	}
	
	/***
	 * 
	 * @param population The Population who gets children and builds an new Generation
	 * @return a new Generation
	 */
	private Vector<Individual> crossoverPopulation(Vector<Individual> population){
		Vector<Individual> newPopulation = new Vector<Individual>();
		
		for (int i = 0; i < population.size(); i ++){
			Individual a = population.elementAt(i);
			for (int j = 0; j < population.size(); j++){
				Individual b = population.elementAt(j);
				Double[] newArray = new Double[dimension];
				for (int k = 0; k < dimension; k ++){
					Double valueA = a.getSolutionVector()[k];
					Double valueB = b.getSolutionVector()[k];
					
					Double newValue = valueA * 0.5 + valueB * 0.5;
					
					newArray[k] = newValue;
				}
				
				Individual crossedIndividual = new Individual("id", newArray, 0.0, true, true);
				
				newPopulation.addElement(crossedIndividual);
			}
		}
		
		return newPopulation;
	}
	
	/***
	 * 
	 * @param population The Population with parents and children
	 * @return 
	 * @throws CloneNotSupportedException 
	 */
	private Vector<Individual> mutatePopulation(Vector<Individual> population) throws CloneNotSupportedException{
		Vector<Individual> mutatedPopulation = new Vector<Individual>();
		mutatedPopulation.addAll(population);
		
		for(int i = 0; i < mutation; i++){
			int mutantNr =  (int) (mutatedPopulation.size() * Math.random());
			
			Individual mutant = (Individual) mutatedPopulation.elementAt(mutantNr).clone();
			
			int mutantValueCount = (int) Math.round(dimension * Math.random());
			
			for(int j = 0; j < mutantValueCount; j++){
				int mutantValue = (int) (dimension * Math.random());
				
				mutant.getSolutionVector()[mutantValue] =  (rangeMin+(rangeMax-rangeMin)*Math.random());
				
				mutatedPopulation.addElement(mutant);
			}
			
		}
		
		return mutatedPopulation;
	}
	
	/***
	 * 
	 * @param fittedPopulation
	 * @return
	 */
	public Vector<Individual> getMasterRace(Vector<Individual> fittedPopulation){
		Collections.sort(fittedPopulation);
		Vector<Individual> masterRace = new Vector<Individual>();
		
		for (int i = 0; i < survivor; i++){
			masterRace.addElement((fittedPopulation.elementAt(i)));
		}
		
		return masterRace;
	}
	
	public void print(Vector<Individual> population) {
		for (int i = 0; i < population.size(); i++){
			System.out.println("Element " + i);
			for(int j = 0; j < dimension; j++){
				System.out.println("Element at " + i + " with value " + j + " as " + population.elementAt(i).getSolutionVector()[j]);
			}
			System.out.println("Result of Element " + i + " : " +  population.elementAt(i).getResultValue());
					}
		System.out.println(" ");
	}
	
	public Vector<Individual> getPopulation() {
		return population;
	}
	
	
}
