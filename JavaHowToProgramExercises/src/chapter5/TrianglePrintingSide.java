// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.22 page 239
// Exercise from Java:How to program 10th edition

package chapter5;

public class TrianglePrintingSide {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++){
			if (i == 0){
				for (int j = 0; j < 40; j++ ){
					if (j == 0){
						System.out.print('*');
					}else if (j < 10){
						System.out.print(' ');
					}else if (j < 30){
						System.out.print('*');
					}else if (j < 39){
						System.out.print(' ');
					}else
						System.out.print('*');
				}
				System.out.println();
			}
			
			
			if (i > 0){
				for (int j = 0; j < 40; j++ ){
					if (j < 1 + i){
						System.out.print('*');
					}else if (j < 10){
						System.out.print(' ');
					}else if (j < 20 - i){
						System.out.print('*');
					}else if(j < 20 + i){
						System.out.print(' ');
					}else if (j < 30){
						System.out.print('*');
					}else if(j < 39 - i){
						System.out.print(' ');
					}else
						System.out.print('*');
				}
				System.out.println();
			}
		}
	}
}
