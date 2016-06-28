// Grzegorz Koñczak, 28.06.2016
// Exercise number 3.13 page 140
// Exercise from Java:How to program 10th edition

package chapter3;

public class DateTest {

	public static void main(String[] args) {
		
		Date date = new Date(12, 02, 2016);
		date.displayDate();
		
		date.setDay(28);
		date.setMonth(06);
		
		date.displayDate();
	}

}
