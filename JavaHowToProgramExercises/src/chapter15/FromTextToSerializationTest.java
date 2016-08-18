// Grzegorz Koñczak, 18.08.2016
// Exercise number 15.6 page 723
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FromTextToSerializationTest {

	private static ObjectInputStream inStudents;

	public static void main(String[] args) {

		try {
			inStudents = new ObjectInputStream(Files.newInputStream(Paths.get("students.ser")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.printf("%-10s %-10s %-10s %-10s %-10s%n", "Id", "Name", "Grade 1", "Grade 2", "Grade 3");
			while (true) {
				Student student = (Student) inStudents.readObject();
				System.out.printf("%-10d %-10s %-10.2f %-10.2f %-10.2f%n", student.getId(), student.getName(), student.getGrade1(),
						student.getGrade2(), student.getGrade3());
			}
		}catch (EOFException eofException){
			System.out.println("\nNo more records\n");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
