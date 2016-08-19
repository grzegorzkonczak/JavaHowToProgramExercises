// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.9 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import javax.swing.JFrame;

public class TestDraw {

	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setVisible(true);
	}
}
