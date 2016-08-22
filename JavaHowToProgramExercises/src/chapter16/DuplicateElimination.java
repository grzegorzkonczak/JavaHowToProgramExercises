// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.13 page 769
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DuplicateElimination {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter 5 first names");
		List<String> namesWithPossibleDuplicates = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			namesWithPossibleDuplicates.add(input.nextLine());
		}

		System.out.println("\nWith possible duplicates:");
		for (String string : namesWithPossibleDuplicates) {
			System.out.println(string);
		}

		Set<String> namesWithoutPossibleDuplicates = new HashSet<>();
		namesWithoutPossibleDuplicates.addAll(namesWithPossibleDuplicates);

		System.out.println("\nWithout possible duplicates:");
		for (String string : namesWithoutPossibleDuplicates) {
			System.out.println(string);
		}

		System.out.println("What name would you want to display?");
		String userChoice = input.nextLine();

		if (namesWithoutPossibleDuplicates.contains(userChoice)) {
			System.out.println(userChoice);
		}else{
			System.out.println("No such name in collection");
		}
	}
}
