// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.15 page 399
// Exercise from Java:How to program 10th edition

package chapter8;

public class GreatestCommonDivisor {

	public static int gcd(int number1, int number2){
		boolean divisorFound = false;
		
		while (!divisorFound){
			int tempMax = Math.max(number1, number2);
			int tempMin = Math.min(number1, number2);
			number1 = Math.abs(tempMax);
			number2 = Math.abs(tempMin);
			number1 = number1 - number2;
			if(number1 == number2)
				divisorFound = true;
		}
		return number1;
	}
}
