// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.16 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JFrame;

public class CubeTest {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Cube");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Cube panel = new Cube();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
