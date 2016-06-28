// Grzegorz Koñczak, 28.06.2016
// Exercise number 2.34 page 110
// Exercise from Java:How to program 10th edition

package chapter2;

public class Exercise2_35 {

	public static void main(String[] args) {
		
		int stonesNumber = 2300000;
		int stonesWeight = 15;
		int buildYears = 14;
		int buildHours = buildYears * 365 * 24;
		int buildMinutes = buildHours * 60;
		
		int year = (stonesNumber * stonesWeight) / buildYears;
		int hour = (stonesNumber * stonesWeight) / buildHours;
		int minute = (stonesNumber * stonesWeight) / buildMinutes * 1000;
		
		System.out.printf("Piramid was built:%nEvery year: %d tons%nEvery hour: %d tons%nEvery minute: %d kg%n",
				year, hour, minute);
		
		
	}

}
