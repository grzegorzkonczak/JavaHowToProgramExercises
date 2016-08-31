// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

public class InstructionWrite extends InstructionIO {

	public InstructionWrite(Integer operand, Memory memory) {
		super(operand, memory);
	}

	@Override
	public void executeInstruction() {
		System.out.println(getMemory().getValueFromMemory(getOperand()));
	}

}
