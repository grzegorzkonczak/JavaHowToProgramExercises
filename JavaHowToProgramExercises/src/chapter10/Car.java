// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.17 page 482
// Exercise from Java:How to program 10th edition

package chapter10;

public class Car implements CarbonFootprint{

	private String model;
	private double engineVolume;
	private int wheels;
	
	public Car(String model, double engineVolume, int wheels) {
		this.model = model;
		this.engineVolume = engineVolume;
		this.wheels = wheels;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getEngineVolume() {
		return engineVolume;
	}

	public void setEngineVolume(double engineVolume) {
		this.engineVolume = engineVolume;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	@Override
	public String toString() {
		return String.format("This is %s car.", getModel());
	}
	
	@Override
	public double getCarbonFootprint() {
		return getEngineVolume();
	}
}
