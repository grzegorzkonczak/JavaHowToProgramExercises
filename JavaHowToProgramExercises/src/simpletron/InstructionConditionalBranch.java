// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

public abstract class InstructionConditionalBranch extends InstructionBranch {

	private Accumulator accumulator;

	public InstructionConditionalBranch(Integer operand, InstructionCounter instructionCounter, Accumulator accumulator) {
		super(operand, instructionCounter);
		this.accumulator = accumulator;
	}
	
	public Integer getAccumulatorValue(){
		return accumulator.getValue();
	}

	public abstract void executeInstruction();
}
