// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.16/17/19/22/23 page 948
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
	// package access members
	TreeNode<T> leftNode;
	T data; // node value
	TreeNode<T> rightNode;
	TreeNode<T> parentNode;

	// constructor initializes data and makes this a leaf node
	public TreeNode(T nodeData, TreeNode<T> parentNode) {
		data = nodeData;
		leftNode = rightNode =  null; // node has no children
		this.parentNode = parentNode; 
	}

	// locate insertion point and insert new node; ignore duplicate values
	public int insert(T insertValue) {
		// insert in left subtree
		if (insertValue.compareTo(data) < 0) {
			// insert new TreeNode
			if (leftNode == null) {
				leftNode = new TreeNode<T>(insertValue, this);
				return 1;
			} else { // continue traversing left subtree recursively
				int depth = leftNode.insert(insertValue);
				return depth + 1;
			}
		}
		// insert in right subtree
		else if (insertValue.compareTo(data) > 0) {
			// insert new TreeNode
			if (rightNode == null) {
				rightNode = new TreeNode<T>(insertValue, this);
				return 1;
			} else {// continue traversing right subtree recursively
				int depth = rightNode.insert(insertValue);
				return depth + 1;
			}
		}
		return 0;
	}
} // end class TreeNode

// class Tree definition
public class Tree<T extends Comparable<T>> {
	private TreeNode<T> root;
	private int depth = 0;

	// constructor initializes an empty Tree of integers
	public Tree() {
		root = null;
	}

	// insert a new node in the binary search tree
	public void insertNode(T insertValue) {
		if (root == null) {
			root = new TreeNode<T>(insertValue, null); // create root node
		} else {
			int depthTemp = root.insert(insertValue); // call the insert method
			if (depth < depthTemp) {
				depth = depthTemp;
			}
		}
	}

	// begin preorder traversal
	public void preorderTraversal() {
		preorderHelper(root);
	}

	// recursive method to perform preorder traversal
	private void preorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		System.out.printf("%s ", node.data); // output node data
		preorderHelper(node.leftNode); // traverse left subtree
		preorderHelper(node.rightNode); // traverse right subtree
	}

	// begin inorder traversal
	public void inorderTraversal() {
		inorderHelper(root);
	}

	// recursive method to perform inorder traversal
	private void inorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		inorderHelper(node.leftNode); // traverse left subtree
		System.out.printf("%s ", node.data); // output node data
		inorderHelper(node.rightNode); // traverse right subtree
	}

	// begin postorder traversal
	public void postorderTraversal() {
		postorderHelper(root);
	}

	// recursive method to perform postorder traversal
	private void postorderHelper(TreeNode<T> node) {
		if (node == null)
			return;

		postorderHelper(node.leftNode); // traverse left subtree
		postorderHelper(node.rightNode); // traverse right subtree
		System.out.printf("%s ", node.data); // output node data
	}

	public int getDepth() {
		return depth;
	}

	public void deleteNode(T element) {
		TreeNode<T> node = locateNode(element, root);
		// When element was not found
		if (node == null) {
			System.out.println("No such element.");
		// When element is leaf
		} else if (node.leftNode == null && node.rightNode == null) {
			if (node.parentNode.leftNode == node){
				node.parentNode.leftNode = null;
			} else {
				node.parentNode.rightNode = null;
			}
		// When element has one child
		} else if (node.leftNode == null || node.rightNode == null){
			if (node.leftNode == null){
				if (node.parentNode.rightNode == node) {
					node.parentNode.rightNode = node.rightNode;
					node.rightNode.parentNode = node.parentNode;
					node = null;
				} else {
					node.parentNode.leftNode = node.rightNode;
					node.rightNode.parentNode = node.parentNode;
					node = null;
				}
			} else {
				if (node.parentNode.leftNode == node) {
					node.parentNode.leftNode = node.leftNode;
					node.leftNode.parentNode = node.parentNode;
					node = null;
				} else {
					node.parentNode.rightNode = node.leftNode;
					node.leftNode.parentNode = node.parentNode;
					node = null;
				}
			}
		// TODO When element has 2 children
		} else {
			
		}
	}

	private TreeNode<T> locateNode(T element, TreeNode<T> node) {
		if (node != null) {
			if (node.data == element) {
				return node;
			}
			TreeNode<T> leftNode = locateNode(element, node.leftNode);
			TreeNode<T> rightNode = locateNode(element, node.rightNode);
			if (leftNode == null && rightNode == null) {
				return null;
			} else if (rightNode != null) {
				return rightNode;
			} else {
				return leftNode;
			} 
		}
		return null;
	}
} // end class Tree
