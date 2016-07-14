// Grzegorz Koñczak, 14.07.2016
// Exercise number 8.4 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class CylinderTest {

	public static void main(String[] args) {
		
		// Creating cylinder with proper attributes
		Cylinder cylinder1 = new Cylinder(2, 3);
		
		// Attempting to create cylinder with out of range attributes
		try{
			Cylinder cylinder2 = new Cylinder(-7, 0);
		}catch (IllegalArgumentException e){
			System.out.println(e);
		}
		
		// Testing static method for calculating cylinder volume
		System.out.println("Volume of Cylinder is: " + Cylinder.cylinderVolume(cylinder1));
	}
}
