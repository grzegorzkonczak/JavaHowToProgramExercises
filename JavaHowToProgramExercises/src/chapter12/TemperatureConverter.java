// Grzegorz Koñczak, 22.07.2016
// Exercise number 12.12 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TemperatureConverter {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperatureConverter window = new TemperatureConverter();
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
	public TemperatureConverter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 367, 108);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblEnterTemperatureIn = new JLabel("Enter temperature in Fahrenheit");
		panel.add(lblEnterTemperatureIn);
		JLabel lblCelsius = new JLabel("0");
		
		textField = new JTextField();
		
		// Action listener for converting temperature
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tempToConvert = Integer.parseInt(e.getActionCommand());
				tempToConvert = 5 * (tempToConvert - 32) / 9;
				String temperatureInCelsius = String.format("%d", tempToConvert);
				lblCelsius.setText(temperatureInCelsius);
			}
		});
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblTenperatureInCelsius = new JLabel("Tenperature in Celsius:");
		panel.add(lblTenperatureInCelsius);
		
		panel.add(lblCelsius);

	}

}
