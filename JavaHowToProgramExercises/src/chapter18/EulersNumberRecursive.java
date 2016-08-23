// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.14 page 849
// Exercise from Java:How to program 10th edition

package chapter18;

public class EulersNumberRecursive {

	public static void main(String[] args) {
		double result = eulersNumber(25);
		System.out.println(result);
	}
	
	
	private static double eulersNumber(double n) {
		if ((int)n == 0){
			return 1.0;
		} else {
			return ((1.0 / factorial((int)n) + eulersNumber(n - 1.0)));
		}
	}


	// recursive method factorial (assumes its parameter is >= 0
	public static long factorial(long number) {
		if (number <= 1) // test for base case
			return 1; // base cases: 0! = 1 and 1! = 1
		else // recursion step
		return number * factorial(number - 1);
	}
}