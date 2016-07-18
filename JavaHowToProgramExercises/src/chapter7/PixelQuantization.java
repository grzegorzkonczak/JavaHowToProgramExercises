// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.10 page 342
// Exercise from Java:How to program 10th edition

package chapter7;

public class PixelQuantization {

	public static void main(String[] args) {
		
		int[] pictureRow = {12,22,31,74,56,123,60,195,188,163,1,7,13,44,50};
		
		for(int pixel : pictureRow){
			System.out.printf("%-5d", pixel);
		}
		System.out.println();
		
		for(int pixel = 0; pixel < pictureRow.length; pixel++){
			if(pictureRow[pixel] < 21)
				pictureRow[pixel] = 10;
			else if(pictureRow[pixel] < 41)
				pictureRow[pixel] = 30;
			else if(pictureRow[pixel] < 61)
				pictureRow[pixel] = 50;
			else if(pictureRow[pixel] < 81)
				pictureRow[pixel] = 70;
			else if(pictureRow[pixel] < 101)
				pictureRow[pixel] = 90;
			else if(pictureRow[pixel] < 121)
				pictureRow[pixel] = 110;
			else if(pictureRow[pixel] < 141)
				pictureRow[pixel] = 130;
			else if(pictureRow[pixel] < 161)
				pictureRow[pixel] = 150;
			else if(pictureRow[pixel] < 181)
				pictureRow[pixel] = 170;
			else
				pictureRow[pixel] = 190;
		}
		
		for(int pixel : pictureRow){
			System.out.printf("%-5d", pixel);
		}
	}
}
