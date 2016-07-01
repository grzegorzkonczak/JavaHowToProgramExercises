// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.13 page 238
// Exercise from Java:How to program 10th edition

package chapter5;

public class SumOfSeries {

	public static void main(String[] args) {
		
		long totalSum = 0L;
		long totalProduct = 1L;
		for (int i = 1; i <= 100; i++){
			totalSum += i;
			totalProduct *= i;
			System.out.printf("%3d   %10d%n", i, totalSum);
			//System.out.printf("%3d   %10d%n", i, totalProduct);
		}
	}
}
