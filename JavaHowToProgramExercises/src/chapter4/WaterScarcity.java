// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.39 page 193
// Exercise from Java:How to program 10th edition

package chapter4;

public class WaterScarcity {

	public static void main(String[] args) {
		
		long population = 93385095;
		double growthRate = 0.02;
		int waterPerCapita = 937;
		long totalWaterAllowed = 60000000000L;
		int year = 2016;
		int counter = 15;
		
		while(counter > 0){
			System.out.printf("%d   %d   %d%n", year, population * waterPerCapita,
					totalWaterAllowed - (population * waterPerCapita));
			population *= (1 + growthRate);
			counter--;
			year++;
		}
	}
}
