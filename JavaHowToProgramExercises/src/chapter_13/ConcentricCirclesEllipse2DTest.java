// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.7 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JFrame;

public class ConcentricCirclesEllipse2DTest {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Circles");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ConcentricCirclesEllipse2D panel = new ConcentricCirclesEllipse2D();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
