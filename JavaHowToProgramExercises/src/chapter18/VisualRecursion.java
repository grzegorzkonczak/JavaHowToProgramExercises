// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.10 page 848
// Exercise from Java:How to program 10th edition

package chapter18;

public class VisualRecursion {

	// recursive method factorial (assumes its parameter is >= 0
	public static long factorial(long number) {
		if (number <= 1) // test for base case
			return 1; // base cases: 0! = 1 and 1! = 1
		else // recursion step
			System.out.print(number + (number == 2 ? "\n equals to " : " * "));
			return number * factorial(number - 1);
	}

	// output factorials for values 0-21
	public static void main(String[] args) {
		// calculate the factorials of 0 through 21
		for (int counter = 0; counter <= 21; counter++)
			System.out.printf("%d! = %d%n", counter, factorial(counter));
	}
	// end
	// class
}
