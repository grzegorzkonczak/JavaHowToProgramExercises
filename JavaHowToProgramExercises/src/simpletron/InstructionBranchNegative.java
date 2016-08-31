// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

public class InstructionBranchNegative extends InstructionConditionalBranch{


	public InstructionBranchNegative(Integer operand, InstructionCounter instructionCounter, Accumulator accumulator) {
		super(operand, instructionCounter, accumulator);
	}

	@Override
	public void executeInstruction() {
		if (super.getAccumulatorValue() < 0){
			getInstructionCounter().setCount(getOperand());
		}
	}

}
