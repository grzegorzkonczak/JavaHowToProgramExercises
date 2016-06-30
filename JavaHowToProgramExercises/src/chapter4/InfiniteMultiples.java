// Grzegorz Koñczak, 30.06.2016
// Exercise number 4.33 page 192
// Exercise from Java:How to program 10th edition

package chapter4;

public class InfiniteMultiples {

	public static void main(String[] args) {
		
		int multiple = 2;
		
		while(true){
			System.out.println(" " + multiple);
			multiple *= multiple;
		}
	}

}
