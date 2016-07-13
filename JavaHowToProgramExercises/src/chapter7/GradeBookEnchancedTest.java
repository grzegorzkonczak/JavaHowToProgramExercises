// Grzegorz Koñczak, 13.07.2016
// Exercise number 7.39 page 356
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.Scanner;

public class GradeBookEnchancedTest {
	
	private static final Scanner input = new Scanner(System.in);
	
	// main method begins program execution
	public static void main(String[] args) {
		
		System.out.println("Number of students?");
		int students = input.nextInt();
		System.out.println("Number of exams?");
		int exams = input.nextInt();
		
		GradeBookEnchanced myGradeBook = new GradeBookEnchanced("CS101 Introduction to Java Programming", students, exams);
		
		for (int i = 0; i < students; i++){
			for (int j = 0; j < exams; j++){
				System.out.print("Enter grade for student " + (i+1) + " on exam " + (j+1) + ": ");
				System.out.println();
				myGradeBook.setGrade(i, j, input.nextInt());
			}
		}
		System.out.println();
		System.out.printf("Welcome to the grade book for%n%s%n%n", myGradeBook.getCourseName());
		myGradeBook.processGrades();
	}
} // end class GradeBookTest
