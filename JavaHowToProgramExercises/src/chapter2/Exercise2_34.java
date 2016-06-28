// Grzegorz Koñczak, 28.06.2016
// Exercise number 2.34 page 110
// Exercise from Java:How to program 10th edition

package chapter2;

import java.util.Scanner;

public class Exercise2_34 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		long population;
		int growth;
		
		
		System.out.print("Enter current population: ");
		population = input.nextLong();
		System.out.print("Enter growth rate in milions: ");
		growth = input.nextInt();
		
		long population1 = population + growth;
		long population2 = population1 + growth;
		long population3 = population2 + growth;
		long population4 = population3 + growth;
		long population5 = population4 + growth;
		
		System.out.printf("Population after%n1 year: %d%n2 years: %d%n3 years: %d%n4 years: %d%n5 years: %d%n",
				population1, population2, population3, population4, population5);
		
		input.close();
	}

}
