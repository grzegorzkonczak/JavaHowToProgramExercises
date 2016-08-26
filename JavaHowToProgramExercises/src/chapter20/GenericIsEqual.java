// Grzegorz Koñczak, 26.08.2016
// Exercise number 20.7 page 910
// Exercise from Java:How to program 10th edition

package chapter20;

public class GenericIsEqual {

	public static void main(String[] args) {
		Integer int1 = 5;
		Integer int2 = 6;
		System.out.println(isEqualTo(int1, int2));
		
		Object obj1 = 1.1;
		Object obj2 = 1.1;
		System.out.println(isEqualTo(obj1, obj2));
		
		String str1 = "one";
		String str2 = "two";
		System.out.println(isEqualTo(str1, str2));
	}
	
	private static <T> boolean isEqualTo (T element1, T element2){
		if (element1.equals(element2)){
			return true;
		}
		return false;
	}
}
