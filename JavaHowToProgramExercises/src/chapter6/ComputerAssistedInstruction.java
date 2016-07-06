// Grzegorz Koñczak, 06.07.2016
// Exercise number 6.35/36/37/38/39 page 283/284
// Exercise from Java:How to program 10th edition

package chapter6;

import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAssistedInstruction {

	private static final SecureRandom random = new SecureRandom();

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Want to take a test? (1 - yes, 0 - no)"); // Asking user if he wants to start testing
		int flag = input.nextInt();
		
		while(flag != 0){ // loop for whole test for one user
			
			System.out.println("Choose difficulty level: "); // Setting difficulty of questions
			int difficulty = input.nextInt();
			System.out.println("Choose mode (1 - addition, 2 - subtraction, 3 - multiplication, 4 - division, 5 - mix):"); // Setting mode of test
			int mode = input.nextInt();
			int goodAnswers = 0;
			int correctAnswer = 0;
			int userAnswer = 0;
	
			// Loop for 10 question test
			for (int i = 0; i < 10; i++) {
				correctAnswer = generateQuestion(difficulty, mode); // Generating question and storing correct answer in int variable
				userAnswer = input.nextInt();
				if (userAnswer != correctAnswer) {
					badResponse();
				}else{
					goodResponse();
					goodAnswers++;
				}
			}
			
			// Feedback about test performance
			System.out.println("Correct answers: " + goodAnswers);
			if(goodAnswers >= 8){
				System.out.println("Congratulations, Your ready for next level!");
			}else{
				System.out.println("Please ask your teacher for extra help.");
			}
			
			// Setting up next test for another user
			System.out.println("Want to take a test? (1 - yes, 0 - no)"); // Asking user if he wants to start testing
			flag = input.nextInt();
		}
		
		input.close();
	}

	// Generates new question and returns correct answer
	// Takes into account difficulty provided by user
	// Takes into account mode provided by user
	private static int generateQuestion(int difficulty, int mode) {
		int number1 = random.nextInt((int)Math.pow(10, difficulty));
		int number2 = random.nextInt((int)Math.pow(10, difficulty));
		int answer = 0;
		
		switch(mode){
		case 1: // Addition only
			System.out.println("How much is " + number1 + " plus " + number2 + "?");
			answer = number1 + number2;
			return answer;
		case 2: // Subtraction only
			System.out.println("How much is " + number1 + " minus " + number2 + "?");
			answer = number1 - number2;
			return answer;
		case 3: // Multiplication only
			System.out.println("How much is " + number1 + " times " + number2 + "?");
			answer = number1 * number2;
			return answer;
		case 4: // Division only
			while(number2 == 0){ // Avoiding division by 0
				number2 = random.nextInt((int)Math.pow(10, difficulty));
			}
			System.out.println("How much is " + number1 + " divided by " + number2 + "?");
			answer = number1 / number2;
			return answer;
		default: // Random arithmetic problem
			int randomAction = random.nextInt(4);
			switch(randomAction){
			case 0:
				System.out.println("How much is " + number1 + " plus " + number2 + "?");
				answer = number1 + number2;
				return answer;
			case 1:
				System.out.println("How much is " + number1 + " minus " + number2 + "?");
				answer = number1 - number2;
				return answer;
			case 2:
				System.out.println("How much is " + number1 + " times " + number2 + "?");
				answer = number1 * number2;
				return answer;
			default:
				while(number2 == 0){ // Avoiding division by 0
					number2 = random.nextInt((int)Math.pow(10, difficulty));
				}
				System.out.println("How much is " + number1 + " divided by " + number2 + "?");
				answer = number1 / number2;
				return answer;
			}
		}
		
	}
	
	// Generates positive response for correct answers
	private static void goodResponse(){
		int response = random.nextInt(4);
		switch(response){
		case 0:
			System.out.println("Exelent!");
			break;
		case 1:
			System.out.println("Great!");
			break;
		case 2:
			System.out.println("Nice Job!");
			break;
		case 3:
			System.out.println("Yes, that's correct!");
			break;
		}
	}
	
	// Generates negative response for wrong answers
	private static void badResponse(){
		int response = random.nextInt(4);
		switch(response){
		case 0:
			System.out.println("No, try again.");
			break;
		case 1:
			System.out.println("Wrong.");
			break;
		case 2:
			System.out.println("Try again.");
			break;
		case 3:
			System.out.println("No. Keep trying.");
			break;
		}
	}
}
