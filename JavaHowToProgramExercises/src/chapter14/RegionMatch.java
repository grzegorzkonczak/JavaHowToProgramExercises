// Grzegorz Koñczak, 12.08.2016
// Exercise number 14.4 page 679
// Exercise from Java:How to program 10th edition

package chapter14;

import java.util.Scanner;

public class RegionMatch {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter first String: ");
		String one = input.nextLine();
		System.out.print("Enter Second String: ");
		String two = input.nextLine();
		
		System.out.println("How many letters to compare?");
		int numberOfLettersToCompare = input.nextInt();
		System.out.println("Where to begin matching?");
		int startIndex = input.nextInt();
		
		if (one.regionMatches(true, startIndex, two, startIndex, numberOfLettersToCompare)){
			System.out.println("Match");
		} else {
			System.out.println("No match...");
		}
	}
}
