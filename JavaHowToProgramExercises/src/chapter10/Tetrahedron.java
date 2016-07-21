// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.13 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class Tetrahedron extends ThreeDimensionalShape{

	double height;

	public Tetrahedron(double side, double height) {
		super(side);
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}



	@Override
	public double getArea() {
		double area = Math.pow(getSide(), 2) * Math.sqrt(3);
		return area;
	}
	
	@Override
	public double getVolume() {
		double volume = (getSide() * getHeight()) / 3;
		return volume;
	}
}
