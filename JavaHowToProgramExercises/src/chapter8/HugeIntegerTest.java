// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.16 page 400
// Exercise from Java:How to program 10th edition

package chapter8;

public class HugeIntegerTest {

	public static void main(String[] args) {
		
		HugeInteger test1 = new HugeInteger();
		
		test1.parse("20900");
		System.out.println(test1);
		
		
		HugeInteger test2 = new HugeInteger();
		test2.parse("3007896");
		System.out.println(test2);
		
		HugeInteger test3 = test1.add(test2);
		
		System.out.println(test3);
		
		HugeInteger test4 = new HugeInteger();
		test4.parse("229999999998345673456789879990000000000");
		HugeInteger test5 = new HugeInteger();
		test5.parse("229999999998345673456789879990000000000");
		
		HugeInteger test6 = test4.subtract(test5);
		System.out.println(test6);
		
		System.out.println(test6.isZero());
		System.out.println(test4.isGraterThenOrEqual(test5));
		
		System.out.println(test3.isEqualTo(test2));
		System.out.println(test1.isLessThen(test3));
		
		System.out.println(test4.isGraterThen(test5));
	}
}
