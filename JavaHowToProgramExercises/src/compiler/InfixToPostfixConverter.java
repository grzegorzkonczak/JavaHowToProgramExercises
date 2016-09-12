// Grzegorz Koñczak, 01.09.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package compiler;

import com.deitel.datastructures.Stack;

public class InfixToPostfixConverter {

	
	public static String convert (String data){
		String inputString = data;
		StringBuffer infix = new StringBuffer();
		for (int i = 0; i < inputString.length(); i++) {
			if (!Character.isWhitespace(inputString.charAt(i))) {
				infix.append(inputString.charAt(i));
			}
		}
		String postfix = convertToPostfix(infix);
		return postfix;
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
			} else if (Character.isLetter(current)) {
				postfix.append(current);
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
