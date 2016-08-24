// Grzegorz Koñczak, 24.08.2016
// Exercise number 18.23 page 851
// Exercise from Java:How to program 10th edition

package chapter18;

import java.math.BigInteger;

public class FibonacciEnchanced {

	private static int numberOfCalls = 0;
	private static BigInteger TWO = BigInteger.valueOf(2);

	// recursive declaration of method fibonacci
	public static BigInteger fibonacci(BigInteger number) {
		numberOfCalls++;
		if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) // base
																				// cases
			return number;
		else // recursion step
			return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(TWO)));
	}

	// displays the fibonacci values from 0-40
	public static void main(String[] args) {
		for (int counter = 0; counter <= 40; counter++){
			long time1 = System.currentTimeMillis();
			System.out.printf("Fibonacci of %d is: %d%n", counter, fibonacci(BigInteger.valueOf(counter)));
			long time2 = System.currentTimeMillis();
			System.out.println("It took " + (time2 - time1) + " miliseconds for this operation");
			System.out.println("It was " + numberOfCalls + " fibonacci calls to get here.");
			numberOfCalls = 0;
		}
	}

}
