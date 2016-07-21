// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public abstract class Shape {

	private double side;
	
	public Shape(double side) {
		this.side = side;
	}


	public double getSide() {
		return side;
	}



	public void setSide(double side) {
		this.side = side;
	}



	public abstract double getArea();
}
