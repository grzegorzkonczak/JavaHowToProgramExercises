// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.19 page 595
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ecofont {

	private JFrame frame;
	
	int fontSize = 9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ecofont window = new Ecofont();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ecofont() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		
		JButton btnDecreaseFontSize = new JButton("Decrease Font Size");
		btnDecreaseFontSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontSize--;
				textArea.setFont(new Font("Ecofont Vera Sans", Font.PLAIN, fontSize));
			}
		});
		frame.getContentPane().add(btnDecreaseFontSize, BorderLayout.NORTH);
		
		JButton btnIncreaseFontSize = new JButton("Increase Font Size");
		btnIncreaseFontSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fontSize++;
				textArea.setFont(new Font("Ecofont Vera Sans", Font.PLAIN, fontSize));
			}
		});
		frame.getContentPane().add(btnIncreaseFontSize, BorderLayout.SOUTH);
		
		textArea.setFont(new Font("Ecofont Vera Sans", Font.PLAIN, 9));
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
	}

}
