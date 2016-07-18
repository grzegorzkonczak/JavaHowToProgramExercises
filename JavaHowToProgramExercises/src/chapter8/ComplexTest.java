// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.11 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class ComplexTest {

	public static void main(String[] args) {
		
		Complex number1 = new Complex(3,5);
		Complex number2 = new Complex();
		Complex number3 = new Complex(4,7);
		
		Complex number4 = number1.add(number2);
		Complex number5 = number3.subtract(number4);
		
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(number3);
		System.out.println(number4);
		System.out.println(number5);
	}
}
