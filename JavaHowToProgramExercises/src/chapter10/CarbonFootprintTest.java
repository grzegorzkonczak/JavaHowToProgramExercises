// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.17 page 482
// Exercise from Java:How to program 10th edition

package chapter10;

import java.util.ArrayList;

public class CarbonFootprintTest {

	public static void main(String[] args) {
		Building building = new Building(3, 14, "Nice");
		Car car = new Car("Fast", 50, 4);
		Bicycle bicycle = new Bicycle(23, "Red", 4);
		
		ArrayList<CarbonFootprint> footprintGeneratrs = new ArrayList<>();
		
		footprintGeneratrs.add(bicycle);
		footprintGeneratrs.add(car);
		footprintGeneratrs.add(building);
		
		for (CarbonFootprint generator : footprintGeneratrs){
			System.out.println(generator);
			System.out.printf("Footprint is %.2f%n%n", generator.getCarbonFootprint());
		}
	}
}
