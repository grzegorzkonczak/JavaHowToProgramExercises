// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.17 page 482
// Exercise from Java:How to program 10th edition

package chapter10;

public class Bicycle implements CarbonFootprint{

	private int maxSpeed;
	private String type;
	private double weight;
	
	public Bicycle(int maxSpeed, String type, double weight) {
		this.maxSpeed = maxSpeed;
		this.type = type;
		this.weight = weight;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return String.format("This is %s bike.", getType());
	}
	
	@Override
	public double getCarbonFootprint() {
		return getWeight();
	}
}
