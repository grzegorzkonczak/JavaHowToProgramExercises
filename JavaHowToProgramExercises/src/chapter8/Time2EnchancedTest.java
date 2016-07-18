// Grzegorz Koñczak, 16.07.2016
// Exercise number 8.7 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class Time2EnchancedTest {
	public static void main(String[] args) {
		Time2Enchanced t1 = new Time2Enchanced(); // 00:00:00
		Time2Enchanced t2 = new Time2Enchanced(2); // 02:00:00
		Time2Enchanced t3 = new Time2Enchanced(21, 34); // 21:34:00
		Time2Enchanced t4 = new Time2Enchanced(14, 59, 59); // 12:25:42
		Time2Enchanced t5 = new Time2Enchanced(t4); // 12:25:42

		System.out.println("Constructed with:");
		displayTime("t1: all default arguments", t1);
		displayTime("t2: hour specified; default minute and second", t2);
		displayTime("t3: hour and minute specified; default second", t3);
		displayTime("t4: hour, minute and second specified", t4);
		displayTime("t5: Time2 object t4 specified", t5);

		// attempt to initialize t6 with invalid values
		try {
			Time2Enchanced t6 = new Time2Enchanced(27, 74, 99); // invalid
																// values
		} catch (IllegalArgumentException e) {
			System.out.printf("%nException while initializing t6: %s%n", e.getMessage());
		}
		
		t5.incrementHour();
		t5.incrementMinute();
		
		displayTime("Incremented", t5);
	}

	// displays a Time2 object in 24-hour and 12-hour formats
	private static void displayTime(String header, Time2Enchanced t) {
		System.out.printf("%s%n   %s%n   %s%n", header, t.toUniversalString(), t.toString());
	}
} // end class Time2Test