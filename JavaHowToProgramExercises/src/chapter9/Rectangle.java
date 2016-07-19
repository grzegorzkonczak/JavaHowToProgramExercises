// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.8 page 435
// Exercise from Java:How to program 10th edition

package chapter9;

public class Rectangle extends Quadrilateral {

	public Rectangle(Point upperLeft, Point lowerLeft, Point upperRight, Point lowerRight) {
		super(upperLeft, lowerLeft, upperRight, lowerRight);
	}

	
	public int calculateSide(){
		int side = Math.abs(this.getUpperLeft().getX() - this.getUpperRight().getX());
		return side;
	}
	
	public int calculateArea(){
		int area = this.calculateSide() * this.calculateHeight();
		return area;
	}
}
