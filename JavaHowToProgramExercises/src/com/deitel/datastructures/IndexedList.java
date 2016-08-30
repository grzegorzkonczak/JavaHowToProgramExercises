// Grzegorz Koñczak, 30.08.2016
// Exercise number 21.29 page 951
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

import java.util.ArrayList;

public class IndexedList {
	private ListNode<String> firstNode;
	private String name; // string like "list" used in printing
	private String[] indexValues = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
			"q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
	private ArrayList<ListNode<String>> index = new ArrayList<>();

	// constructor creates empty List
	public IndexedList() {
		this("indexed list");
	}

	// constructor creates an empty List with a name
	public IndexedList(String listName) {
		name = listName;
		for (int i = 0; i < indexValues.length; i++) {
			index.add(new ListNode<String>(indexValues[i]));
		}
	}

	public String searchIndexedList(String element) {
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		for (ListNode<String> listNode : index) {
			if (listNode.data.equalsIgnoreCase(element.substring(0, 1))) {
				while (listNode.data != element){
					if (listNode.nextNode == null){
						return null;
					} else {
						listNode = listNode.nextNode;
					}
				}
				return listNode.data;
			}
		}
		return null;
	}

	// insert item at front of List
	public void insertInIndexedList(String insertItem) {
		for (ListNode<String> listNode : index) {
			if (listNode.data.equalsIgnoreCase(insertItem.substring(0, 1))) {
				while (listNode.nextNode != null) {
					listNode = listNode.nextNode;
				}
				listNode.nextNode = new ListNode<String>(insertItem);
			}
		}
	}

	public String deleteFromIndexedList(String element) throws EmptyListException {
		if (isEmpty()) // throw exception if List is empty
			throw new EmptyListException(name);
		for (ListNode<String> listNode : index) {
			if (listNode.data.equalsIgnoreCase(element.substring(0, 1))) {
				while (listNode.nextNode.data != element){
					if (listNode.nextNode == null){
						return null;
					} else {
						listNode = listNode.nextNode;
					}
				}
				listNode.nextNode = listNode.nextNode.nextNode;
				return listNode.data;
			}
		}
		return null;
		
	} // end method removeFromFront

	// determine whether list is empty
	public boolean isEmpty() {
		return false; // return true if list is empty
	}

	// output list contents
	public void print() {
		if (isEmpty()) {
			System.out.printf("Empty %s%n", name);
			return;
		}

		System.out.printf("The %s is: ", name);
	
		for (ListNode<String> listNode : index) {
			while (listNode.nextNode != null){
				System.out.printf(" %s ", listNode.nextNode.data);
				listNode = listNode.nextNode;
			}
		}

		System.out.println();
	}
}
