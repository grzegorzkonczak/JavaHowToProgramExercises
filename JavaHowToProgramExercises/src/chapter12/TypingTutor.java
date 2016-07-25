// Grzegorz Koñczak, 25.07.2016
// Exercise number 12.20 page 596
// Exercise from Java:How to program 10th edition

package chapter12;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class TypingTutor extends JPanel {

	private final char[] characters = { '`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '=', '\b', '\t',
			'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', '[', ']', '\\', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k',
			'l', ';', '\'', '\n', 'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '?', '^', '\u0020', '<', '>' };
	private JButton currentButton;
	private Color background;

	/**
	 * Create the panel.
	 */
	public TypingTutor() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel(
				"Type some text using your keyboard. The keys you press will be highlited and the text will be displayed.");
		lblNewLabel.setBounds(7, 7, 557, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNewLabel);

		JLabel lblNoteClickingThe = new JLabel(
				"Note: Clicking the buttons with your mouse will not perform any action.");
		lblNoteClickingThe.setBounds(7, 27, 381, 16);
		lblNoteClickingThe.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNoteClickingThe);

		JPanel panel = new JPanel();
		panel.setBounds(7, 47, 613, 380);
		add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JTextArea textArea = new JTextArea();
		textArea.setColumns(55);
		textArea.setRows(10);
		panel_1.add(textArea);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(5, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton button = new JButton("`");
		panel_2.add(button);

		JButton button_1 = new JButton("1");
		panel_2.add(button_1);

		JButton button_2 = new JButton("2");
		panel_2.add(button_2);

		JButton button_3 = new JButton("3");
		panel_2.add(button_3);

		JButton button_4 = new JButton("4");
		panel_2.add(button_4);

		JButton button_5 = new JButton("5");
		panel_2.add(button_5);

		JButton button_6 = new JButton("6");
		panel_2.add(button_6);

		JButton button_7 = new JButton("7");
		panel_2.add(button_7);

		JButton button_8 = new JButton("8");
		panel_2.add(button_8);

		JButton button_9 = new JButton("9");
		panel_2.add(button_9);

		JButton button_10 = new JButton("0");
		panel_2.add(button_10);

		JButton button_11 = new JButton("-");
		panel_2.add(button_11);

		JButton button_12 = new JButton("=");
		panel_2.add(button_12);

		JButton button_13 = new JButton("Backspace");
		panel_2.add(button_13);

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JButton btnTab = new JButton("Tab");
		panel_4.add(btnTab);

		JButton btnQ = new JButton("Q");
		panel_4.add(btnQ);

		JButton btnW = new JButton("W");
		panel_4.add(btnW);

		JButton btnE = new JButton("E");
		panel_4.add(btnE);

		JButton btnR = new JButton("R");
		panel_4.add(btnR);

		JButton btnT = new JButton("T");
		panel_4.add(btnT);

		JButton btnY = new JButton("Y");
		panel_4.add(btnY);

		JButton btnU = new JButton("U");
		panel_4.add(btnU);

		JButton btnI = new JButton("I");
		panel_4.add(btnI);

		JButton btnO = new JButton("O");
		panel_4.add(btnO);

		JButton btnP = new JButton("P");
		panel_4.add(btnP);

		JButton button_14 = new JButton("[");
		panel_4.add(button_14);

		JButton button_15 = new JButton("]");
		panel_4.add(button_15);

		JButton button_16 = new JButton("\\");
		panel_4.add(button_16);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);

		JButton btnCaps = new JButton("Caps");
		panel_5.add(btnCaps);

		JButton btnA = new JButton("A");
		panel_5.add(btnA);

		JButton btnS = new JButton("S");
		panel_5.add(btnS);

		JButton btnD = new JButton("D");
		panel_5.add(btnD);

		JButton btnF = new JButton("F");
		panel_5.add(btnF);

		JButton btnG = new JButton("G");
		panel_5.add(btnG);

		JButton btnH = new JButton("H");
		panel_5.add(btnH);

		JButton btnJ = new JButton("J");
		panel_5.add(btnJ);

		JButton btnK = new JButton("K");
		panel_5.add(btnK);

		JButton btnL = new JButton("L");
		panel_5.add(btnL);

		JButton button_17 = new JButton(";");
		panel_5.add(button_17);

		JButton button_18 = new JButton("\"");
		panel_5.add(button_18);

		JButton btnEnter = new JButton("Enter");
		panel_5.add(btnEnter);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(null);

		JButton btnShift = new JButton("    Shift    ");
		btnShift.setBounds(50, 5, 76, 28);
		panel_6.add(btnShift);

		JButton btnZ = new JButton("Z");
		btnZ.setBounds(131, 5, 35, 28);
		panel_6.add(btnZ);

		JButton btnX = new JButton("X");
		btnX.setBounds(171, 5, 35, 28);
		panel_6.add(btnX);

		JButton btnC = new JButton("C");
		btnC.setBounds(211, 5, 37, 28);
		panel_6.add(btnC);

		JButton btnV = new JButton("V");
		btnV.setBounds(253, 5, 35, 28);
		panel_6.add(btnV);

		JButton btnB = new JButton("B");
		btnB.setBounds(293, 5, 36, 28);
		panel_6.add(btnB);

		JButton btnN = new JButton("N");
		btnN.setBounds(334, 5, 37, 28);
		panel_6.add(btnN);

		JButton btnM = new JButton("M");
		btnM.setBounds(376, 5, 37, 28);
		panel_6.add(btnM);

		JButton button_19 = new JButton(",");
		button_19.setBounds(418, 5, 31, 28);
		panel_6.add(button_19);

		JButton button_20 = new JButton(".");
		button_20.setBounds(454, 5, 31, 28);
		panel_6.add(button_20);

		JButton button_21 = new JButton("?");
		button_21.setBounds(490, 5, 35, 28);
		panel_6.add(button_21);

		JButton button_22 = new JButton("^");
		button_22.setBounds(537, 5, 33, 28);
		panel_6.add(button_22);

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(null);

		JButton button_23 = new JButton("                                                                            ");
		button_23.setBounds(167, 5, 256, 28);
		panel_7.add(button_23);

		JButton button_24 = new JButton("<");
		button_24.setBounds(501, 5, 35, 28);
		panel_7.add(button_24);

		JButton btnV_1 = new JButton("v");
		btnV_1.setBounds(538, 5, 33, 28);
		panel_7.add(btnV_1);

		JButton button_25 = new JButton(">");
		button_25.setBounds(572, 5, 35, 28);
		panel_7.add(button_25);

		JButton[] buttons = { button, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8,
				button_9, button_10, button_11, button_12, button_13, btnTab, btnQ, btnW, btnE, btnR, btnT, btnY, btnU,
				btnI, btnO, btnP, button_14, button_15, button_16, btnA, btnS, btnD, btnF, btnG, btnH, btnJ, btnK, btnL,
				button_17, button_18, btnEnter, btnZ, btnX, btnC, btnV, btnB, btnN, btnM, button_19, button_20, button_21,
				button_22, button_23, button_24, button_25};
		background = button_1.getBackground();

		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char charTyped = e.getKeyChar();
				for (int i = 0; i < buttons.length; i++) {
					if (charTyped == characters[i]) {
						currentButton = buttons[i];
						currentButton.setBackground(Color.YELLOW);
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				for(JButton button : buttons){
					button.setBackground(background);
				}
			}
		});
	}
}
