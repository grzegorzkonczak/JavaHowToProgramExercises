// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.13 page 399
// Exercise from Java:How to program 10th edition

package chapter8;

public class IntegerSet {

	boolean[] setElement = new boolean[101];
	
	
	// Constructor with no arguments sets all elements of set to false
	/*
	public IntegerSet(){
		for (int i = 0; i < 101; i++){
			setElement[i] = false;
		}
	}
	*/

	public boolean getSetElement(int element) {
		return setElement[element];
	}

	public void setSetElement(boolean setElement, int place) {
		this.setElement[place] = setElement;
	}

	
	// Returns union of two integer sets
	public static IntegerSet union(IntegerSet set1, IntegerSet set2) {
		IntegerSet union = new IntegerSet();
		for (int i = 0; i < 101; i++) {
			if (set1.getSetElement(i) == true || set2.getSetElement(i) == true) {
				union.setSetElement(true, i);
			}
		}
		return union;
	}

	// Returns intersection of two integer sets
	public static IntegerSet intersection(IntegerSet set1, IntegerSet set2) {
		IntegerSet intersection = new IntegerSet();
		for (int i = 0; i < 101; i++) {
			if (set1.getSetElement(i) == true && set2.getSetElement(i) == true) {
				intersection.setSetElement(true, i);
			}
		}
		return intersection;
	}

	// insert integer to set
	public void insertElement(int element) {
		setElement[element] = true;
	}

	// delete integer from set
	public void deleteElement(int element) {
		setElement[element] = false;
	}

	// Returns integer set as list of numbers in set separated by space.
	// Returns --- for empty set
	public String toString() {
		StringBuffer string = new StringBuffer();
		for (int i = 0; i < 101; i++) {
			if (setElement[i] == true) {
				string.append(i);
				string.append(" ");
			}
		}
		if (string.length() != 0) {
			return string.toString();
		} else
			return "---";
	}

	
	// Checks if two sets are alike
	public boolean isEqualTo(IntegerSet set1) {
		for (int i = 0; i < 101; i++) {
			if (set1.getSetElement(i) != this.getSetElement(i))
				return false;
		}
		return true;
	}
}
