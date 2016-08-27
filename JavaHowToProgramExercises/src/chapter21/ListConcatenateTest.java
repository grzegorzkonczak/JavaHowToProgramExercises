// Grzegorz Koñczak, 27.08.2016
// Exercise number 21.6 page 946
// Exercise from Java:How to program 10th edition

package chapter21;

import com.deitel.datastructures.ListConcatenate;

public class ListConcatenateTest {

	public static void main(String[] args) {
		
		ListConcatenate<Character> list1 = new ListConcatenate<>();
		ListConcatenate<Character> list2 = new ListConcatenate<>();
		
		list1.insertAtBack('a');
		list1.insertAtBack('b');
		list1.insertAtBack('c');
		list1.insertAtBack('d');
		
		list2.insertAtBack('e');
		list2.insertAtBack('f');
		list2.insertAtBack('g');
		list2.insertAtBack('h');
		
		list1.print();
		list2.print();
		
		ListConcatenate.concatenate(list1, list2);
		
		list1.print();
		list2.print();
	}
}
