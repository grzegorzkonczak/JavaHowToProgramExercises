// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.19 page 343
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.Scanner;

public class AirlineReservationSystem {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		boolean[] reservations = new boolean[10];

		while (true) {
			System.out.print("Please type 1 for First class and 2 for Economy: ");
			int choice = input.nextInt();
			boolean seatAvailable = checkForSeat(reservations, choice);
			if (seatAvailable)
				assaingSeat(reservations, choice);
			else
				proposeOtherClass(reservations, choice);
		}
	}

	private static void proposeOtherClass(boolean[] reservations, int choice) {
		if (choice == 1) {
			choice = 2;
		} else {
			choice = 1;
		}

		boolean seatAvailable = checkForSeat(reservations, choice);

		if (seatAvailable) {
			System.out.println("Is it acceptable to chancge class? 1 - yes, 2 - no");
			int classChange = input.nextInt();
			if (classChange == 1) {
				assaingSeat(reservations, choice);
			} else {
				System.out.println("Next flight leaves in 3 hours");
			}
		}else{
			System.out.println("Next flight leaves in 3 hours");
		}

	}

	private static void assaingSeat(boolean[] reservations, int choice) {
		for (int i = (choice * 5) - 5; i < reservations.length; i++) {
			if (reservations[i] == false) {
				reservations[i] = true;
				System.out.println("Your place number is " + (i + 1));
				break;
			}
		}
	}

	private static boolean checkForSeat(boolean[] reservations, int choice) {
		for (int i = (choice * 5) - 5; i < reservations.length; i++) {
			if (reservations[i] == false)
				return true;
		}
		return false;
	}
}
