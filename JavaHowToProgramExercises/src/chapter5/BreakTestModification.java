// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.26 page 240
// Exercise from Java:How to program 10th edition

package chapter5;

public class BreakTestModification {
	
	public static void main(String[] args) {
		
		int count; // control variable also used after loop terminates

		for (count = 1; (count <= 10) && (count != 5); count++) // loop 10 times
		{
			
			System.out.printf("%d ", count);
		}

		System.out.printf("%nBroke out of loop at count = %d%n", count);
	}
}
