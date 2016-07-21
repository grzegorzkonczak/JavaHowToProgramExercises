// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class Circle extends TwoDimensionalShape{

	public Circle(double diameter) {
		super(diameter);
	}
	
	@Override
	public double getArea() {
		double area = Math.PI * Math.pow((super.getSide() / 2), 2);
		return area;
	}
	
}
