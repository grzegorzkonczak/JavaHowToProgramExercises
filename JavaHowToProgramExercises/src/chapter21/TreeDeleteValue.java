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
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom randomNumber = new SecureRandom();

		System.out.println("Inserting the following values: ");

		Integer[] intArray = {91, 16, 32, 20, 39, 52, 31, 41, 12, 14, 30};
		// insert 10 random integers from 0-99 in tree
		for (int i = 0; i < intArray.length; i++) {
			tree.insertNode(intArray[i]);
			System.out.print(intArray[i] + " ");
		}

		System.out.printf("%n%nPreorder traversal%n");
		tree.preorderTraversal();

		System.out.printf("%n%nInorder traversal%n");
		tree.inorderTraversal();

		System.out.printf("%n%nPostorder traversal%n");
		tree.postorderTraversal();
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			System.out.println("Enter value to delete:");
			int toDelete = input.nextInt();
			tree.deleteNode(toDelete);
			System.out.printf("%n%nPreorder traversal%n");
			tree.preorderTraversal();
			System.out.printf("%n%nInorder traversal%n");
			tree.inorderTraversal();
			System.out.printf("%n%nPostorder traversal%n");
			tree.postorderTraversal();
			System.out.println();
		}

	}
}
