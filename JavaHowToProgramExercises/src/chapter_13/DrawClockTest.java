// Grzegorz Koñczak, 06.08.2016
// Exercise number 13.8 page 634
// Exercise from Java:How to program 10th edition


package chapter_13;

import javax.swing.JFrame;

public class DrawClockTest {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DrawClock panel = new DrawClock();
		frame.add(panel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
