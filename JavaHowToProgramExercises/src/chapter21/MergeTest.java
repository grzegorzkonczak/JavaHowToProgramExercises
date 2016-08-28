// Grzegorz Koñczak, 28.08.2016
// Exercise number 21.8 page 946
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;

import com.deitel.datastructures.SortedList;

public class MergeTest {

	private static final SecureRandom random = new SecureRandom();

	public static void main(String[] args) {

		for (int j = 0; j < 4; j++) {
			SortedList<Integer> list1 = new SortedList<>();
			SortedList<Integer> list2 = new SortedList<>();
			for (int i = 0; i < 15; i++) {
				list1.insert(25 + random.nextInt(101));
				list2.insert(25 + random.nextInt(101));
			}
			System.out.println("\n");
			list1.print();
			list2.print();
			System.out.println("Merging...");
			list1.merge(list2);
			list1.print();
		}
		
	}
}
