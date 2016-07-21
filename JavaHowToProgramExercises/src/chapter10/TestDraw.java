// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.1 page 476
// Exercise from Java:How to program 10th edition

package chapter10;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestDraw {
	public static void main(String[] args) {
		DrawPanel panel = new DrawPanel();
		JLabel infoLabel = new JLabel(panel.statusText());
		JFrame app = new JFrame();

		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(panel);
		app.add(infoLabel, BorderLayout.SOUTH);
		app.setSize(300, 300);
		app.setVisible(true);
	}
} // end class TestDraw
