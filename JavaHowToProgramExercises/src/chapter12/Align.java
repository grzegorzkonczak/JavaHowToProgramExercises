// Grzegorz Koñczak, 22.07.2016
// Exercise number 12.8 page 592
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Align {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Align window = new Align();
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
	public Align() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 288, 140);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[90px]", "[18px][18px][][][][][]"));
		
		JCheckBox chckbxSnapToGrid = new JCheckBox("Snap to Grid");
		panel.add(chckbxSnapToGrid, "cell 0 3,alignx left,aligny center");
		
		JCheckBox chckbxShowGrid = new JCheckBox("Show Grid");
		panel.add(chckbxShowGrid, "cell 0 4,alignx left,aligny center");
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new MigLayout("", "[67px]", "[38px][38px][38px]"));
		
		JButton btnOk = new JButton("Ok");
		panel_1.add(btnOk, "cell 0 0,grow");
		
		JButton btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel, "cell 0 1,grow");
		
		JButton btnHelp = new JButton("Help");
		panel_1.add(btnHelp, "cell 0 2,grow");
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new MigLayout("", "[10px][67px]", "[28px][28px][][]"));
		
		JLabel lblX = new JLabel("X:");
		panel_2.add(lblX, "cell 0 1,alignx left,aligny center");
		
		textField = new JTextField();
		textField.setText("8");
		panel_2.add(textField, "cell 1 1,alignx left,aligny top");
		textField.setColumns(5);
		
		JLabel lblY = new JLabel("Y:");
		panel_2.add(lblY, "cell 0 2,alignx left,aligny center");
		
		textField_1 = new JTextField();
		textField_1.setText("8");
		panel_2.add(textField_1, "cell 1 2,alignx left,aligny top");
		textField_1.setColumns(5);
	}
}
