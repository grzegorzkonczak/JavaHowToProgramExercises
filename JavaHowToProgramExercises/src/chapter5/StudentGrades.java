// Grzegorz Koñczak, 01.07.2016
// Exercise number 5.17 page 239
// Exercise from Java:How to program 10th edition

package chapter5;

import java.util.Scanner;

public class StudentGrades {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String grade;
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;

		
		for(int i = 0; i < 5; i++){
			System.out.print("Enter student grade: ");
			grade = input.nextLine();
			switch(grade){
			case "A":
				countA++;
				break;
			case "B":
				countB++;
				break;
			case "C":
				countC++;
				break;
			case "D":
				countD++;
				break;
			}
		}
		System.out.printf("Number of A: %d%nNumber of B: %d%nNumber of C: %d%nNumber of D: %d%n",
				countA, countB, countC, countD);
	}
}
