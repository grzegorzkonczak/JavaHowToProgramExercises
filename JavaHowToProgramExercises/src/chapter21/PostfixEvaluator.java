// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.13/14 page 948
// Exercise from Java:How to program 10th edition

package chapter21;

import java.util.Scanner;

import com.deitel.datastructures.List;
import com.deitel.datastructures.Stack;

public class PostfixEvaluator {

	private static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter expression to evaluate:");
		StringBuffer postfixExpression = new StringBuffer(input.nextLine());
		int result = evaluatePostfixExpression(postfixExpression);
		System.out.println("Result is: " + result);
	}

	private static int evaluatePostfixExpression(StringBuffer postfixExpression) {
		Stack<Integer> stack = new Stack<>();
		postfixExpression.append(')');
		while (postfixExpression.charAt(0) != ')'){
			char current = postfixExpression.charAt(0);
			if (Character.isDigit(current)){
				List<Integer> digits = new List<>();
				digits.insertAtFront(current - '0');
				int number = 0;
				int digitCounter = 0;
				while (Character.isDigit(postfixExpression.charAt(digitCounter + 1))){
					digits.insertAtFront(postfixExpression.charAt(digitCounter + 1) - '0');
					digitCounter++;
				}
				for (int i = 0; i < digitCounter + 1; i++) {
					number += digits.removeFromFront() * (int)(Math.pow(10, i));
				}
				stack.push(number);
				postfixExpression.delete(0, digitCounter + 1);
			} else if (!Character.isWhitespace(current)){
				stack.push(calculate(stack.pop(), stack.pop(), current));
				postfixExpression.delete(0, 1);
			} else {
				postfixExpression.delete(0, 1);
			}
		}
		return stack.pop();
	}
	
	private static int calculate(int argument1, int argument2, char operator){
		if (operator == '+'){
			return argument1 + argument2;
		} else if (operator == '-'){
			return argument2 - argument1;
		} else if (operator == '*'){
			return argument1 * argument2;
		} else if (operator == '/'){
			return argument2 / argument1;
		} else if (operator == '%'){
			return argument1 % argument2;
		} else {
			return (int) Math.pow(argument1, argument2);
		}
	}
}
