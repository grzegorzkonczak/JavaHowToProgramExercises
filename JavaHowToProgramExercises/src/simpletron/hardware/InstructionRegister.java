// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.hardware;

public class InstructionRegister {

	private Integer instruction;

	public InstructionRegister() {
		instruction = 0;
	}

	public void setInstruction(Integer instruction) {
		this.instruction = instruction;
	}
	
	public Integer getOperationCode(){
		return instruction / 100;
	}
	
	public Integer getOperand(){
		return instruction % 100;
	}

	public Integer getInstruction() {
		return instruction;
	}

}
