// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.20 page 596
// Exercise from Java:How to program 10th edition

package chapter12;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class TypingTutorTest extends JFrame{

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		TypingTutor panel = new TypingTutor();
		
		TypingTutorTest frame = new TypingTutorTest();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,470);
		frame.add(panel);
		frame.setVisible(true);
	}
}
