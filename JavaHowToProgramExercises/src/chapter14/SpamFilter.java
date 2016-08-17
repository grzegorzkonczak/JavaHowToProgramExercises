// Grzegorz Koñczak, 17.08.2016
// Exercise number 14.27 page 684
// Exercise from Java:How to program 10th edition

package chapter14;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SpamFilter extends JPanel {

	private JTextArea textArea = new JTextArea("Paste mail here...");
	private JButton action = new JButton("Scan");
	private LayoutManager layout = new BorderLayout();
	private String[] keyWords = { "sour", "milk", "lemon", "sugar", "butter", "flour", "mayonnaise", "oil",
	"bread" };
	int spamScore = 0;

	public SpamFilter() {
		this.setLayout(layout);
		this.add(textArea, BorderLayout.CENTER);
		this.add(action, BorderLayout.SOUTH);
		
		action.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] tokenizedMail = textArea.getText().split("\\s");
				for (String keyword : keyWords) {
					for (String mailword : tokenizedMail) {
						if(keyword.equals(mailword)){
							spamScore++;
						}
					}
				}
				if (spamScore < 10){
					textArea.append("\nNot Spam");
				}else if (spamScore < 20){
					textArea.append("\nNot clear if Spam");
				}else{
					textArea.append("\nDefinietly Spam!");
				}
				
				spamScore = 0;
			}
		});
	}
}
