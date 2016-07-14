// Grzegorz Koñczak, 14.07.2016
// Exercise number 8.4 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class Cylinder {

	private int radius = 1;
	private int height = 1;
	
	public Cylinder(int radius, int height){
		if (radius > 0 && height > 0){
			this.radius = radius;
			this.height = height;
		}else
			throw new IllegalArgumentException("Radius and height should be positive numbers");
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if (radius > 0) {
			this.radius = radius;
		}else
			throw new IllegalArgumentException("Radius should be positive number");
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height > 0){
			this.height = height;
		}else
			throw new IllegalArgumentException("Height should be positive number");
	}
	
	// Calculates cylinder volume
	public static double cylinderVolume(Cylinder cylinder){
		double volume = Math.PI * Math.pow(cylinder.getRadius(), 2) * cylinder.getHeight();
		return volume;
	}
}
