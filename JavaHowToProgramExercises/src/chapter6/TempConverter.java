// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.22 page 282
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class TempConverter {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter temperature:");
		double temperature = input.nextDouble();
		System.out.println("Convert to: 1 - Celsius, 2 - Kelvin ???");
		int convertFlag = input.nextInt();
		if(convertFlag == 1){
			System.out.println(temperature + " in Kelvin is " + celsius(temperature));
		}else{
			System.out.println(temperature + " in Celsius is " + kelvin(temperature));
		}
	}

	private static double kelvin(double cels) {
		double kelv = cels + 273.15;
		return kelv;
	}

	private static double celsius(double kelv) {
		double cels = kelv - 273.15;
		return cels;
	}
}
