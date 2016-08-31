// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.instructionSet;

import simpletron.hardware.Accumulator;
import simpletron.hardware.Memory;

public class InstructionSubtract extends InstructionAccumulator {

	public InstructionSubtract(Integer operand, Memory memory, Accumulator accumulator) {
		super(operand, memory, accumulator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeInstruction() {
		super.subtract();
	}

}
