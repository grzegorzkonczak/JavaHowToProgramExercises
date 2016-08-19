// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.10 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PhishingScanner {

	private static Scanner input;
	private static String[] keywords = { "Check this out!", "Scam", "provide password" };
	private static int[] threatValue = { 1, 2, 4 };
	private static int[] scores = new int[keywords.length];

	public static void main(String[] args) {
		openFile();
		scanForThreat();
		displayResult();
		closeFile();
	}

	private static void displayResult() {
		int totalThreat = 0;
		for (int i = 0; i < keywords.length; i++) {
			System.out.println("Threat from " + keywords[i] + " is: " + scores[i]);
			totalThreat += scores[i];
		}
		System.out.println("Total threat: " + totalThreat);
	}

	private static void scanForThreat() {
		String word = null;
		String word2 = null;
		String word3 = null;
		while (input.hasNext()) {
			word = input.next();
			if (input.hasNext()) {
				word2 = input.next();
			}
			if (input.hasNext()) {
				word3 = input.next();
			}
			for (int i = 0; i < keywords.length; i++) {
				if ((word2 != null && word3 != null) && 
						keywords[i].contains(word) || keywords[i].contains(word2) || keywords[i].contains(word3)) {
					if (i == 2) {
						if (keywords[i].contains(word) && keywords[i].contains(word2) ||
								keywords[i].contains(word2) && keywords[i].contains(word3)) {
							scores[i] += threatValue[i];
						}
					} else if (i == 1) {
						System.out.println(word + " " + word2 + " " + word3);
						scores[i] += threatValue[i];
					} else if (i == 0) {
						if (keywords[i].contains(word) && keywords[i].contains(word2)
								&& keywords[i].contains(word3)) {
							scores[i] += threatValue[i];
						}
					}
				}
			}
		}

	}

	private static void closeFile() {
		if (input != null) {
			input.close();
		}
	}

	private static void openFile() {
		try {
			input = new Scanner(Paths.get("toScan.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
