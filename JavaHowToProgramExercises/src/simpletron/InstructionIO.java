// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

public abstract class InstructionIO extends Instruction{
	
	private Memory memory;

	public InstructionIO(Integer operand, Memory memory) {
		super(operand);
		this.memory = memory;
	}
	
	

	public Memory getMemory() {
		return memory;
	}



	public void setMemory(Memory memory) {
		this.memory = memory;
	}

}
