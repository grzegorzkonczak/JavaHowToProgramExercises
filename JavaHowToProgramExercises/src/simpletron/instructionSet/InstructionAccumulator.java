// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.instructionSet;

import simpletron.hardware.Accumulator;
import simpletron.hardware.Memory;

public abstract class InstructionAccumulator extends Instruction{

	private Memory memory;
	private Accumulator accumulator;
	
	public InstructionAccumulator(Integer operand, Memory memory, Accumulator accumulator) {
		super(operand);
		this.memory = memory;
		this.accumulator = accumulator;
	}
	
	public void loadToAccumulator(){
		accumulator.setValue(memory.getValueFromMemory(getOperand()));
	}


	public void loadValueToMemory(){
		memory.setValueInMemory(getOperand(), accumulator.getValue());
	}
	
	public void add(){
		accumulator.setValue(accumulator.getValue() + memory.getValueFromMemory(getOperand()));
	}
	
	public void subtract(){
		accumulator.setValue(accumulator.getValue() - memory.getValueFromMemory(getOperand()));
	}
	
	public void multiply(){
		accumulator.setValue(accumulator.getValue() * memory.getValueFromMemory(getOperand()));
	}
	
	public void divide(){
		accumulator.setValue(accumulator.getValue() / memory.getValueFromMemory(getOperand()));
	}
}
