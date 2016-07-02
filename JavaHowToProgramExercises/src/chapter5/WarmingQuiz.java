// Grzegorz Koñczak, 02.07.2016
// Exercise number 5.31 page 241
// Exercise from Java:How to program 10th edition

package chapter5;

import java.util.Scanner;

public class WarmingQuiz {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int correct = 0;
		int answer;
		
		for (int i = 0; i < 5; i++){
			System.out.println("Question number " + (i + 1) + ":");
			switch (i){
			case 0:
				System.out.println("Which of the following is a greenhouse gas that is released by human activities and speeds up global warming?");
				System.out.println("1. petroleum");
				System.out.println("2. natural gas");
				System.out.println("3. carbon dioxide");
				System.out.println("4. nuclear power");
				System.out.print("Enter number of your answer: ");
				answer = input.nextInt();
				if (answer == 3){
					correct++;
					System.out.println("Correct!");
				}else{
					System.out.println("Wrong :(");
				}
				System.out.println("\n");
				break;
			case 1:
				System.out.println("Which of the following human activities does NOT release carbon dioxide into the atmosphere?");
				System.out.println("1. burning fossil fuels");
				System.out.println("2. fishing");
				System.out.println("3. deforestation");
				System.out.println("4. driving");
				System.out.print("Enter number of your answer: ");
				answer = input.nextInt();
				if (answer == 2){
					correct++;
					System.out.println("Correct!");
				}else{
					System.out.println("Wrong :(");
				}
				System.out.println("\n");
				break;
			case 2:
				System.out.println("As global warming continues, the intensity of what type of storm that hits coastlines is predicted to increase?");
				System.out.println("1. tornadoes");
				System.out.println("2. hurricanes");
				System.out.println("3. tsunamis");
				System.out.println("4. earthquakes");
				System.out.print("Enter number of your answer: ");
				answer = input.nextInt();
				if (answer == 2){
					correct++;
					System.out.println("Correct!");
				}else{
					System.out.println("Wrong :(");
				}
				System.out.println("\n");
				break;
			case 3:
				System.out.println("Rising water temperatures is a result of global warming and may eventually increase sea levels due to the dissolving of what?");
				System.out.println("1. mountains");
				System.out.println("2. wetlands");
				System.out.println("3. river beds");
				System.out.println("4. glaciers");
				System.out.print("Enter number of your answer: ");
				answer = input.nextInt();
				if (answer == 4){
					correct++;
					System.out.println("Correct!");
				}else{
					System.out.println("Wrong :(");
				}
				System.out.println("\n");
				break;
			case 4:
				System.out.println("Which of the following is NOT a negative effect of global warming");
				System.out.println("1. larger fish population");
				System.out.println("2. new infectious diseases");
				System.out.println("3. species extinction");
				System.out.println("4. loss of coastal areas");
				System.out.print("Enter number of your answer: ");
				answer = input.nextInt();
				if (answer == 1){
					correct++;
					System.out.println("Correct!");
				}else{
					System.out.println("Wrong :(");
				}
				System.out.println("\n");
				break;
			}
		}
		
		if (correct > 3){
			System.out.println("Exelent!");
		}else{
			System.out.println("You should read more about global warming.");
			System.out.println("Try this site: https://en.wikipedia.org/wiki/Global_warming");
		}
		
		input.close();
	}
}
