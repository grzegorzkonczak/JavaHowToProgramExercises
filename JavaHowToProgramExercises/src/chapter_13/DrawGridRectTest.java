// Grzegorz Ko�czak, 06.08.2016
// Exercise number 13.13 page 634
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JFrame;

public class DrawGridRectTest {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Grid");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawGridRect panel = new DrawGridRect();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
