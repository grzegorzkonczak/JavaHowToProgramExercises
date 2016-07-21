// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.17 page 482
// Exercise from Java:How to program 10th edition

package chapter10;

public class Building implements CarbonFootprint{

	private int height;
	private double volume;
	private String type;
	
	
	public Building(int height, double volume, String type) {
		this.height = height;
		this.volume = volume;
		this.type = type;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public double getVolume() {
		return volume;
	}



	public void setVolume(double volume) {
		this.volume = volume;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return String.format("This is %s building", getType());
	}
	
	@Override
	public double getCarbonFootprint() {
		return getVolume();
	}
}
