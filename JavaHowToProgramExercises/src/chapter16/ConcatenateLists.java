// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.18 page 769
// Exercise from Java:How to program 10th edition


package chapter16;

import java.util.LinkedList;
import java.util.List;

public class ConcatenateLists {

	public static void main(String[] args) {
		List<String> list1 = new LinkedList<>();
		List<String> list2 = new LinkedList<>();
		list1.add("New");
		list1.add("Old");
		list1.add("Better");
		list1.add("Worse");
		list1.add("Something");
		list2.add("Something");
		list2.add("SomethingElse");
		list2.add("New");
		list2.add("Dog");
		list2.add("Cat");
		
		List<String> concatenatedList = concatenate(list1, list2);
		
		System.out.println("Concatenated list:");
		for (String string : concatenatedList) {
			System.out.println(string);
		}
	}

	private static List<String> concatenate(List<String> list1, List<String> list2) {
		List<String> concatenatedList = new LinkedList<>(list1);
		concatenatedList.addAll(list2);
		return concatenatedList;
	}
}
