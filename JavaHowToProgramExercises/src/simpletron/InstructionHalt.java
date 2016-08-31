// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

public class InstructionHalt extends InstructionBranch {
	
	private Integer maxMemory;
	
	public InstructionHalt(Integer operand, InstructionCounter instructionCounter, Integer maxMemory) {
		super(operand, instructionCounter);
		this.maxMemory = maxMemory;
	}
	
	@Override
	public void executeInstruction() {
		System.out.println("*** Simpletron execution terminated ***");
		getInstructionCounter().setCount(maxMemory);
	}

}
