// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.20 page 948
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;

import com.deitel.datastructures.List;

public class RecursiveReversePrintListTest {

	private static final SecureRandom random = new SecureRandom();

	public static void main(String[] args) {

		List<Integer> list1 = new List<>();
		
		for (int i = 0; i < 15; i++) {
			list1.insertAtFront(random.nextInt(101));
		}
		
		list1.print();
		System.out.println();
		list1.printListBackwards();

	}
}
