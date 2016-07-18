// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.8 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class DateEnchancedTest {

	public static void main(String[] args) {
		
		DateEnchanced date = new DateEnchanced(2, 28, 2015);
		
		System.out.println(date);
		date.nextDay();
		System.out.println(date);
	}
}
