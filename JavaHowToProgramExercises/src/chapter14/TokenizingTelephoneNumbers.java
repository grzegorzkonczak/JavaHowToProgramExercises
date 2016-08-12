// Grzegorz Koñczak, 12.08.2016
// Exercise number 14.8 page 679
// Exercise from Java:How to program 10th edition

package chapter14;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenizingTelephoneNumbers {

	private final static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Enter phone numer in format (555) 555-5555");
		String phoneNumber = "(555) 555-5555";

		String[] tokens = phoneNumber.split("()\\s");
		String[] areaCode = tokens[0].split("\\D");
		String[] phoneNumberTokens = tokens[1].split("-");
		String areaCodeProper = areaCode[1];
		
		System.out.println("Area Code: ");
		System.out.println(areaCodeProper);
		
		System.out.println("Phone number tokens:");
		for (String string : phoneNumberTokens) {
			System.out.println(string);
		}
	}
}
