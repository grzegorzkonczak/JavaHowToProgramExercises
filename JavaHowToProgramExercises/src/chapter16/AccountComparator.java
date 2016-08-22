// Grzegorz Koñczak, 22.08.2016
// Exercise number 16.14 page 769
// Exercise from Java:How to program 10th edition

package chapter16;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account>{

	@Override
	public int compare(Account o1, Account o2) {
		double balance = o1.getBalance() - o2.getBalance();
		int result = 0;
		if (balance > 0){
			result = -1;
		}else if (balance < 0){
			result = 1;
		}
		return result;
	}

}
