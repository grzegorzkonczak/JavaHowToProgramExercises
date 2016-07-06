// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.28 page 282
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;

public class SportsWeather {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter temperature in Celsius: ");
		sportsRecommender(input.nextDouble());
	}
	
	private static void sportsRecommender(double temperature){
		if(temperature >= 20 && temperature <= 30){
			System.out.println("Great weather for sports!");
		}else if(temperature >= 10 && temperature <= 40){
			System.out.println("Reasonable weather for sports...");
		}else{
			System.out.println("Stay home!");
		}
	}
}
