// Grzegorz Koñczak, 22.07.2016
// Exercise number 12.10 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class ColorSelect {
	
	private static final String[] colors = {"RED", "BLUE", "GREEN", "YELlOW"};

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorSelect window = new ColorSelect();
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
	public ColorSelect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 129);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox<String> comboBox = new JComboBox<String>(colors);
		frame.getContentPane().add(comboBox, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOk = new JButton("Ok");
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JCheckBox chckbxBackground = new JCheckBox("Background");
		panel_1.add(chckbxBackground);
		
		JCheckBox chckbxForeground = new JCheckBox("Foreground");
		panel_1.add(chckbxForeground);
	}

}
