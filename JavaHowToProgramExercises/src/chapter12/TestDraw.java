// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.17 page 594
// Exercise from Java:How to program 10th edition

package chapter12;

import javax.swing.JFrame;

public class TestDraw {

	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
