// Grzegorz Koñczak, 29.06.2016
// Exercise number 3.15 page 140
// Exercise from Java:How to program 10th edition

package chapter3;

import java.util.Scanner;

public class AccountTestDisplay {
	public static void main(String[] args) {
		Account account1 = new Account("Jane Green", 50.00);
		Account account2 = new Account("John Blue", -7.53);

		// display initial balance of each object
		AccountTestDisplay.displayAccount(account1);
		AccountTestDisplay.displayAccount(account2);
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		System.out.print("Enter deposit amount for account1: "); // prompt
		double depositAmount = input.nextDouble(); // obtain user input
		System.out.printf("%nadding %.2f to account1 balance%n%n", depositAmount);
		account1.deposit(depositAmount); // add to account1's balance

		// display balances
		AccountTestDisplay.displayAccount(account1);
		AccountTestDisplay.displayAccount(account2);

		System.out.print("Enter deposit amount for account2: "); // prompt
		depositAmount = input.nextDouble(); // obtain user input
		System.out.printf("%nadding %.2f to account2 balance%n%n", depositAmount);
		account2.deposit(depositAmount); // add to account2 balance

		// display balances
		AccountTestDisplay.displayAccount(account1);
		AccountTestDisplay.displayAccount(account2);

		System.out.print("Enter withdraw amount for account2: "); // prompt
		double withdrawAmount = input.nextDouble(); // obtain user input
		System.out.printf("%nwithdrawing %.2f from account2 balance%n%n", withdrawAmount);
		account2.withdraw(withdrawAmount); // add to account2 balance

		// display balances
		AccountTestDisplay.displayAccount(account1);
		AccountTestDisplay.displayAccount(account2);

		System.out.print("Enter withdraw amount for account1: "); // prompt
		withdrawAmount = input.nextDouble(); // obtain user input
		System.out.printf("%nwithdrawing %.2f from account1 balance%n%n", withdrawAmount);
		account1.withdraw(withdrawAmount); // add to account1 balance

		// display balances
		AccountTestDisplay.displayAccount(account1);
		AccountTestDisplay.displayAccount(account2);

		input.close();
	} // end main

	public static void displayAccount(Account accountToDisplay) {
		System.out.printf("%s balance: $%.2f%n", accountToDisplay.getName(), accountToDisplay.getBalance());
	}

} // end class AccountTest
