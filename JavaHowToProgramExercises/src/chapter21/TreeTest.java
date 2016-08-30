// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.16/24 page 948/950
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;
import com.deitel.datastructures.Tree;

public class TreeTest 
{
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom randomNumber = new SecureRandom();

		System.out.println("Inserting the following values: ");

		// insert 10 random integers from 0-99 in tree
		for (int i = 1; i <= 10; i++) {
			int value = randomNumber.nextInt(100);
			System.out.printf("%d ", value);
			tree.insertNode(value);
		}

		System.out.printf("%n%nPreorder traversal%n");
		tree.preorderTraversal();

		System.out.printf("%n%nInorder traversal%n");
		tree.inorderTraversal();

		System.out.printf("%n%nPostorder traversal%n");
		tree.postorderTraversal();
		
		System.out.printf("%n%nLevel-order traversal%n");
		tree.levelOrder();
		System.out.println();
	}
} // end class TreeTest


