// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.10 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

import java.util.EnumSet;

public class FoodTest {

	public static void main(String[] args) {
		
		System.out.println("All foods:");
		
		// print all foods in enum food
		for (Food food : Food.values()){
			System.out.println(food + " " + food.getType() + " " + food.getCalories());
		}
		
		System.out.println();
		System.out.println("Some foods:");
		
		for (Food food : EnumSet.range(Food.APPLE, Food.BANANA)){
			System.out.println(food + " " + food.getType() + " " + food.getCalories());
		}
	}
}
