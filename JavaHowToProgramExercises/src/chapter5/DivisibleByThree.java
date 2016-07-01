// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.12 page 238
// Exercise from Java:How to program 10th edition

package chapter5;

public class DivisibleByThree {

	public static void main(String[] args) {
		
		int total = 0;
		
		for (int i = 1; i <= 30; i++){
			if (i % 3 == 0)
				total += i;
		}
		
		System.out.println("Sum is: " + total);
	}
}
