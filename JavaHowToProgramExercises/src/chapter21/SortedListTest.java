// Grzegorz Koñczak, 27.08.2016
// Exercise number 21.7 page 946
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;

import com.deitel.datastructures.SortedList;

public class SortedListTest {
	
	private static final SecureRandom random = new SecureRandom();
	public static void main(String[] args) {

		SortedList<Integer> list1 = new SortedList<>();
		
		for (int i = 0; i < 15; i++) {
			list1.insert(25 + random.nextInt(101));
			list1.print();
		}
		
		list1.print();
	}
}
