// Grzegorz Koñczak, 30.08.2016
// Exercise number 21.25 page 950
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;

import com.deitel.datastructures.Tree;

public class OutputTreeTest {
	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();
		SecureRandom randomNumber = new SecureRandom();

		System.out.println("Inserting the following values: ");

		// insert 10 random integers from 0-99 in tree
		for (int i = 1; i <= 30; i++) {
			int value = randomNumber.nextInt(100);
			System.out.printf("%d ", value);
			tree.insertNode(value);
		}

		System.out.println("\n\n\n");
		tree.outputTree(0);
	}
}
