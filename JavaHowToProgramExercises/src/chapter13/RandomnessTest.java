// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.10 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.Color;

import javax.swing.JFrame;

public class RandomnessTest {
	
public static void main(String[] args) {
		
		JFrame frame = new JFrame("Fan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Randomness panel = new Randomness();
		frame.add(panel);
		frame.setSize(600, 600);
		frame.setVisible(true);
	}

}
