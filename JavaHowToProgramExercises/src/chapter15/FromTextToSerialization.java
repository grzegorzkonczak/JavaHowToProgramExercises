// Grzegorz Koñczak, 18.08.2016
// Exercise number 15.6 page 723
// Exercise from Java:How to program 10th edition

package chapter15;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FromTextToSerialization {

	private static Scanner inStudents;
	private static ObjectOutputStream outStudentsSerialized;

	public static void main(String[] args) {
		openFiles();
		transferFiles();
		closeFiles();
	}

	private static void transferFiles() {
		while (inStudents.hasNext()) {
			Student student = new Student(inStudents.nextInt(), inStudents.next(), inStudents.nextDouble(),
					inStudents.nextDouble(), inStudents.nextDouble());
			try {
				outStudentsSerialized.writeObject(student);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void closeFiles() {
		try {
			inStudents.close();
			outStudentsSerialized.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void openFiles() {
		try {
			inStudents = new Scanner(Paths.get("students.txt"));
			outStudentsSerialized = new ObjectOutputStream(Files.newOutputStream(Paths.get("students.ser")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
