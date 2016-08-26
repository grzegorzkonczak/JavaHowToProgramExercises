// Grzegorz Koñczak, 26.08.2016
// Exercise number 20.8 page 910
// Exercise from Java:How to program 10th edition

package chapter20;

public class GeneraicPair<F,S> {

	private F elementFirst;
	private S elementSecond;
	
	public GeneraicPair(F elementFirst, S elementSecond) {
		this.elementFirst = elementFirst;
		this.elementSecond = elementSecond;
	}

	public F getElementFirst() {
		return elementFirst;
	}

	public void setElementFirst(F elementFirst) {
		this.elementFirst = elementFirst;
	}

	public S getElementSecond() {
		return elementSecond;
	}

	public void setElementSecond(S elementSecond) {
		this.elementSecond = elementSecond;
	}
	
	
}
