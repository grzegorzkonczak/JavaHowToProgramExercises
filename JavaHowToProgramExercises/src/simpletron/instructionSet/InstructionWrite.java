// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.instructionSet;

import java.util.Formatter;

import simpletron.hardware.Memory;

public class InstructionWrite extends InstructionIO {

	private Formatter output;
	
	public InstructionWrite(Integer operand, Memory memory, Formatter output) {
		super(operand, memory);
		this.output = output;
	}

	@Override
	public void executeInstruction() {
		output.format("%d%n", getMemory().getValueFromMemory(getOperand()));
	}

}
