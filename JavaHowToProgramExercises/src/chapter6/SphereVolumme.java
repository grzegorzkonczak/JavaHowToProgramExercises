// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.6 page 277
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class SphereVolumme {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter radius of the sphere You want to calculate volume of:");
		double radius = input.nextDouble();
		
		System.out.println("The voulume of sphere is: " + sphereVolume(radius));
	}
	
	public static double sphereVolume(double radius){
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		return volume;
	}
}
