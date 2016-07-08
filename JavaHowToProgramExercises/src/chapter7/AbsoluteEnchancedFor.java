// Grzegorz Koñczak, 08.07.2016
// Exercise number 7.16 page 342
// Exercise from Java:How to program 10th edition

package chapter7;

import java.util.ArrayList;

public class AbsoluteEnchancedFor {

	public static void main(String[] args) {
		if(args.length < 3){
			System.out.println("Restart application. Provide minimum three integer arguments.");
		}else{
			ArrayList<Integer> absolute = calculateAbsolute(args);
			for(int number : absolute)
				System.out.println(number);
		}
	}

	private static ArrayList<Integer> calculateAbsolute(String[] args) {
		ArrayList<Integer> absolut = new ArrayList<>();
		for(String number : args){
			absolut.add(Math.abs(Integer.parseInt(number)));
		}
		return absolut;
	}
}
