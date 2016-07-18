// Grzegorz Koñczak, 16.07.2016
// Exercise number 8.6 page 398
// Exercise from Java:How to program 10th edition


package chapter8;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class SavingsAccountTest {

	public static void main(String[] args) {
		
		SavingsAccount saver1 = new SavingsAccount(BigDecimal.valueOf(2000));
		SavingsAccount saver2 = new SavingsAccount(BigDecimal.valueOf(3000));
		SavingsAccount.modifyInterestRate(BigDecimal.valueOf(4));
		
		for (int i = 0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.print(NumberFormat.getCurrencyInstance().format(saver1.getBalance()) + "   ");
			System.out.println(NumberFormat.getCurrencyInstance().format(saver2.getBalance()));
		}
		
		SavingsAccount.modifyInterestRate(BigDecimal.valueOf(5));
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.print(NumberFormat.getCurrencyInstance().format(saver1.getBalance()) + "   ");
		System.out.println(NumberFormat.getCurrencyInstance().format(saver2.getBalance()));
	}
}
