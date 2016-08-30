// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.22 page 948
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;
import java.util.Scanner;

import com.deitel.datastructures.Tree;

public class TreeDeleteValue {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		SecureRandom randomNumber = new SecureRandom();

		Tree<Integer> tree = new Tree<Integer>();
		System.out.println("Inserting the following values: ");
		Integer[] intArray = new Integer[20];
		// insert 20 random integers from 0-99 in tree
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = 1 + randomNumber.nextInt(100);
			tree.insertNode(intArray[i]);
			System.out.print(intArray[i] + " ");
		}
		System.out.printf("%n%nInorder traversal%n");
		tree.inorderTraversal();
		System.out.println();
		System.out.println();
		for (int i = 0; i < intArray.length; i++) {
			int toDelete = intArray[randomNumber.nextInt(intArray.length)];
			while (tree.contains(toDelete) == null) {
				toDelete = intArray[randomNumber.nextInt(intArray.length)];
			}
			System.out.println("Deleting: " + toDelete);
			tree.deleteNode(toDelete);

			System.out.printf("%n%nInorder traversal%n");
			tree.inorderTraversal();

			System.out.println();
		}

	}
}
