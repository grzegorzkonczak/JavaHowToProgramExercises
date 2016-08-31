// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.hardware;

public class InstructionCounter {

	private Integer count;

	public InstructionCounter() {
		count = 0;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public void increment(){
		count++;
	}
	
}
