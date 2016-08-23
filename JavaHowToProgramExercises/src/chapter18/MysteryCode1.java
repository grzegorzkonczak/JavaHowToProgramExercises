// Grzegorz Koñczak, 23.08.2016
// Exercise number 18.7 page 847
// Exercise from Java:How to program 10th edition

package chapter18;

public class MysteryCode1 {

	
	public static void main(String[] args) {
		int result = mysteryRecursive(5);
		int checkResult = mysteryOriginal(5);
		
		System.out.println(result + " == " + checkResult);
	}

	private static int mysteryOriginal(int x) {
		int sum = 0;
		for (int i = x; i > 0; i--) {
			sum = sum + i;
		}
		return sum;
	}

	private static int mysteryRecursive(int i) {
		if (i == 0){
			return 0;
		}else {
			return i + mysteryRecursive(i -1);
		}
	}
}
