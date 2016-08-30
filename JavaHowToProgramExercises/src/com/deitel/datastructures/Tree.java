// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.16/17/19/22/23/24/25 page 948
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

// method deleteNode is horrible... that is not close to how i like to write code
// just bad day fighting with this implementation.
// TODO: refactor deleteNode()

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
	// package access members
	TreeNode<T> leftNode;
	T data; // node value
	TreeNode<T> rightNode;
	TreeNode<T> parentNode;

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}

	public TreeNode<T> getParentNode() {
		return parentNode;
	}

	public void setParentNode(TreeNode<T> parentNode) {
		this.parentNode = parentNode;
	}

	// constructor initializes data and makes this a leaf node
	public TreeNode(T nodeData, TreeNode<T> parentNode) {
		data = nodeData;
		leftNode = rightNode = null; // node has no children
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

	@Override
	public String toString() {
		return "TreeNode [leftNode=" + (leftNode == null ? null : leftNode.data) + ", data=" + data + ", rightNode="
				+ (rightNode == null ? null : rightNode.data) + ", parentNode="
				+ (parentNode == null ? null : parentNode.data) + "]";
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

	public void levelOrder() {
		Queue<TreeNode<T>> queue = new Queue<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			TreeNode<T> print = queue.dequeue();
			System.out.printf("%s ", print.data);
			if (print.leftNode != null) {
				queue.enqueue(print.leftNode);
			}
			if (print.rightNode != null) {
				queue.enqueue(print.rightNode);
			}
		}
	}

	public int getDepth() {
		return depth;
	}

	public T contains(T element) {
		TreeNode<T> temp = locateNode(element, root);
		return temp == null ? null : temp.data;
	}

	public void deleteNode(T element) {
		TreeNode<T> nodeToDelete = locateNode(element, root);
		// When element was not found
		if (nodeToDelete == null) {
			System.out.println("No such element.");
			// When element is leaf
		} else if (nodeToDelete == root) {
			if (nodeToDelete.getLeftNode() == null && nodeToDelete.getRightNode() == null) {
				root = null;
			} else if (nodeToDelete.getLeftNode() == null || nodeToDelete.getRightNode() == null) {
				if (nodeToDelete.getLeftNode() == null) {
					root = nodeToDelete.getRightNode();
					nodeToDelete.getRightNode().setParentNode(null);
					nodeToDelete = null;
				} else {
					root = nodeToDelete.getLeftNode();
					nodeToDelete.getLeftNode().setParentNode(null);
					nodeToDelete = null;
				}
			} else {
				TreeNode<T> replacementNode = nodeToDelete.getLeftNode();
				while (replacementNode.getRightNode() != null) {
					replacementNode = replacementNode.getRightNode();
				}
				if (replacementNode.getLeftNode() == null) {
					root = replacementNode;
					if (replacementNode.getParentNode().getRightNode() == replacementNode) {
						replacementNode.getParentNode().setRightNode(null);
					} else {
						replacementNode.getParentNode().setLeftNode(null);
					}
					replacementNode.setRightNode(nodeToDelete.getRightNode());
					replacementNode.setLeftNode(nodeToDelete.getLeftNode());
					replacementNode.setParentNode(null);
					if (replacementNode.getLeftNode() != null) {
						replacementNode.getLeftNode().setParentNode(replacementNode);
					}
					if (replacementNode.getRightNode() != null) {
						replacementNode.getRightNode().setParentNode(replacementNode);
					}
				} else {
					root = replacementNode;
					replacementNode.getParentNode().setRightNode(replacementNode.getLeftNode());
					replacementNode.getLeftNode().setParentNode(replacementNode.getParentNode());
					replacementNode.setRightNode(nodeToDelete.getRightNode());
					replacementNode.setLeftNode(nodeToDelete.getLeftNode());
					replacementNode.setParentNode(null);
					if (replacementNode.getLeftNode() != null) {
						replacementNode.getLeftNode().setParentNode(replacementNode);
					}
					if (replacementNode.getRightNode() != null) {
						replacementNode.getRightNode().setParentNode(replacementNode);
					}
				}
			}

		} else if (nodeToDelete.getLeftNode() == null && nodeToDelete.getRightNode() == null) {
			if (nodeToDelete.getParentNode().getLeftNode() == nodeToDelete) {
				nodeToDelete.getParentNode().setLeftNode(null);
			} else {
				nodeToDelete.getParentNode().setRightNode(null);
			}

			// When element has one child
		} else if (nodeToDelete.leftNode == null || nodeToDelete.rightNode == null) {
			if (nodeToDelete.leftNode == null) {
				if (nodeToDelete.parentNode.rightNode == nodeToDelete) {
					nodeToDelete.parentNode.rightNode = nodeToDelete.rightNode;
					nodeToDelete.rightNode.parentNode = nodeToDelete.parentNode;
					nodeToDelete = null;
				} else {
					nodeToDelete.parentNode.leftNode = nodeToDelete.rightNode;
					nodeToDelete.rightNode.parentNode = nodeToDelete.parentNode;
					nodeToDelete = null;
				}
			} else {
				if (nodeToDelete.parentNode.leftNode == nodeToDelete) {
					nodeToDelete.parentNode.leftNode = nodeToDelete.leftNode;
					nodeToDelete.leftNode.parentNode = nodeToDelete.parentNode;
					nodeToDelete = null;
				} else {
					nodeToDelete.parentNode.rightNode = nodeToDelete.leftNode;
					nodeToDelete.leftNode.parentNode = nodeToDelete.parentNode;
					nodeToDelete = null;
				}
			}
			// When element has 2 children
		} else {
			TreeNode<T> replacementNode = nodeToDelete.getLeftNode();
			while (replacementNode.getRightNode() != null) {
				replacementNode = replacementNode.getRightNode();
			}
			if (replacementNode.getLeftNode() == null) {
				TreeNode<T> temp = nodeToDelete.getLeftNode();
				boolean proximityCheck = temp != replacementNode;
				if (nodeToDelete.getParentNode().getRightNode() == nodeToDelete) {
					nodeToDelete.getParentNode().setRightNode(replacementNode);
				} else {
					nodeToDelete.getParentNode().setLeftNode(replacementNode);
				}
				if (replacementNode.getParentNode().getRightNode() == replacementNode) {
					replacementNode.getParentNode().setRightNode(null);
				} else {
					replacementNode.getParentNode().setLeftNode(null);
				}
				replacementNode.setRightNode(nodeToDelete.getRightNode());
				if (proximityCheck) {
					temp.setRightNode(null);
					replacementNode.setLeftNode(temp);
				}
				replacementNode.setParentNode(nodeToDelete.getParentNode());
				if (replacementNode.getLeftNode() != null) {
					replacementNode.getLeftNode().setParentNode(replacementNode);
				} else if (replacementNode.getRightNode() != null) {
					replacementNode.getRightNode().setParentNode(replacementNode);
				}
			} else {
				if (nodeToDelete.getParentNode().getRightNode() == nodeToDelete) {
					nodeToDelete.getParentNode().setRightNode(replacementNode);
				} else {
					nodeToDelete.getParentNode().setLeftNode(replacementNode);
				}
				replacementNode.getParentNode().setRightNode(replacementNode.getLeftNode());
				replacementNode.getLeftNode().setParentNode(replacementNode.getParentNode());
				replacementNode.setRightNode(nodeToDelete.getRightNode());
				replacementNode.setLeftNode(nodeToDelete.getLeftNode());
				replacementNode.setParentNode(nodeToDelete.getParentNode());
				if (replacementNode.getLeftNode() != null) {
					replacementNode.getLeftNode().setParentNode(replacementNode);
				}
				if (replacementNode.getRightNode() != null) {
					replacementNode.getRightNode().setParentNode(replacementNode);
				}
			}
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

	public boolean isEmpty() {
		if (root == null) {
			return true;
		} else {
			return false;
		}
	}

	public void outputTree(int totalSpaces) {
		outputHelper(totalSpaces, root);
	}

	private void outputHelper(int totalSpaces, TreeNode<T> node) {
		while (node != null) {
			outputHelper(totalSpaces + 5, node.rightNode);
			for (int i = 1; i <= totalSpaces; i++) {
				System.out.print(" ");
			}
			System.out.print(node.data);
			node = node.leftNode;
			totalSpaces += 5;
			System.out.println();
		}
	}
} // end class Tree
