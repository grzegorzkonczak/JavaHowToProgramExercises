// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.12 page 848
// Exercise from Java:How to program 10th edition

package chapter18;

public class MysteryCode3 {
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		mystery(array, 0, array.length-1);
		for (int i : array) {
			System.out.println(i);
		}
	}

	private static void mystery(int[] array2, int x, int y) {
		if (x < y){
			int temp = array2[x];
			array2[x] = array2[y];
			array2[y] = temp;
			x++; y--;
			mystery(array2, x, y);
		}
	}
}
