// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.16 page 680
// Exercise from Java:How to program 10th edition

package chapter14;

import java.util.Scanner;

public class MyIndexMethods {
	
private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Input sentence and confirm with enter");
		String originalSentence = input.nextLine();
		String[] tokenizedSentence = originalSentence.split("\\s");
		
		System.out.println(originalSentence.indexOf('a'));
		System.out.println(myIndexOf('a', originalSentence));
		
		System.out.println(originalSentence.lastIndexOf('a'));
		System.out.println(myLastIndexOf('a', originalSentence));
	}
	
	private static int myIndexOf(char character, String string){
		for (int i = 0; i < string.length(); i++){
			if (string.charAt(i) == character){
				return i;
			}
		}
		return -1;
	}
	
	private static int myLastIndexOf(char character, String string){
		for (int i = string.length() - 1; i >= 0; i--){
			if (string.charAt(i) == character){
				return i;
			}
		}
		return -1;
	}
}
