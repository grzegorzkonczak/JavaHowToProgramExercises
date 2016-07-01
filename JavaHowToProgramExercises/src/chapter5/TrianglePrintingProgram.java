// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.15 page 238
// Exercise from Java:How to program 10th edition

package chapter5;

public class TrianglePrintingProgram {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < i+1; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10 - i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 0; i < 10; i++){
			for(int j = 1; j < i+1; j++){
				System.out.print(' ');
			}
			for(int j = 0; j < 10 - i; j++){
				System.out.print('*');
			}
			System.out.println();
		}
		
		System.out.println();

		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10 - (i+1); j++){
				System.out.print(' ');
			}
			for(int j = 0; j < i + 1; j++){
				System.out.print('*');
			}
			System.out.println();
		}
	}
}
