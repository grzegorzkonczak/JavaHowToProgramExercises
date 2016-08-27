// Grzegorz Koñczak, 27.08.2016
// Exercise number 21.6 page 946
// Exercise from Java:How to program 10th edition

package com.deitel.datastructures;

public class ListConcatenate<T> extends List<T> {


	public ListConcatenate() {
		this("Concat list");
	}

	public ListConcatenate(String name) {
		super(name);
		
	}
	
	public static <T> void concatenate(ListConcatenate<T> list1, ListConcatenate<T> list2) {
		list1.getLastNode().setNextNode(list2.getFirstNode());
		list1.setLastNode(list2.getLastNode());
	}
}
