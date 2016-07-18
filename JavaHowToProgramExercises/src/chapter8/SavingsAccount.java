// Grzegorz Koñczak, 16.07.2016
// Exercise number 8.6 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount {

	private static BigDecimal annualInterestRate;
	private BigDecimal savingsBalance;
	
	public SavingsAccount (BigDecimal savingsBalance){
		this.savingsBalance = savingsBalance;
	}
	
	public void calculateMonthlyInterest(){
		savingsBalance = savingsBalance.add(savingsBalance.multiply(annualInterestRate).subtract(savingsBalance)
				.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_EVEN));
	}
	
	public static void modifyInterestRate(BigDecimal interest){
		BigDecimal mid = interest.divide(BigDecimal.valueOf(100));
		annualInterestRate = mid.add(BigDecimal.ONE);
	}
	
	public BigDecimal getBalance(){
		return savingsBalance;
	}
}
