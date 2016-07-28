// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ATMGUI extends JPanel {

	private ATM atm;
	private Keypad keypad;
	private static JTextArea screenPanel;
	/**
	 * Create the panel.
	 */
	public ATMGUI(ATM atm) {
		this.keypad = atm.getKeypad();
		setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		screenPanel = new JTextArea();
		screenPanel.setLineWrap(true);
		screenPanel.setWrapStyleWord(true);
		screenPanel.setEditable(false);
		panel.add(screenPanel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button = new JButton("1");
		button.setBounds(0, 1, 52, 37);
		panel_2.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.setBounds(54, 1, 52, 37);
		panel_2.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.setBounds(107, 1, 52, 37);
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.setBounds(0, 38, 52, 37);
		panel_2.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.setBounds(54, 38, 52, 37);
		panel_2.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.setBounds(107, 38, 52, 37);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.setBounds(0, 75, 52, 37);
		panel_2.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.setBounds(54, 75, 52, 37);
		panel_2.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.setBounds(107, 75, 52, 37);
		panel_2.add(button_8);
		
		JButton button_9 = new JButton("0");
		button_9.setBounds(0, 112, 52, 37);
		panel_2.add(button_9);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(54, 112, 105, 37);
		panel_2.add(btnEnter);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnRemoveCash = new JButton("Remove Cash");
		btnRemoveCash.setBounds(6, 0, 213, 75);
		panel_3.add(btnRemoveCash);
		
		JButton btnInsertEnvelope = new JButton("Insert Envelope");
		btnInsertEnvelope.setBounds(6, 75, 213, 75);
		panel_3.add(btnInsertEnvelope);

		this.atm = atm;
		keypad = atm.getKeypad();
		
		button.addActionListener(keypad);
		button_1.addActionListener(keypad);
		button_2.addActionListener(keypad);
		button_3.addActionListener(keypad);
		button_4.addActionListener(keypad);
		button_5.addActionListener(keypad);
		button_6.addActionListener(keypad);
		button_7.addActionListener(keypad);
		button_8.addActionListener(keypad);
		button_9.addActionListener(keypad);
		btnEnter.addActionListener(keypad);
		btnInsertEnvelope.addActionListener(keypad);
		btnRemoveCash.addActionListener(keypad);
	}

	public static void displayMessage (String message){
		screenPanel.setText(message);
	}
	
	public static void appendMessage (String message){
		screenPanel.append(message);
	}
}
