// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.11 page 679
// Exercise from Java:How to program 10th edition

package chapter14;

import java.util.Scanner;

public class PluralForm {

	
private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Input noun and confirm with enter");
		String originalWord = input.nextLine();
		char[] sxz = {'s', 'x', 'z'};
		char[] consonant = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
		String pluralWord = "";
		
		for (char c : sxz) {
			if (originalWord.charAt(originalWord.length() - 1) == c){
				pluralWord = originalWord + "es";
			}
		}
		
		if (originalWord.charAt(originalWord.length() - 1) == 'h' && (originalWord.charAt(originalWord.length() - 2) == 's' || 
				originalWord.charAt(originalWord.length() - 2) == 'c')){
			pluralWord = originalWord + "es";
		}
		
		if (originalWord.charAt(originalWord.length() - 1) == 'y'){
			for (char c : consonant) {
				if (originalWord.charAt(originalWord.length() - 2) == c) {
					StringBuilder builder = new StringBuilder(originalWord);
					builder.delete(originalWord.length() - 1, originalWord.length()).append("ies");
					pluralWord = builder.toString();
				}
			}
		}
		
		if (pluralWord.isEmpty()){
			pluralWord = originalWord + "s";
		}
		
		System.out.println(pluralWord);
	}
}
