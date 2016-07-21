// Grzegorz Koñczak, 21.07.2016
// Exercise number 11.19 page 514
// Exercise from Java:How to program 10th edition

package chapter11;

public class SomeClassTest {

	public static void main(String[] args) {
		try {
			SomeClass some = new SomeClass();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
