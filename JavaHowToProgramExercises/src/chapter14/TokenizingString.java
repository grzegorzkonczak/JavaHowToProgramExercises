// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.12/13/14/15 page 679/680
// Exercise from Java:How to program 10th edition

package chapter14;

import java.util.Scanner;

public class TokenizingString {

private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Input sentence and confirm with enter");
		String originalSentence = input.nextLine();
		String[] tokenizedSentence = originalSentence.split("\\s");
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int[] alphabetCount = new int[26];
		
		System.out.println("Words starting with capital letters:");
		for (String string : tokenizedSentence) {
			if (Character.isUpperCase(string.charAt(0))){
				System.out.println(string);
			}
		}
		
		for(String string : tokenizedSentence){
			for (int i = 0; i < alphabetCount.length; i++) {
				for (int j = 0; j < string.length(); j++) {
					if (Character.toString(alphabet[i]).equalsIgnoreCase(Character.toString(Character.toLowerCase(string.charAt(j))))){
						alphabetCount[i]++;
					}
				}
			}
		}
		
		System.out.println("Number of letters in text:");
		for (int i = 0; i < alphabet.length; i++) {
			System.out.println(alphabet[i] + " --> " + alphabetCount[i]);
		}
		
		System.out.println("Words ending with \"ed\":");
		for(String string : tokenizedSentence){
			if (string.charAt(string.length() - 1) == 'd' && string.charAt(string.length() - 2) == 'e'){
				System.out.println(string);
			}
		}
	}
}
