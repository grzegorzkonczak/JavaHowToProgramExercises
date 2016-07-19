// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.8 page 435
// Exercise from Java:How to program 10th edition

package chapter9;

public class Trapezoid extends Quadrilateral {

	public Trapezoid(Point upperLeft, Point lowerLeft, Point upperRight, Point lowerRight) {
		super(upperLeft, lowerLeft, upperRight, lowerRight);
	}

	public int calculateUpperSideLength(){
		int upperSide = Math.abs(this.getUpperLeft().getX() - this.getUpperRight().getX());
		return upperSide;
	}
	
	public int calculateLowerSideLength(){
		int upperSide = Math.abs(this.getLowerLeft().getX() - this.getLowerRight().getX());
		return upperSide;
	}
	
	public int calculateArea(){
		int area = (((this.calculateLowerSideLength() + this.calculateUpperSideLength())
				* this.calculateHeight()) / 2);
		return area;
	}
}
