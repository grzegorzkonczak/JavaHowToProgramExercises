// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.25 page 635
// Exercise from Java:How to program 10th edition

package chapter_13;

import javax.swing.JFrame;

public class TortoiseAndHareGuiMain {

public static void main(String[] args) {
		
		JFrame frame = new JFrame("Tortoise and Hare");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TortoiseAndHareGui panel = new TortoiseAndHareGui();
		frame.add(panel);
		frame.setSize(340, 340);
		frame.setVisible(true);
		panel.run();
	}
}
