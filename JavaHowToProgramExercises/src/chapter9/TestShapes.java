// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.8 page 435
// Exercise from Java:How to program 10th edition

package chapter9;

public class TestShapes {

	public static void main(String[] args) {
		
		Point uL = new Point(2, 5);
		Point uR = new Point(8, 5);
		Point lL = new Point(0, 0);
		Point lR = new Point(6, 0);
		
		Parallelogram test = new Parallelogram(uL, lL, uR, lR);
		
		System.out.println(test.calculateArea());
	}
}
