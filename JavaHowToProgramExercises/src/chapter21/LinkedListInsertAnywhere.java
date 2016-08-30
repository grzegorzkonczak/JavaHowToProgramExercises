// Grzegorz Koñczak, 30.08.2016
// Exercise number 21.26 page 950
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;
import java.util.Scanner;

import com.deitel.datastructures.List;

public class LinkedListInsertAnywhere {

	private static final SecureRandom random = new SecureRandom();
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		List<Integer> list = new List<>();
		
		System.out.println("Inserting values:");
		for (int i = 0; i < 10; i++) {
			int value = random.nextInt(100);
			System.out.printf("%d ", value);
			list.insertAtFront(value);
		}
		System.out.println();
		list.print();
		
//		System.out.println();
//		System.out.println("Enter index where tu put value and then the value:");
//		list.insert(input.nextInt(), input.nextInt());
//		System.out.println();
//		list.print();
		
		System.out.println("Enter value to delete:");
		list.delete(input.nextInt());
		list.print();
	}
}
