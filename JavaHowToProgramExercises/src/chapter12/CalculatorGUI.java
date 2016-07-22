// Grzegorz Koñczak, 22.07.2016
// Exercise number 12.9 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGUI {

	private JFrame frmCalculator;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 217, 258);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculator.getContentPane().setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		frmCalculator.getContentPane().add(textField, BorderLayout.NORTH);
		textField.setColumns(25);
		
		JPanel panel = new JPanel();
		frmCalculator.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton button = new JButton("7");
		panel.add(button);
		
		JButton button_2 = new JButton("8");
		panel.add(button_2);
		
		JButton button_1 = new JButton("9");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(button_1);
		
		JButton button_3 = new JButton("/");
		panel.add(button_3);
		
		JButton button_4 = new JButton("4");
		panel.add(button_4);
		
		JButton button_5 = new JButton("5");
		panel.add(button_5);
		
		JButton button_6 = new JButton("6");
		panel.add(button_6);
		
		JButton button_7 = new JButton("*");
		panel.add(button_7);
		
		JButton button_8 = new JButton("1");
		panel.add(button_8);
		
		JButton button_9 = new JButton("2");
		panel.add(button_9);
		
		JButton button_10 = new JButton("3");
		panel.add(button_10);
		
		JButton button_11 = new JButton("-");
		panel.add(button_11);
		
		JButton button_12 = new JButton("0");
		panel.add(button_12);
		
		JButton button_13 = new JButton(".");
		panel.add(button_13);
		
		JButton button_14 = new JButton("=");
		panel.add(button_14);
		
		JButton button_15 = new JButton("+");
		panel.add(button_15);
	}

}
