// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.instructionSet;

import simpletron.hardware.Accumulator;
import simpletron.hardware.Memory;

public class InstructionMultiply extends InstructionAccumulator {

	public InstructionMultiply(Integer operand, Memory memory, Accumulator accumulator) {
		super(operand, memory, accumulator);
	}

	@Override
	public void executeInstruction() {
		super.multiply();
	}

}
