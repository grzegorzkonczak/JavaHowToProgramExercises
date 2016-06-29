// Grzegorz Koñczak, 29.06.2016
// Exercise number 3.17 page 141
// Exercise from Java:How to program 10th edition

package chapter3;

import java.util.Scanner;

public class HealthProfileApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// All necessary variables
		int day;
		int month;
		int year;
		String gender;
		String firstName;
		String lastName;
		double weight;
		double height;

		// Prompting user for data about him
		System.out.print("Enter first name: ");
		firstName = input.nextLine();
		System.out.print("Enter last name: ");
		lastName = input.nextLine();
		System.out.print("Enter your gender: ");
		gender = input.nextLine();
		System.out.print("Enter day of birth: ");
		day = input.nextInt();
		System.out.print("Enter month of birth: ");
		month = input.nextInt();
		System.out.print("Enter year of birth: ");
		year = input.nextInt();
		System.out.print("Enter your weight in kilograms: ");
		weight = input.nextDouble();
		System.out.print("Enter your height in meters: ");
		height = input.nextDouble();
		
		// Creating health profile of user
		HealthProfile person1 = new HealthProfile(firstName, lastName, day, month, year, gender, weight, height);
		
		// Informing user about data provided and his heart rate ranges
		System.out.printf("Hello %s %s!%nYou were born %d/%02d/%d and You are %s.%n%n", firstName, lastName, day, month, year, gender);
		System.out.printf("You are %d years old.%nYour max heart rate - %dbpm%nYour target heart rate is about - %dbpm%n",
				person1.calculateAge(), person1.calculateMax(), person1.calculateTarget());
		System.out.printf("You weight %.2f kg, your hight is %.2f meters.%n%n", weight, height);
		
		// Displaying BMI information about user with guidelines
		System.out.printf("Your BMI = %.2f%n", person1.calculateBmi());
		System.out.println("BMI VALUES");
		System.out.println("Underweight: less then 18.5");
		System.out.println("Normal:      between 18.5 and 24.9");
		System.out.println("Overweight:  between 25 and 29.9");
		System.out.println("Obese:       30 or greater");
		
		input.close();
	}

}
