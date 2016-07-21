// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class Triangle extends TwoDimensionalShape {

	double height;

	public Triangle(double base, double height) {
		super(base);
		this.height = height;
	}
	
	

	public double getHeight() {
		return height;
	}



	public void setHeight(double height) {
		this.height = height;
	}



	@Override
	public double getArea() {
		double area = (super.getSide() * this.getHeight()) / 2;
		return area;
	}
}
