// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.17 page 189
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class TripCalculator {

	public static void main(String[] args) {

		// Initializing local variables
		Scanner input = new Scanner(System.in);
		int flag = 1;
		int totalMiles = 0;
		int totalGallons = 0;

		// Prompting the user if he want's to enter trip
		System.out.println("Would you like to enter trip? (0 - no, 1 - yes)");
		flag = input.nextInt();

		// Taking information about trip or trips from user
		while (flag != 0) {
			System.out.println("How many miles was your trip?");
			int miles = input.nextInt();
			System.out.println("How many gallons You used?");
			int gallons = input.nextInt();
			totalMiles += miles; // adding miles from this trip to total mileage
									// of user
			totalGallons += gallons; // ading gallons from this trip to total
										// gallons count of user
			if (gallons > 0) { // checking against division by 0
				double milesPerGallon = (double) miles / gallons;
				System.out.printf("On this trip your miles per gallon was %.2f", milesPerGallon);
			}else{
				System.out.println("No gallons amount provided!");
			}
			// Asking about next trip
			System.out.println("Would you like to enter next trip? (0 - no, 1 - yes)");
			flag = input.nextInt();
		}

		// Calculating and displaying total miles per gallon from all trips
		if (totalGallons > 0) {
			double averageMilesPerGallon = (double) totalMiles / totalGallons;
			System.out.printf("Your average miles per gallon from all trips was: %.2f", averageMilesPerGallon);
		}
		
		input.close();
	}

}
