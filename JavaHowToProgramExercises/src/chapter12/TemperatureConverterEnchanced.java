// Grzegorz Koñczak, 22.07.2016
// Exercise number 12.13 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;

public class TemperatureConverterEnchanced {

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TemperatureConverterEnchanced window = new TemperatureConverterEnchanced();
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
	public TemperatureConverterEnchanced() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblEnterTemperatureIn = new JLabel("Enter temperature");
		panel.add(lblEnterTemperatureIn);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblTenperatureInCelsius = new JLabel("Temperature after conversion:");
		panel.add(lblTenperatureInCelsius);

		JLabel lblCelsius = new JLabel("0");
		panel.add(lblCelsius);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblBaseTemperature = new JLabel("Base Temperature");
		panel_1.add(lblBaseTemperature);

		JRadioButton rdbtnFarenheitIn = new JRadioButton("Farenheit");
		rdbtnFarenheitIn.setSelected(true);
		buttonGroup.add(rdbtnFarenheitIn);
		panel_1.add(rdbtnFarenheitIn);

		JRadioButton rdbtnCelsiusIn = new JRadioButton("Celsius");
		buttonGroup.add(rdbtnCelsiusIn);
		panel_1.add(rdbtnCelsiusIn);

		JRadioButton rdbtnKelvinIn = new JRadioButton("Kelvin");
		buttonGroup.add(rdbtnKelvinIn);
		panel_1.add(rdbtnKelvinIn);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblConvertTo = new JLabel("Convert to:");
		panel_2.add(lblConvertTo);

		JRadioButton rdbtnFarenheitOut = new JRadioButton("Farenheit");
		buttonGroup_1.add(rdbtnFarenheitOut);
		panel_2.add(rdbtnFarenheitOut);

		JRadioButton rdbtnCelsiusOut = new JRadioButton("Celsius");
		rdbtnCelsiusOut.setSelected(true);
		buttonGroup_1.add(rdbtnCelsiusOut);
		panel_2.add(rdbtnCelsiusOut);

		JRadioButton rdbtnKelvinOut = new JRadioButton("Kelvin");
		buttonGroup_1.add(rdbtnKelvinOut);
		panel_2.add(rdbtnKelvinOut);

		// Register Item Listener in all radio buttons
		RadioButtonHandler handler = new RadioButtonHandler();
		rdbtnCelsiusIn.addItemListener(handler);
		rdbtnCelsiusOut.addItemListener(handler);
		rdbtnFarenheitIn.addItemListener(handler);
		rdbtnFarenheitOut.addItemListener(handler);
		rdbtnKelvinIn.addItemListener(handler);
		rdbtnKelvinOut.addItemListener(handler);

		// Anonymous inner class for converting temperature
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Convert from Fahrenheit to Celsius
					if (rdbtnFarenheitIn.isSelected() && rdbtnCelsiusOut.isSelected()) {
						int tempToConvert = Integer.parseInt(e.getActionCommand());
						tempToConvert = 5 * (tempToConvert - 32) / 9;
						String temperatureAfterConversion = String.format("%d", tempToConvert);
						lblCelsius.setText(temperatureAfterConversion);
					}
					// Convert from Celsius to Fahrenheit
					if (rdbtnFarenheitOut.isSelected() && rdbtnCelsiusIn.isSelected()) {
						int tempToConvert = Integer.parseInt(e.getActionCommand());
						tempToConvert = 9 * (tempToConvert + 32) / 5;
						String temperatureAfterConversion = String.format("%d", tempToConvert);
						lblCelsius.setText(temperatureAfterConversion);
					}
					// Convert from Kelvin to Celsius
					if (rdbtnKelvinIn.isSelected() && rdbtnCelsiusOut.isSelected()) {
						int tempToConvert = Integer.parseInt(e.getActionCommand());
						tempToConvert = tempToConvert - 273;
						String temperatureAfterConversion = String.format("%d", tempToConvert);
						lblCelsius.setText(temperatureAfterConversion);
					}
					// Convert from Celsius to Kelvin
					if (rdbtnKelvinOut.isSelected() && rdbtnCelsiusIn.isSelected()) {
						int tempToConvert = Integer.parseInt(e.getActionCommand());
						tempToConvert = tempToConvert + 273;
						String temperatureAfterConversion = String.format("%d", tempToConvert);
						lblCelsius.setText(temperatureAfterConversion);
					}
					// Convert from Fahrenheit to Kelvin
					if (rdbtnFarenheitIn.isSelected() && rdbtnKelvinOut.isSelected()) {
						int tempToConvert = Integer.parseInt(e.getActionCommand());
						tempToConvert = 5 * (tempToConvert + 459) / 9;
						String temperatureAfterConversion = String.format("%d", tempToConvert);
						lblCelsius.setText(temperatureAfterConversion);
					}
					// Convert from Kelvin to Fahrenheit
					if (rdbtnFarenheitOut.isSelected() && rdbtnKelvinIn.isSelected()) {
						int tempToConvert = Integer.parseInt(e.getActionCommand());
						tempToConvert = 9 * tempToConvert / 5 - 459;
						String temperatureAfterConversion = String.format("%d", tempToConvert);
						lblCelsius.setText(temperatureAfterConversion);
					}
					// No conversion
					if (rdbtnFarenheitOut.isSelected() && rdbtnFarenheitIn.isSelected()
							|| rdbtnKelvinOut.isSelected() && rdbtnKelvinIn.isSelected()
							|| rdbtnCelsiusOut.isSelected() && rdbtnCelsiusIn.isSelected()) {
						int tempToConvert = Integer.parseInt(e.getActionCommand());
						String temperatureAfterConversion = String.format("%d", tempToConvert);
						lblCelsius.setText(temperatureAfterConversion);
					}
				} catch (NumberFormatException exeption) {
					// Show error message about wrong input
					JOptionPane.showMessageDialog(frame, "Input Something! And it should be integer number...", "Wrong Input", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	// Inner class for changing focus back to text field after changing radio
	// button state
	private class RadioButtonHandler implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			textField.requestFocus();

		}

	}

}
