// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.8 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import javax.swing.JFrame;
import javax.swing.UIManager;


public class FileEncryptorDecryptorMain {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		FileEncryptorDecryptor panel = new FileEncryptorDecryptor();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(481, 178);
		frame.setVisible(true);
	}
}
