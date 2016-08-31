// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

public class InstructionBranch extends Instruction{

	private InstructionCounter instructionCounter;
	
	public InstructionBranch(Integer operand, InstructionCounter instructionCounter) {
		super(operand);
		this.instructionCounter = instructionCounter;
	}

	
	public InstructionCounter getInstructionCounter() {
		return instructionCounter;
	}



	public void setInstructionCounter(InstructionCounter instructionCounter) {
		this.instructionCounter = instructionCounter;
	}


	@Override
	public void executeInstruction() {
		instructionCounter.setCount(getOperand());
	}



}
