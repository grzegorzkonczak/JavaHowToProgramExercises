// Grzegorz Koñczak, 13.07.2016
// Exercise number 7.38 page 355
// Exercise from Java:How to program 10th edition


package chapter7;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ComputerSimulatorEnchanced {

	private static final Scanner input = new Scanner(System.in);
	private static Scanner inInstructions;

	public static void main(String[] args) {

		// Welcome message
		System.out.println("*** Welcome to Simpletron! ***");
		System.out.println("*** Please enter your program one instruction    ***");
		System.out.println("*** (or data word) at a time. I will display     ***");
		System.out.println("*** the location number and a question mark (?). ***");
		System.out.println("*** You then type the word for that location.    ***");
		System.out.println("*** Type -FFFF to stop entering your program.   ***");
		System.out.println();

		// Initializing variables
		double[] memory = new double[1000];
		int instructionCounter = 0;
		
		// Open file with code
		try {
			System.out.println("Input name of file with instruction:");
			inInstructions = new Scanner(Paths.get(input.nextLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Loading program from file
		while (inInstructions.hasNext()) {
			memory[instructionCounter] = Double.parseDouble(inInstructions.nextLine());
			instructionCounter++;
		}
		
		// Close file after loading instructions
		inInstructions.close();

		// Information about starting the provided program
		System.out.println();
		System.out.println("*** Program loading completed  ***");
		System.out.println("*** Program execution begins   ***");

		// Initializing special registers
		double accumulator = 0;
		int operationCode = 0;
		int operand = 0;
		int instructionRegister = 0;

		// Reseting instruction Counter
		instructionCounter = 0;

		// Begin execution of program
		while (instructionCounter < 1000) {

			// Fetch instruction from memory
			instructionRegister = (int) memory[instructionCounter];
			// Pick-off operand and opcode from instruction register
			operationCode = instructionRegister / 255;
			operand = instructionRegister % 256;

			// increment instruction counter
			instructionCounter++;

			// Determine which instruction to execute
			switch (operationCode) {
			// READ
			case 10:
				System.out.println("Enter number");
				memory[operand] = input.nextDouble();
				break;
			// WRITE
			case 11:
				System.out.println(memory[operand]);
				break;
			// READSTRING
			case 12:
				System.out.println("Enter String");
				char[] letters = input.nextLine().toCharArray();
				if (letters[0] >= 100){
					letters[0] = (char) (letters[0] - 100);
				}
				memory[operand] = letters.length * 100 + letters[0];
				int lettersCounter = 1;
				for (int i = 1; i <= letters.length / 2; i++) {
					if (lettersCounter + 1 < letters.length) {
						if (letters[lettersCounter] >= 100){
							letters[lettersCounter] = (char) (letters[lettersCounter] - 100);
						}
						if (letters[lettersCounter + 1] >= 100){
							letters[lettersCounter + 1] = (char) (letters[lettersCounter + 1] - 100);
						}
						memory[operand + i] = letters[lettersCounter] * 100 + letters[lettersCounter + 1];
						lettersCounter += 2;
					} else {
						if (letters[lettersCounter] >= 100){
							letters[lettersCounter] = (char) (letters[lettersCounter] - 100);
						}
						memory[operand + i] = letters[lettersCounter] * 100;
					}
				}
				break;
			// LOAD
			case 20:
				accumulator = memory[operand];
				break;
			// STORE
			case 21:
				memory[operand] = accumulator;
				break;
			// ADD
			case 30:
				accumulator += memory[operand];
				break;
			// SUBTRACT
			case 31:
				accumulator -= memory[operand];
				break;
			// DIVIDE
			case 32:
				accumulator /= memory[operand];
				break;
			// MULTIPLY
			case 33:
				accumulator *= memory[operand];
				break;
			// REMAINDER
			case 34:
				accumulator %= memory[operand];
				break;
			// EXPONENTIATION
			case 35:
				accumulator = Math.pow(accumulator, memory[operand]);
				// BRANCH
			case 40:
				instructionCounter = operand;
				break;
			// BRANCHNEG
			case 41:
				if (accumulator < 0)
					instructionCounter = operand;
				break;
			// BRANCHZERO
			case 42:
				if (accumulator == 0)
					instructionCounter = operand;
				break;
			// HALT
			case 43:
				System.out.println("*** Simpletron execution terminated ***");
				instructionCounter = 1000;
				break;
			// NEWLINE
			case 50:
				System.out.println();
				break;
			// PRINTSTRING
			case 51:
				int length = (int) (memory[operand] / 100);
				char char1 = 0;
				if (memory[operand] % 100 < 30){
					char1 = (char) ((int)memory[operand] % 100 + 100);
				}else {
					char1 = (char) ((int)memory[operand] % 100);
				}
				char char2 = 0;
				System.out.print(char1);
				for (int i = 1; i <= length / 2; i++) {
					if (i < length / 2 || length % 2 != 0){
						if (memory[operand + i] / 100 < 30){
							char1 = (char) ((int)memory[operand + i] / 100 + 100);
						} else {
							char1 = (char) ((int)memory[operand + i] / 100);
						}
						System.out.print(char1);
						if (memory[operand + i] % 100 < 30){
							char2 = (char) ((int)memory[operand + i] % 100 + 100);
						} else {
							char2 = (char) ((int)memory[operand + i] % 100);
						}
						System.out.print(char2);
					} else {
						if (memory[operand + i] / 100 < 30){
							char1 = (char) ((int)memory[operand + i] / 100 + 100);
						} else {
							char1 = (char) ((int)memory[operand + i] / 100);
						}
						System.out.print(char1);
					}
				}
				break;
			}
		}

		// Display dump
		System.out.println();
		System.out.printf("%-21s%n", "REGISTERS:");
		System.out.printf("%-21s%+05.1f%n", "accumulator", accumulator);
		System.out.printf("%-21s %02d%n", "instructionCounter", instructionCounter);
		System.out.printf("%-21s%05x%n", "instructionRegister", instructionRegister);
		System.out.printf("%-21s   %02d%n", "operactionCode", operationCode);
		System.out.printf("%-21s   %02d%n", "operand", operand);

		System.out.println();

		System.out.println("MEMORY:");
		System.out.print("    ");
		System.out.printf("%5s%6s%6s%6s%6s%6s%6s%6s%6s%6s%n", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			System.out.printf("%-4d", i * 10);
			for (int j = 0; j < 10; j++) {
				System.out.printf("%05x ", (int) memory[counter]);
				counter++;
			}
			System.out.println();
		}
	}
}
