// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.21 page 948
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;
import java.util.Scanner;

import com.deitel.datastructures.List;

public class RecursiveSearchTest {

	private static final Scanner input = new Scanner(System.in);
	private static final SecureRandom random = new SecureRandom();


	public static void main(String[] args) {

		List<Integer> list1 = new List<>();

		for (int i = 0; i < 15; i++) {
			list1.insertAtFront(random.nextInt(101));
		}
		list1.print();
		System.out.println("\nEnter value you want to search for:");
		Integer search = list1.search(input.nextInt());
		
		if (search != null){
			System.out.println("Found it!");
		} else {
			System.out.println("Not found value...");
		}
	}
}
