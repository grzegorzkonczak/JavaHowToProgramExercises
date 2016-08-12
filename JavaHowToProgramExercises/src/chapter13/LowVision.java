// Grzegorz Koñczak, 11.08.2016
// Exercise number 13.32 page 637
// Exercise from Java:How to program 10th edition

package chapter13;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class LowVision extends JPanel {

	private JButton fontIncrease;
	private JButton fontDecrease;
	private JCheckBox fontBold;
	private JComboBox fontBox;
	private JTextArea textArea;
	private JPanel menu;
	private int fontSize = 18;
	private String fontFamily = Font.SANS_SERIF;

	private Font fontMenu = new Font(fontFamily, Font.PLAIN, 20);
	private Font fontText = new Font(fontFamily, Font.PLAIN, fontSize);
	private String increaseBtnTitle = "Increase Font";
	private String decreaseBtnTitle = "Decrease Font";
	private String boldBtnTitle = "Bold";
	private String[] fonts = { Font.SANS_SERIF, Font.SERIF, Font.MONOSPACED };

	public LowVision(){
		fontIncrease = new JButton(increaseBtnTitle);
		fontIncrease.setFont(fontMenu);
		fontIncrease.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fontSize++;
				if (fontBold.isSelected()){
					fontText = new Font(fontFamily, Font.BOLD, fontSize);
				} else {
					fontText = new Font(fontFamily, Font.PLAIN, fontSize);
				}
				textArea.setFont(fontText);
			}
		});
		
		fontDecrease = new JButton(decreaseBtnTitle);
		fontDecrease.setFont(fontMenu);
		fontDecrease.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fontSize--;
				if (fontBold.isSelected()){
					fontText = new Font(fontFamily, Font.BOLD, fontSize);
				} else {
					fontText = new Font(fontFamily, Font.PLAIN, fontSize);
				}
				textArea.setFont(fontText);
			}
		});
		
		fontBold = new JCheckBox(boldBtnTitle);
		fontBold.setFont(fontMenu);
		fontBold.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (fontBold.isSelected()){
					fontText = new Font(fontFamily, Font.BOLD, fontSize);
				} else {
					fontText = new Font(fontFamily, Font.PLAIN, fontSize);
				}
				textArea.setFont(fontText);				
			}
		});
		
		fontBox = new JComboBox<>(fonts);
		fontBox.setFont(fontMenu);
		fontBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				fontFamily = fonts[fontBox.getSelectedIndex()];
				if (fontBold.isSelected()){
					fontText = new Font(fontFamily, Font.BOLD, fontSize);
				} else {
					fontText = new Font(fontFamily, Font.PLAIN, fontSize);
				}
				textArea.setFont(fontText);	
			}
		});
		
		textArea = new JTextArea();
		textArea.setFont(fontText);
		textArea.setEditable(true);
		textArea.setText("Write here...");
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		menu = new JPanel();
		
		menu.add(fontIncrease);
		menu.add(fontDecrease);
		menu.add(fontBold);
		menu.add(fontBox);
		
		LayoutManager layout = new BorderLayout();
		this.setLayout(layout);
		this.add(textArea, BorderLayout.CENTER);
		this.add(menu, BorderLayout.NORTH);
	}

}
