// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.25 page 240
// Exercise from Java:How to program 10th edition

package chapter5;

import java.util.Scanner;

public class DiamonndModified {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int size;
		//check if the input number is between 1 - 19 else repeat:
		do {
			System.out.printf("Please enter any odd number b/w 1 and 19");
			size = input.nextInt();
		}while( !(size%2!=0) || !(size>1&&size<19)  ); // it should be odd and b/w 1-19
		
		// Printing top and middle of diamond
		for (int i = 1; i < size + 1; i += 2){
			for (int j = 1; j < size - (i / 2); j++){
				System.out.print(' ');
			}
			for (int j = 0; j < i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		
		// Printing bottom of diamond
		for (int i = size - 2; i > 0; i -= 2 ){
			for (int j = 1; j < size - (i / 2); j++){
				System.out.print(' ');
			}
			for (int j = 0; j < i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
