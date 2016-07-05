// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.21 page 281
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class BeautifyingStrings {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter String to beautify:");
		String raw = input.nextLine();
		String beautyString = beautifyingString(raw);
		System.out.println("Beautyfied String: " + beautyString);
	}

	private static String beautifyingString(String raw) {
		String stopAdded = fullStopAdder(raw);
		String beautiful = capitalizeFirstLetter(stopAdded);
		return beautiful;
	}

	private static String capitalizeFirstLetter(String stopAdded) {
		if(Character.isUpperCase(stopAdded.charAt(0)))
			return stopAdded;
		else{
			String capitalized = Character.toUpperCase(stopAdded.charAt(0)) + stopAdded.substring(1);
			return capitalized;
		}
	}

	private static String fullStopAdder(String raw) {
		if(raw.endsWith("."))
			return raw;
		else{
			String withStop = raw + ".";
			return withStop;
		}
			
	}
}
