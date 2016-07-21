// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class Square extends TwoDimensionalShape {

	public Square(double side) {
		super(side);
	}

	@Override
	public double getArea() {
		double area = super.getSide() * super.getSide();
		return area;
	}

}
