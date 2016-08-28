// Grzegorz Koñczak, 28.08.2016
// Exercise number 21.9 page 946
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;

import com.deitel.datastructures.List;

public class ReverseCopyTest {

	private static final SecureRandom random = new SecureRandom();

	public static void main(String[] args) {

		List<Integer> list1 = new List<>();
		
		for (int i = 0; i < 15; i++) {
			list1.insertAtFront(random.nextInt(101));
		}
		list1.print();
	
		System.out.println("Reversing...");
		List<Integer> reversedList = List.reverseCopy(list1);
		reversedList.print();

	}
}
