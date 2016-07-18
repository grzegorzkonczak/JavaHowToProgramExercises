// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.18 page 400
// Exercise from Java:How to program 10th edition

package chapter8;

import java.math.BigDecimal;
import java.util.Scanner;

public class AccountBigTest {
	
	 public static void main(String[] args) 
	   {
	      AccountBig account1 = new AccountBig("Jane Green", BigDecimal.valueOf(50.00));
	      AccountBig account2 = new AccountBig("John Blue", BigDecimal.valueOf(-7.53)); 

	      // display initial balance of each object
	      System.out.printf("%s balance: $%.2f%n",
	         account1.getName(), account1.getBalance()); 
	      System.out.printf("%s balance: $%.2f%n%n",
	         account2.getName(), account2.getBalance()); 

	      // create a Scanner to obtain input from the command window
	      Scanner input = new Scanner(System.in);

	      System.out.print("Enter deposit amount for account1: "); // prompt
	      BigDecimal depositAmount = BigDecimal.valueOf(input.nextDouble()); // obtain user input
	      System.out.printf("%nadding %.2f to account1 balance%n%n", 
	         depositAmount);
	      account1.deposit(depositAmount); // add to account1's balance

	      // display balances
	      System.out.printf("%s balance: $%.2f%n",
	         account1.getName(), account1.getBalance()); 
	      System.out.printf("%s balance: $%.2f%n%n",
	         account2.getName(), account2.getBalance()); 

	      System.out.print("Enter deposit amount for account2: "); // prompt
	      depositAmount = BigDecimal.valueOf(input.nextDouble()); // obtain user input
	      System.out.printf("%nadding %.2f to account2 balance%n%n", 
	         depositAmount);
	      account2.deposit(depositAmount); // add to account2 balance

	      // display balances
	      System.out.printf("%s balance: $%.2f%n", 
	         account1.getName(), account1.getBalance()); 
	      System.out.printf("%s balance: $%.2f%n%n",
	         account2.getName(), account2.getBalance()); 
	   } // end main
}
