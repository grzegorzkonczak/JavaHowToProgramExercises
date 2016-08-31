// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.instructionSet;

import simpletron.hardware.Accumulator;
import simpletron.hardware.InstructionCounter;

public class InstructionBranchNegative extends InstructionConditionalBranch{


	public InstructionBranchNegative(Integer operand, InstructionCounter instructionCounter, Accumulator accumulator) {
		super(operand, instructionCounter, accumulator);
	}

	@Override
	public void executeInstruction() {
		if (super.loadAccumulatorValue() < 0){
			getInstructionCounter().setCount(getOperand());
		}
	}

}
