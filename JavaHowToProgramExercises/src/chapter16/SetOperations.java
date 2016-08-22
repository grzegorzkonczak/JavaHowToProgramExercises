// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.17 page 769
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

	public static void main(String[] args) {
	
		Set<String> set1 = new HashSet<>();
		Set<String> set2 = new HashSet<>();
		set1.add("New");
		set1.add("Old");
		set1.add("Better");
		set1.add("Worse");
		set1.add("Something");
		set2.add("Something");
		set2.add("SomethingElse");
		set2.add("New");
		set2.add("Dog");
		set2.add("Cat");
		
		Set<String> setInteraction = interaction(set1, set2);
		Set<String> setUnion = union(set1, set2);
		Set<String> setDifference = difference(set1, set2);
		
		System.out.println("Interaction:");
		for (String string : setInteraction) {
			System.out.println(string);
		}
		System.out.println("\nUnion:");
		for (String string : setUnion) {
			System.out.println(string);
		}
		System.out.println("\nDifference:");
		for (String string : setDifference) {
			System.out.println(string);
		}
	}

	private static Set<String> difference(Set<String> set1, Set<String> set2) {
		Set<String> set = new HashSet<>();
		for (String string : set1) {
			if (!set2.contains(string)){
				set.add(string);
			}
		}
		for (String string : set2) {
			if (!set1.contains(string)){
				set.add(string);
			}
		}
		return set;
	}

	private static Set<String> union(Set<String> set1, Set<String> set2) {
		Set<String> set = new HashSet<>(set1);
		for (String string : set2) {
			set.add(string);
		}
		
		return set;
	}

	private static Set<String> interaction(Set<String> set1, Set<String> set2) {
		Set<String> set = new HashSet<>();
		for (String string : set1) {
			if (set2.contains(string)){
				set.add(string);
			}
		}
		return set;
	}
}
