// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.instructionSet;

import java.util.Formatter;

import simpletron.hardware.InstructionCounter;

public class InstructionHalt extends InstructionBranch {
	
	private Integer maxMemory;
	private Formatter output;
	
	public InstructionHalt(Integer operand, InstructionCounter instructionCounter, Integer maxMemory, Formatter output) {
		super(operand, instructionCounter);
		this.maxMemory = maxMemory;
		this.output = output;
	}
	
	@Override
	public void executeInstruction() {
		output.format("*** Simpletron execution terminated ***%n");
		getInstructionCounter().setCount(maxMemory);
	}

}
