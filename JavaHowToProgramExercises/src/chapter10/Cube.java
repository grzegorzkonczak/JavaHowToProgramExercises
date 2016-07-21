// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class Cube extends ThreeDimensionalShape {

	public Cube(double side) {
		super(side);
	}

	@Override
	public double getArea() {
		double area = 6 * Math.pow(getSide(), 2);
		return area;
	}
	
	@Override
	public double getVolume() {
		double volume = Math.pow(getSide(), 3);
		return volume;
	}
}
