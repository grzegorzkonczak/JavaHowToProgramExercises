// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class Sphere extends ThreeDimensionalShape {

	public Sphere(double diameter) {
		super(diameter);
	}

	@Override
	public double getArea() {
		double area = 4 * (Math.PI * (Math.pow((getSide() / 2), 2)));
		return area;
	}
	
	@Override
	public double getVolume() {
		double volume = 4 * (Math.PI * (Math.pow((getSide() / 2), 3))) / 3;
		return volume;
	}
}
