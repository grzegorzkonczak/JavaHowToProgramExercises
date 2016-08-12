// Grzegorz Koñczak, 07.08.2016
// Exercise number 13.18/19/20/21/22 page 634
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class ScreenSaverTest {
	private static JTextField lineNumberChooser;

	public static void main(String[] args) {

		lineNumberChooser = new JTextField("Enter number of shapes here");
		JFrame frame = new JFrame("Screen Saver");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ScreenSaver panel = new ScreenSaver();
		frame.add(lineNumberChooser, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(800, 800);
		frame.setVisible(true);

		lineNumberChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setNumberOfLines(Integer.parseInt(lineNumberChooser.getText()));
			}
		});
	}
}
