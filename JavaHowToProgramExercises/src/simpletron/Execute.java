// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

import simpletron.hardware.Accumulator;
import simpletron.hardware.InstructionCounter;
import simpletron.hardware.InstructionRegister;
import simpletron.hardware.Memory;
import simpletron.instructionSet.Instruction;
import simpletron.instructionSet.InstructionAdd;
import simpletron.instructionSet.InstructionBranch;
import simpletron.instructionSet.InstructionBranchNegative;
import simpletron.instructionSet.InstructionBranchZero;
import simpletron.instructionSet.InstructionDivide;
import simpletron.instructionSet.InstructionHalt;
import simpletron.instructionSet.InstructionLoad;
import simpletron.instructionSet.InstructionMultiply;
import simpletron.instructionSet.InstructionRead;
import simpletron.instructionSet.InstructionStore;
import simpletron.instructionSet.InstructionSubtract;
import simpletron.instructionSet.InstructionWrite;

public class Execute {

	private final static Scanner input = new Scanner(System.in);

	private Memory memory;
	private Accumulator accumulator;
	private InstructionCounter instructionCounter;
	private InstructionRegister instructionRegister;
	private Scanner inInstructions;
	private Formatter output;
	private HashMap<Integer, Instruction> instructionMap;

	public Execute() {
		memory = new Memory();
		accumulator = new Accumulator();
		instructionCounter = new InstructionCounter();
		instructionRegister = new InstructionRegister();
	}

	public void run() {
		openOutputFile();
		populateInstructionMap();
		outputWelcomeMessage();
		loadInstructionsToMemory();
		outputLoadingFinishedIndicator();
		executeInstructionsFromMemory();
		outputDump();
		closeOutputFile();
	}

	private void outputDump() {
		// output dump to file
		output.format("%n");
		output.format("%-21s%n", "REGISTERS:");
		output.format("%-21s%+05d%n", "accumulator", accumulator.getValue());
		output.format("%-21s  %02d%n", "instructionCounter", instructionCounter.getCount());
		output.format("%-21s%+05d%n", "instructionRegister", instructionRegister.getInstruction());
		output.format("%-21s   %02d%n", "operactionCode", instructionRegister.getOperationCode());
		output.format("%-21s   %02d%n", "operand", instructionRegister.getOperand());

		output.format("%n");

		output.format("MEMORY:%n");
		output.format("    ");
		output.format("%5s%6s%6s%6s%6s%6s%6s%6s%6s%6s%n", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			output.format("%-4d", i * 10);
			for (int j = 0; j < 10; j++) {
				output.format("%+05d ", memory.getValueFromMemory(counter));
				counter++;
			}
			output.format("%n");
		}

	}

	private void populateInstructionMap() {
		instructionMap = new HashMap<>();
		instructionMap.put(10, new InstructionRead(0, memory));
		instructionMap.put(11, new InstructionWrite(0, memory, output));
		instructionMap.put(20, new InstructionLoad(0, memory, accumulator));
		instructionMap.put(21, new InstructionStore(0, memory, accumulator));
		instructionMap.put(30, new InstructionAdd(0, memory, accumulator));
		instructionMap.put(31, new InstructionSubtract(0, memory, accumulator));
		instructionMap.put(32, new InstructionDivide(0, memory, accumulator));
		instructionMap.put(33, new InstructionMultiply(0, memory, accumulator));
		instructionMap.put(40, new InstructionBranch(0, instructionCounter));
		instructionMap.put(41, new InstructionBranchNegative(0, instructionCounter, accumulator));
		instructionMap.put(42, new InstructionBranchZero(0, instructionCounter, accumulator));
		instructionMap.put(43, new InstructionHalt(0, instructionCounter, memory.getMAX_MEMORY(), output));
	}

	// Load instruction from memory and execute polymorphically
	private void executeInstructionsFromMemory() {
		Instruction instruction;
		while (instructionCounter.getCount() < memory.getMAX_MEMORY()) {
			instructionRegister.setInstruction(memory.getValueFromMemory(instructionCounter.getCount()));
			instructionCounter.increment();
			instruction = instructionMap.get(instructionRegister.getOperationCode());
			instruction.setOperand(instructionRegister.getOperand());
			instruction.executeInstruction();
		}

	}

	private void outputLoadingFinishedIndicator() {
		output.format("%s%n", "*** Program loading completed  ***");
		output.format("%s%n", "*** Program execution begins   ***");
	}

	private void outputWelcomeMessage() {
		// Welcome message
		output.format("%s%n", "*** Welcome to Simpletron! ***");
		output.format("%s%n", "*** Your program was entered from file you    ***");
		output.format("%s%n", "*** specified and executed. Whole output from     ***");
		output.format("%s%n", "*** execution with the dump of all simulated ***");
		output.format("%s%n", "*** hardwere parts was stored in seperate file    ***");
		output.format("%n");
	}

	private void closeOutputFile() {
		output.close();
	}

	private void openOutputFile() {
		try {
			output = new Formatter("output.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Wrong output file location!");
			e.printStackTrace();
		}
	}

	private void loadInstructionsToMemory() {
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

		// Set instruction counter back to zero before program execution begins
		instructionCounter.setCount(0);
	}

}
