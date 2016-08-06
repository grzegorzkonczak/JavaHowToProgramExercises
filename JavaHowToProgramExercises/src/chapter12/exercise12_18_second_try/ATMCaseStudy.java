package chapter12.exercise12_18_second_try;

import javax.swing.UIManager;

// Grzegorz Koñczak, 05.08.2016
// Exercise number 12.18 page 595
// Exercise from Java:How to program 10th edition

public class ATMCaseStudy
{
   // main method creates and runs the ATM
   public static void main(String[] args)
   {
	   try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
      ATM theATM = new ATM();
      theATM.buildGUI();
   } // end main
} // end class ATMCaseStudy 
