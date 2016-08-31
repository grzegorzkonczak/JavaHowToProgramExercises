// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron;

public class Memory {

	private final Integer MAX_MEMORY = 100;
	private Integer[] values;

	public Memory() {
		for (int i = 0; i < MAX_MEMORY; i++) {
			values[i] = 0;
		}
	}
	
	public void setValueInMemory(Integer index, Integer value){
		values[index] = value;
	}
	
	public Integer getValueFromMemory(Integer index) {
		return values[index];
	}

	public Integer getMAX_MEMORY() {
		return MAX_MEMORY;
	}
	
	
}
