// Grzegorz Koñczak, 02.07.2016
// Exercise number 5.33 page 241
// Exercise from Java:How to program 10th edition

package chapter5;

public class PopulationGrowth {

	public static void main(String[] args) {
		
		long startingPopulation = 1350000000;
		long futurePopulation;
		int time = 10;
		
		for (int i = 1; i < 8; i++){
			futurePopulation = (long) ((long)startingPopulation * Math.exp(((double)i / 100) * time));
			System.out.println("In " + time + " years the China population will be " + futurePopulation + " if growth rate would be " + i + "%");
		}
	}
}
