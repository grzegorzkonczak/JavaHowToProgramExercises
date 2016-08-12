// Grzegorz Koñczak, 12.08.2016
// Exercise number 14.7 page 679
// Exercise from Java:How to program 10th edition

package chapter14;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PigLatin {

	private static JTextArea textArea;

	public static void main(String[] args) {

		JPanel panel = new JPanel();
		textArea = new JTextArea();
		LayoutManager layout = new BorderLayout();
		panel.setLayout(layout);
		panel.add(textArea);

		JFrame frame = new JFrame("Pig Latin");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.add(panel);
		frame.setVisible(true);

		String sentence = JOptionPane.showInputDialog("Enter sentence to translate to Pig Latin:");
		String[] words = sentence.split("\\s");
		for (String string : words) {
			printLatinWord(string);
		}
	}

	private static void printLatinWord(String string) {
		StringBuilder builder = new StringBuilder(string);
		builder.append(builder.charAt(0));
		builder.delete(0, 1);
		builder.append("ay");
		String latin = builder.toString();
		latin = latin.toLowerCase();
		textArea.append(latin);
		textArea.append("\n");
	}
}
