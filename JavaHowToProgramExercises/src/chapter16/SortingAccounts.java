// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.14 page 769
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingAccounts {

	public static void main(String[] args) {
		
		List<Account> accountsUnsorted = new ArrayList<>();
		
		accountsUnsorted.add(new Account(100, "Alan", "Jones", 348.17));
		accountsUnsorted.add(new Account(300, "Mary", "Smith", 27.19));
		accountsUnsorted.add(new Account(500, "Sam", "Sharp", 0.00));
		accountsUnsorted.add(new Account(700, "Suzy", "Green", -14.22));
		
		System.out.println("Unsorted list");
		for (Account account : accountsUnsorted) {
			System.out.println(account);
		}
		
		Collections.sort(accountsUnsorted, new AccountComparator());
		
		System.out.println("Sorted list");
		for (Account account : accountsUnsorted) {
			System.out.println(account);
		}
	}
}
