// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.17 page 680
// Exercise from Java:How to program 10th edition

package chapter14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreeLetters {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Input 5 letter word and confirm with enter");
		String originalWord = input.nextLine();
		List<String> combinations = new ArrayList<>();
		int counter = 1;

		for (int i = 0; i < originalWord.length(); i++) {
			for (int j = 0; j < originalWord.length(); j++) {
				for (int k = 0; k < originalWord.length(); k++) {
					if (i == j || j == k || k == i) {
						continue;
					} else {
						String combination = Character.toString(originalWord.charAt(i))
								+ Character.toString(originalWord.charAt(j))
								+ Character.toString(originalWord.charAt(k));
						if (!combinations.contains(combination)) {
							combinations.add(combination);
						}
					}

				}

			}
		}

		for (String string : combinations) {
			System.out.println(counter + ": " + string);
			counter++;
		}
	}
}
