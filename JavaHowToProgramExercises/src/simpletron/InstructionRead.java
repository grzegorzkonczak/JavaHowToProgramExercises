// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

import java.util.Scanner;

public class InstructionRead extends InstructionIO{

	private static final Scanner input = new Scanner(System.in);
	
	public InstructionRead(Integer operand, Memory memory) {
		super(operand, memory);
	}


	@Override
	public void executeInstruction() {
		System.out.println("Enter an integer");
		getMemory().setValueInMemory(getOperand(), input.nextInt());
	}

}
