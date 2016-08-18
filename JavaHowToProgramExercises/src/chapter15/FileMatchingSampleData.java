// Grzegorz Koñczak, 18.08.2016
// Exercise number 15.4/5 page 722
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class FileMatchingSampleData {
	
	private static Formatter outOldMaster;
	private static Formatter outTransaction;
	
	public static void main(String[] args) {
		
		try {
			outOldMaster = new Formatter("oldmast.txt");
			outTransaction = new Formatter("trans.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		outOldMaster.format("%d %s %s %.2f%n", 100, "Alan", "Jones", 348.17);
		outOldMaster.format("%d %s %s %.2f%n", 300, "Mary", "Smith", 27.19);
		outOldMaster.format("%d %s %s %.2f%n", 500, "Sam", "Sharp", 0.00);
		outOldMaster.format("%d %s %s %.2f%n", 700, "Suzy", "Green", -14.22);
		outOldMaster.format("%d %s %s %.2f%n", 1000, "Grzegorz", "Koñczak", 1000.30);
		
		outTransaction.format("%d %.2f%n", 100, 27.14);
		outTransaction.format("%d %.2f%n", 300, 62.11);
		outTransaction.format("%d %.2f%n", 400, 100.56);
		outTransaction.format("%d %.2f%n", 900, 82.17);
		outTransaction.format("%d %.2f%n", 500, -20.17);
		outTransaction.format("%d %.2f%n", 1100, 50.0);
		outTransaction.format("%d %.2f%n", 300, 83.89);
		outTransaction.format("%d %.2f%n", 700, 80.78);
		outTransaction.format("%d %.2f%n", 700, 1.53);
		
		outOldMaster.close();
		outTransaction.close();
	}
}
