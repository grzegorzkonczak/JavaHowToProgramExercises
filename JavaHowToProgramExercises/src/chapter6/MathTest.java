// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.3 page 276
// Exercise from Java:How to program 10th edition

package chapter6;

public class MathTest {

	public static void main(String[] args) {
		
		int x = 5;
		int y = 12;
		double z = 22.3;
		double a = 13.7;
		
		System.out.println(Math.abs(z));
		System.out.println(Math.ceil(z));
		System.out.println(Math.cos(a));
		System.out.println(Math.exp(x));
		System.out.println(Math.floor(z));
		System.out.println(Math.log(a));
		System.out.println(Math.max(x, y));
		System.out.println(Math.min(a, z));
		System.out.println(Math.pow(z, x));
		System.out.println(Math.sin(x));
		System.out.println(Math.sqrt(y));
		System.out.println(Math.tan(x));
		System.out.println(Math.ceil(-Math.abs(-3 + Math.floor(-2.5))));
	}
}
