// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.24 page 240
// Exercise from Java:How to program 10th edition

package chapter5;

public class DiamondShape {

	public static void main(String[] args) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++){
				if (i == 0 || i == 8){
					if (j < 4){
						System.out.print(' ');
					}else if (j == 4){
						System.out.print('*');
					}else
						System.out.print(' ');
				}
				if (i == 1 || i == 7){
					if (j < 3){
						System.out.print(' ');
					}else if (j < 6){
						System.out.print('*');
					}else
						System.out.print(' ');
				}
				if (i == 2 || i == 6){
					if (j < 2){
						System.out.print(' ');
					}else if (j < 7){
						System.out.print('*');
					}else
						System.out.print(' ');
				}
				if (i == 3 || i == 5){
					if (j < 1){
						System.out.print(' ');
					}else if (j < 8){
						System.out.print('*');
					}else
						System.out.print(' ');
				}
				if (i == 4)
					System.out.print('*');
			}
			System.out.println();
		}
	}
}
