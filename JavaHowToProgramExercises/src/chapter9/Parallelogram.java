// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.8 page 435
// Exercise from Java:How to program 10th edition

package chapter9;

public class Parallelogram extends Trapezoid {

	public Parallelogram(Point upperLeft, Point lowerLeft, Point upperRight, Point lowerRight) {
		super(upperLeft, lowerLeft, upperRight, lowerRight);
	}
	
	@Override
	public int calculateArea(){
		int area = this.calculateLowerSideLength() * this.calculateHeight();
		return area;
	}
	
}
