// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.31 page 636
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JFrame;

public class TestDraw {

	public static void main(String[] args) {
		DrawFrame frame = new DrawFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 600);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
