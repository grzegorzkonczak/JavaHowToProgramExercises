// Grzegorz Koñczak, 28.06.2016
// Exercise number 2.33 page 109
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_33 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int weight;
		int height;
		int bmi;
		
		System.out.print("Enter your weight in kilograms: ");
		weight = input.nextInt();
		System.out.print("Enter your height in meters: ");
		height = input.nextInt();
		
		bmi = weight / (height * height);
		
		System.out.printf("Your BMI = %d%n", bmi);
		System.out.println("BMI VALUES");
		System.out.println("Underweight: less then 18.5");
		System.out.println("Normal:      between 18.5 and 24.9");
		System.out.println("Overweight:  between 25 and 29.9");
		System.out.println("Obese:       30 or greater");
		
		input.close();
	}

}
