// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.24 page 282
// Exercise from Java:How to program 10th edition

package chapter6;

public class PerfectNumberFinder {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 1000000000; i++){
			System.out.println(i);
			if (isPerfect(i)){
				System.out.println("Number " + i + " is perfect! Look:");
				System.out.print(i + " = ");
				for(int j = 1; j < i; j++){
					if (i % j == 0 && j == 1)
						System.out.print(j);
					else if (i % j == 0)
						System.out.print(" + " + j);
				}
				System.out.println();
			}
		}
	}
	
	private static boolean isPerfect(int number){
		int checkSum = 0;
		for (int i = 1; i < number; i++){
			if (number % i == 0)
				checkSum += i;
		}
		
		if(number == checkSum)
			return true;
		else
			return false;
	}
}
