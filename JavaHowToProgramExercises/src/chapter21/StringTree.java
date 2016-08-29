// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.17 page 948
// Exercise from Java:How to program 10th edition

package chapter21;

import java.util.Scanner;

import com.deitel.datastructures.Tree;

public class StringTree {
	
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Tree<String> tree = new Tree<>();

		System.out.println("Enter sentence: ");
		String sentence = input.nextLine();
		String[] words = sentence.split("\\W+");
		
		// insert 10 random integers from 0-99 in tree
		for (String string : words) {
			tree.insertNode(string);
		}

		System.out.printf("%n%nPreorder traversal%n");
		tree.preorderTraversal();

		System.out.printf("%n%nInorder traversal%n");
		tree.inorderTraversal();

		System.out.printf("%n%nPostorder traversal%n");
		tree.postorderTraversal();
		System.out.println();
	}
}
