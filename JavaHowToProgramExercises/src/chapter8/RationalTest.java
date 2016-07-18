// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.15 page 399
// Exercise from Java:How to program 10th edition

package chapter8;

public class RationalTest {

	public static void main(String[] args) {
		
		Rational test1 = new Rational(5, 6);
		Rational test2 = new Rational(8, 16);
		Rational test3 = new Rational(6, 9);
		Rational test5 = new Rational(6, 20);
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		
		System.out.println(test1.toStringFloat(4));
		System.out.println(test2.toStringFloat(4));
		System.out.println(test3.toStringFloat(4));
		
		Rational test4 = Rational.subtract(test2, test1);
		System.out.println(test4);
		
		Rational test6 = Rational.add(test4, test5);
		System.out.println(test6);
		System.out.println(test6.toStringFloat(3));
		
		test6 = Rational.multiply(test2, test3);
		System.out.println(test6);
		
		
	}
}
