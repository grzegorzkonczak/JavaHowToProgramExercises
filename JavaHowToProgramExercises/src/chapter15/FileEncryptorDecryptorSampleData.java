// Grzegorz Koñczak, 19.08.2016
// Exercise number 15.8 page 725
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.FileNotFoundException;
import java.util.Formatter;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class FileEncryptorDecryptorSampleData {

	private static Formatter output;
	
	public static void main(String[] args) {
		try {
			output = new Formatter("toEncrypt.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		output.format("%s %s %s %s%n%s %s %s %s %s%n", "ladna", "dzisiaj", "pogoda", "milordzie",
				"lepiej", "zeby", "nam", "to", "dzialalo");
		
		output.close();
	}
}
