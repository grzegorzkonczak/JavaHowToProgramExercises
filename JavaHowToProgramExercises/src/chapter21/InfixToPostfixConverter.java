// Grzegorz Koñczak, 29.08.2016
// Exercise number 21.12 page 947
// Exercise from Java:How to program 10th edition

package chapter21;

import java.util.Scanner;

import com.deitel.datastructures.Stack;

public class InfixToPostfixConverter {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter expression to convert:");
		String inputString = input.nextLine();
		StringBuffer infix = new StringBuffer();
		for (int i = 0; i < inputString.length(); i++) {
			if (!Character.isWhitespace(inputString.charAt(i))) {
				infix.append(inputString.charAt(i));
			}
		}
		String postfix = convertToPostfix(infix);
		System.out.println(postfix);

	}

	private static String convertToPostfix(StringBuffer infix) {
		StringBuffer postfix = new StringBuffer();
		Stack<Character> stack = new Stack<>();
		stack.push('(');
		infix.append(')');
		while (!stack.isEmpty()) {
			char current = infix.charAt(0);
			if (Character.isDigit(current)) {
				if (infix.length() != 1 && !Character.isDigit(infix.charAt(1))) {
					postfix.append(current + " ");
				} else {
					postfix.append(current);
				}
			} else if (current == '(') {
				stack.push(current);
			} else if (isOperator(current)) {
				while (isOperator(stack.peek()) && precedence(current, stack.peek())) {
					postfix.append(stack.pop() + " ");
				}
				stack.push(current);
			} else if (current == ')') {
				while (stack.peek() != '(') {
					postfix.append(stack.pop() + " ");
				}
				stack.pop();
			}
			infix.delete(0, 1);
		}
		return postfix.toString();
	}

	private static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%') {
			return true;
		} else {
			return false;
		}
	}

	private static boolean precedence(char operator1, char operator2) {
		int operatorNumericValue1 = convertToNumeric(operator1);
		int operatorNumericValue2 = convertToNumeric(operator2);
		if (operatorNumericValue1 < operatorNumericValue2) {
			return true;
		} else {
			return false;
		}
	}

	private static int convertToNumeric(char operator) {
		if (operator == '^') {
			return 3;
		} else if (operator == '*' || operator == '/' || operator == '%') {
			return 2;
		} else {
			return 1;
		}
	}
}
