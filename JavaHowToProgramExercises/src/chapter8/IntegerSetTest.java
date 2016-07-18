// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.13 page 399
// Exercise from Java:How to program 10th edition

package chapter8;

public class IntegerSetTest {

	public static void main(String[] args) {
		
		IntegerSet set1 = new IntegerSet();
		System.out.println(set1);
		
		set1.insertElement(15);
		System.out.println(set1);
		
		IntegerSet set2 = new IntegerSet();
		IntegerSet set3 = IntegerSet.union(set1, set2);
		System.out.println(set3);
		
		System.out.println(set1.isEqualTo(set3));
		System.out.println(set1.isEqualTo(set2));
		
		set3 = IntegerSet.intersection(set1, set2);
		System.out.println(set3);
	}
}
