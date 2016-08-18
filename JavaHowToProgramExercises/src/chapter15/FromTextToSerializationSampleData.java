// Grzegorz Koñczak, 18.08.2016
// Exercise number 15.6 page 723
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class FromTextToSerializationSampleData {

	private static Formatter outStudents;
	
	public static void main(String[] args) {
		
		try {
			outStudents = new Formatter("students.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		outStudents.format("%d %s %.2f %.2f %.2f%n", 1, "Marek", 88.00, 50.00, 78.25);
		outStudents.format("%d %s %.2f %.2f %.2f%n", 2, "Grzegorz", 88.00, 50.00, 78.25);
		outStudents.format("%d %s %.2f %.2f %.2f%n", 3, "Anna", 88.00, 50.00, 78.25);
		outStudents.format("%d %s %.2f %.2f %.2f%n", 4, "Julita", 88.00, 50.00, 78.25);
		outStudents.format("%d %s %.2f %.2f %.2f%n", 5, "Przemek", 88.00, 50.00, 78.25);
		outStudents.format("%d %s %.2f %.2f %.2f%n", 6, "Maria", 88.00, 50.00, 78.25);
		
		outStudents.close();
	}	
}
