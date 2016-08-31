// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Execute {

	private final static Scanner input = new Scanner(System.in);

	private Memory memory;
	private Accumulator accumulator;
	private InstructionCounter instructionCounter;
	private InstructionRegister instructionRegister;
	private Scanner inInstructions;

	public Execute() {
		memory = new Memory();
		accumulator = new Accumulator();
		instructionCounter = new InstructionCounter();
		instructionRegister = new InstructionRegister();
	}

	public void run() {

		
		getInstructionsFromInput();
	}

	private void getInstructionsFromInput() {
		// Open file with code
		try {
			System.out.println("Input name of file with instruction:");
			inInstructions = new Scanner(Paths.get(input.nextLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Loading program from file
		while (inInstructions.hasNext()) {
			memory.setValueInMemory(instructionCounter.getCount(), Integer.parseInt(inInstructions.nextLine()));
			instructionCounter.increment();
		}

		// Close file after loading instructions
		inInstructions.close();

	}

}
