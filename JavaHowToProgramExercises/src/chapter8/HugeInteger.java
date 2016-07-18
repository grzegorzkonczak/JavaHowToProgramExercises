// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.16 page 400
// Exercise from Java:How to program 10th edition

package chapter8;

public class HugeInteger {

	// Holds integer up to 40 digits
	private int[] components = new int[40];

	public int getComponent(int component) {
		return components[component];
	}

	public void setComponents(int component, int value) {
		this.components[component] = value;
	}

	// Parses String to array of up to 40 digits
	public void parse(String toParse) {
		for (int i = 0; i < toParse.length(); i++) {
			components[39 - i] = Character.getNumericValue(toParse.charAt(toParse.length() - (i + 1)));
		}
	}

	// Prints integer as String
	public String toString() {
		StringBuffer string = new StringBuffer();
		for (int i = 0; i < components.length; i++) {
			if (components[i] != 0) {
				for (int j = i; j < components.length; j++) {
					string.append(components[j]);
				}
				return string.toString();
			}
		}
		return "0";
	}

	// Adds two Huge Integer numbers (adding with carry)
	public HugeInteger add(HugeInteger number) {
		HugeInteger sum = new HugeInteger();
		int carry = 0;
		for (int i = components.length - 1; i >= 0; i--) {
			int sumDigits = (components[i] + number.getComponent(i) + carry) % 10;
			if (components[i] + number.getComponent(i) + carry > 9)
				carry = 1;
			else
				carry = 0;
			sum.setComponents(i, sumDigits);
		}
		return sum;
	}

	// Subtracts two integer numbers (subtracting with borrow)
	public HugeInteger subtract(HugeInteger number) {
		HugeInteger result = new HugeInteger();
		for (int i = components.length - 1; i >= 0; i--) {
			int difDigits = 0;
			if (components[i] >= number.getComponent(i))
				difDigits = components[i] - number.getComponent(i);
			else {
				for (int j = i - 1; j >= 0; j--){
					if (j != 0){
						components[j]--;
						break;
					}
				}
				difDigits = (components[i] + 10) - number.getComponent(i);
			}
			result.setComponents(i, difDigits);
		}
		return result;
	}

	// Set of predicate methods for comparing Huge Integer numbers
	public boolean isEqualTo(HugeInteger number){
		for (int i = components.length - 1; i >= 0; i--) {
			if (components[i] != number.getComponent(i))
				return false;
		}
		return true;
	}

	public boolean isNotEqualTo(HugeInteger number){
		for (int i = components.length - 1; i >= 0; i--){
			if (components[i] != number.getComponent(i))
				return true;
		}
		return false;
	}
	
	public boolean isGraterThen(HugeInteger number){
		for (int i = 0; i < components.length; i++){
			if (components[i] != number.getComponent(i)){
				if (components[i] > number.getComponent(i))
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	public boolean isLessThen(HugeInteger number){
		for (int i = 0; i < components.length; i++){
			if (components[i] != number.getComponent(i)){
				if (components[i] < number.getComponent(i))
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	public boolean isGraterThenOrEqual(HugeInteger number){
		for (int i = 0; i < components.length; i++){
			if (components[i] != number.getComponent(i)){
				if (components[i] > number.getComponent(i))
					return true;
				else
					return false;
			}
		}
		return true;
	}
	
	public boolean isLessThenOrEqual(HugeInteger number){
		for (int i = 0; i < components.length; i++){
			if (components[i] != number.getComponent(i)){
				if (components[i] < number.getComponent(i))
					return true;
				else
					return false;
			}
		}
		return true;
	}
	
	public boolean isZero(){
		for (int i = components.length - 1; i >= 0; i--){
			if (components[i] != 0)
				return false;
		}
		return true;
	}
}
