// Grzegorz Koñczak, 28.07.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

package chapter12.exercise12_18;

import javax.swing.UIManager;

public class ATMCaseStudy {
	// main method creates and runs the ATM
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		ATM theATM = new ATM();
		theATM.run();
	} // end main
} // end class ATMCaseStudy
