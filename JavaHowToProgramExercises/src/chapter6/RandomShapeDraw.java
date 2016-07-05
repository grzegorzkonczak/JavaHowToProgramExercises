// Grzegorz Koñczak, 05.07.2016
// Exercise number 6.2 page 271
// Exercise from Java:How to program 10th edition

package chapter6;

import javax.swing.JFrame;

public class RandomShapeDraw {

	public static void main(String[] args) {

		RandomShape panel = new RandomShape();

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
