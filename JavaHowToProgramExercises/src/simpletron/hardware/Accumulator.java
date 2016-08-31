// Grzegorz Koñczak, 31.08.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package simpletron.hardware;

public class Accumulator {

	private Integer value;

	public Accumulator() {
		value = 0;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
