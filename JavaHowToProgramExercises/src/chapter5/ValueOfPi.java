// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.20 page 239
// Exercise from Java:How to program 10th edition

package chapter5;

public class ValueOfPi {

	public static void main(String[] args) {

		double piEstimate = 4.0;
		int evenOddCounter = 1;
		int passCounter = 1;

		for (int i = 3; i < 400000; i += 2) {
			if (evenOddCounter == 1) {
				piEstimate -= 4 / (double)i;
				evenOddCounter++;
				passCounter++;
			}else{
				piEstimate += 4 / (double)i;
				evenOddCounter--;
				passCounter++;
			}
			System.out.println("Pass: " + passCounter + ", Pi estimate " + piEstimate);
		}
	}
}
