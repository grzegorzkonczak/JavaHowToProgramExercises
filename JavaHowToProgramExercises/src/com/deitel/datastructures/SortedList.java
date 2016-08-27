// Grzegorz Koñczak, 27.08.2016
// Exercise number 21.7 page 946
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

public class SortedList<T extends Comparable<T>> {

	private ListNode<T> firstNode;
	private ListNode<T> lastNode;
	private String name; // string like "list" used in printing

	// constructor creates empty List with "list" as the name
	public SortedList() {
		this("list");
	}

	// constructor creates an empty List with a name
	public SortedList(String listName) {
		name = listName;
		firstNode = lastNode = null;
	}

	ListNode<T> getFirstNode() {
		return firstNode;
	}

	void setFirstNode(ListNode<T> firstNode) {
		this.firstNode = firstNode;
	}

	ListNode<T> getLastNode() {
		return lastNode;
	}

	void setLastNode(ListNode<T> lastNode) {
		this.lastNode = lastNode;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	// insert item to List
	public void insert(T insertItem) {
		if (isEmpty()) {
			firstNode = new ListNode<T>(insertItem);
		} else if (firstNode.nextNode == null) {
			if (firstNode.getData().compareTo(insertItem) <= 0) {
				lastNode = firstNode.nextNode = new ListNode<T>(insertItem);
			} else {
				lastNode = firstNode;
				firstNode = new ListNode<T>(insertItem, lastNode);
			}
		} else if (firstNode.nextNode == lastNode) {
			if (firstNode.getData().compareTo(insertItem) > 0) {
				firstNode = new ListNode<T>(insertItem, firstNode);
			} else if (lastNode.getData().compareTo(insertItem) < 0) {
				lastNode = lastNode.nextNode = new ListNode<T>(insertItem);
			} else {
				firstNode.nextNode = new ListNode<T>(insertItem, lastNode);
			}
		} else {
			ListNode<T> current = firstNode;
			ListNode<T> currentNext = firstNode.nextNode;
			while (currentNext.nextNode != null && current.nextNode.getData().compareTo(insertItem) <= 0) {
				current = current.nextNode;
				currentNext = currentNext.nextNode;
			}
			if (current == firstNode && current.getData().compareTo(insertItem) <= 0) {
				firstNode.nextNode = new ListNode<T>(insertItem, current.nextNode);
			} else if (current == firstNode && current.getData().compareTo(insertItem) > 0) {
				ListNode<T> temp = firstNode;
				firstNode = new ListNode<T>(insertItem, temp);
			} else if (currentNext.nextNode != null) {
				ListNode<T> first = current;
				ListNode<T> second = current.nextNode;
				second = current.nextNode = new ListNode<T>(insertItem, second);
				first.setNextNode(second);
			} else {
				if (currentNext.getData().compareTo(insertItem) < 0) {
					currentNext.nextNode = new ListNode<T>(insertItem);
				} else {
					ListNode<T> first = current;
					ListNode<T> second = current.nextNode;
					second = current.nextNode = new ListNode<T>(insertItem, second);
					first.setNextNode(second);
				}
			}
		}
	}

	// remove first node from List
	public T removeFromFront() throws EmptyListException {
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);

		T removedItem = firstNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else
			firstNode = firstNode.nextNode;

		return removedItem; // return removed node data
	} // end method removeFromFront

	// remove last node from List
	public T removeFromBack() throws EmptyListException {
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);

		T removedItem = lastNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if (firstNode == lastNode)
			firstNode = lastNode = null;
		else // locate new last node
		{
			ListNode<T> current = firstNode;

			// loop while current node does not refer to lastNode
			while (current.nextNode != lastNode)
				current = current.nextNode;

			lastNode = current; // current is new lastNode
			current.nextNode = null;
		}

		return removedItem; // return removed node data
	}

	// determine whether list is empty
	public boolean isEmpty() {
		return firstNode == null; // return true if list is empty
	}

	// output list contents
	public void print() {
		if (isEmpty()) {
			System.out.printf("Empty %s%n", name);
			return;
		}

		System.out.printf("The %s is: ", name);
		ListNode<T> current = firstNode;

		// while not at end of list, output current node's data
		while (current != null) {
			System.out.printf("%s ", current.data);
			current = current.nextNode;
		}

		System.out.println();
	}
}
