// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.instructionSet;

public abstract class Instruction {

	private Integer operand;
	
	public Instruction (Integer operand){
		this.operand = operand;
	}
	
	
	
	public int getOperand() {
		return operand;
	}



	public void setOperand(Integer operand) {
		this.operand = operand;
	}



	public abstract void executeInstruction();
	
}
