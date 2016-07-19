// Grzegorz Koñczak, 19.07.2016
// Exercise number 8.1 page 393
// Exercise from Java:How to program 10th edition

package chapter8;

import javax.swing.JFrame;

public class TestDraw {
	public static void main(String[] args) {
		DrawPanel panel = new DrawPanel();
		JFrame app = new JFrame();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.setSize(300, 300);
		app.setVisible(true);
	}
} // end class TestDraw
