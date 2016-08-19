// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.26 page 683
// Exercise from Java:How to program 10th edition

package chapter14;

import javax.swing.JFrame;

public class CookingWithHealthierIngredientsMain {

	
	public static void main(String[] args) {
	
		CookingWithHealthierIngredients panel = new CookingWithHealthierIngredients();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
