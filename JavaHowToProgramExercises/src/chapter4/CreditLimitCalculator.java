// Grzegorz Koñczak, 29.06.2016
// Exercise number 4.18 page 189
// Exercise from Java:How to program 10th edition

package chapter4;

import java.util.Scanner;

public class CreditLimitCalculator {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int flag = 1;
		
		System.out.println("Would You like to check client credit limit? (0 - no, 1 - yes)");
		flag = input.nextInt();
		
		while(flag != 0){
			System.out.print("Please provide account number: ");
			int accountNumber = input.nextInt();
			System.out.print("Please provide balance at beggining of the month: ");
			int balanceOld = input.nextInt();
			System.out.print("Please provide total for charged items: ");
			int charged = input.nextInt();
			System.out.print("Please provide total credits for client: ");
			int credits = input.nextInt();
			System.out.print("Please provide allowed credit for client: ");
			int creditAllowed = input.nextInt();
			
			int balanceNew = balanceOld - charged - credits;
			
			if(balanceNew < creditAllowed)
				System.out.println("Credit limit exceeded");
			else
				System.out.println("Happy buying!");
			
			System.out.println("Would You like to check next client credit limit? (0 - no, 1 - yes)");
			flag = input.nextInt();
		}
		
		input.close();
	}

}
