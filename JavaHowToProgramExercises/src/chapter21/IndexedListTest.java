// Grzegorz Koñczak, 30.08.2016
// Exercise number 21.29 page 951
// Exercise from Java:How to program 10th edition

package chapter21;

import java.security.SecureRandom;
import java.util.Scanner;

import com.deitel.datastructures.IndexedList;

public class IndexedListTest {

	private static final SecureRandom random = new SecureRandom();
	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		IndexedList list = new IndexedList();
		
		list.insertInIndexedList("Adam");
		list.insertInIndexedList("Ewa");
		list.insertInIndexedList("Bogdan");
		list.insertInIndexedList("Marian");
		list.insertInIndexedList("Maria");
		list.insertInIndexedList("Marcin");
		list.insertInIndexedList("Zuza");
		
		list.print();
		
		String check = list.searchIndexedList("Marcin");
		String check2 = list.searchIndexedList("Kuba");
		
		System.out.println(check + "  " + check2);
		
		list.deleteFromIndexedList("Bogdan");
		
		list.print();
	}
}
