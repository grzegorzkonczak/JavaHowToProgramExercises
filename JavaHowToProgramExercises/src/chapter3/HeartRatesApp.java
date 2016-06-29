// Grzegorz Koñczak, 29.06.2016
// Exercise number 3.16 page 141
// Exercise from Java:How to program 10th edition

package chapter3;

import java.util.Scanner;

public class HeartRatesApp {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int day;
		int month;
		int year;
		String firstName;
		String lastName;
		
		System.out.print("Enter first name: ");
		firstName = input.nextLine();
		System.out.print("Enter last name: ");
		lastName = input.nextLine();
		System.out.print("Enter day of birth: ");
		day = input.nextInt();
		System.out.print("Enter month of birth: ");
		month = input.nextInt();
		System.out.print("Enter year of birth: ");
		year = input.nextInt();
		
		HeartRates person1 = new HeartRates(firstName, lastName, day, month, year);
		
		System.out.printf("Hello %s %s!%nYou were born %d/%02d/%d%n%n", firstName, lastName, day, month, year);
		System.out.printf("You are %d years old.%nYour max heart rate - %dbpm%nYour target heart rate is about - %dbpm",
				person1.calculateAge(), person1.calculateMax(), person1.calculateTarget());
		
		input.close();
	}

}
