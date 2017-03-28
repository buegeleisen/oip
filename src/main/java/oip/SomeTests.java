package oip;

import java.util.Collections;
import java.util.Vector;

import objects.Individual;

public class SomeTests {
	public static void main(String[] args) {
		Double[] d = new Double[2];
		Individual individual = new Individual("1", d, 1.0, true, true);
		Individual individual2 = new Individual("2", d, -1.0, true, true);
		Individual individual3 = new Individual("3", d, -5.454, true, true);
		Vector<Individual> vector = new Vector<Individual>();
		vector.addElement(individual);
		vector.addElement(individual2);
		vector.addElement(individual3);
		Collections.sort(vector);
		
		for(int i = 0; i< vector.size(); i++){
			System.out.println(vector.elementAt(i).getResultValue());
		}
		
	}
}
