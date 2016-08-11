// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.26 page 635
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JFrame;

public class PolylineSpiralTest {

	public static void main(String[] args) {

		JFrame frame = new JFrame("Polyline");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		PolylineSpiral panel = new PolylineSpiral();
		frame.add(panel);
		frame.setSize(340, 340);
		frame.setVisible(true);
	}
}
