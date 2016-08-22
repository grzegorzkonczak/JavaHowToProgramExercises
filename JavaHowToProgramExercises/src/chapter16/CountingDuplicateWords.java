// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.16 page 769
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CountingDuplicateWords {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Input sentence:");
		String sentence = input.nextLine();
		String[] words = sentence.split("\\W+");
		
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
		}
		
		List<String> wordsList = new ArrayList<>(Arrays.asList(words));
		Set<String> wordsSet = new HashSet<>(wordsList);
		
		System.out.println(words);
		System.out.println(wordsList);
		System.out.println(wordsSet);
		
		System.out.println("There are " + (wordsList.size() - wordsSet.size()) + " duplicates");
	}
}
