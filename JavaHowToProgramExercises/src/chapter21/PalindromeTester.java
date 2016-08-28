// Grzegorz Koñczak, 28.08.2016
// Exercise number 21.11 page 946
// Exercise from Java:How to program 10th edition

package chapter21;

import java.util.Scanner;

import com.deitel.datastructures.Stack;

public class PalindromeTester {

private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Input word:");
		String word = input.nextLine();
		
		char[] charArray = word.toCharArray();
		
		
		boolean palindrome = isPalindrome(charArray);
		System.out.println(word + (palindrome ? " is " : " is not ") + "palindrome.");
		
	}

	private static boolean isPalindrome(char[] charArray) {
		Stack<Character> characterStack = new Stack<>();
		Stack<Character> characterStackReverse = new Stack<>();
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])){
				characterStack.push(charArray[i]);
			}
		}
		for (int i = charArray.length - 1; i >= 0; i--) {
			if (Character.isLetter(charArray[i])){
				characterStackReverse.push(charArray[i]);
			}
		}
		while (!characterStack.isEmpty()){
			if (characterStack.pop() != characterStackReverse.pop()){
				return false;
			}
		}
		return true;
	}
}
