// Grzegorz Koñczak, 01.09.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package compiler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.text.StyleContext.SmallAttributeSet;

import com.deitel.datastructures.Stack;

import simpletron.Execute;

public class Compiler {

	private final static Scanner input = new Scanner(System.in);

	private Scanner inProgram;
	private List<String> programInMemory;
	private Integer instructionCounter;
	private Integer dataCounter;
	private Integer[] smlArray;
	private Integer[] flags;
	private SymbolTable table;
	private Formatter output;

	public Compiler() {
		programInMemory = new ArrayList<>();
		instructionCounter = 0;
		dataCounter = 99;
		smlArray = new Integer[100];
		for (int i = 0; i < smlArray.length; i++) {
			smlArray[i] = 0000;
		}
		flags = new Integer[100];
		for (int i = 0; i < flags.length; i++) {
			flags[i] = -1;
		}
		table = new SymbolTable();
	}

	public void run() {
		readProgramFromFile();
		convertToSMLCode();
		outputConvertedCodeToFile();
		loadConvertedFileToSimpletron();
		//table.print();
	}

	private void outputConvertedCodeToFile() {
		try {
			output = new Formatter("SmlProgram.txt");
		} catch (FileNotFoundException e) {
			System.err.println("Wrong output file location!");
			e.printStackTrace();
		}

		for (Integer instruction : smlArray) {
			output.format("%04d%n", instruction);
		}

		output.close();
	}

	private void convertToSMLCode() {
		performFirstPass();
		performSecondPass();
	}

	private void performSecondPass() {
		for (int i = 0; i < flags.length; i++) {
			if (flags[i] != -1) {
				smlArray[i] += table.getLocation(flags[i]);
			}
		}

	}

	private void performFirstPass() {

		for (String string : programInMemory) {
			StringTokenizer tokenizer = new StringTokenizer(string);
			List<String> tokens = new ArrayList<>();
			while (tokenizer.hasMoreTokens()) {
				tokens.add(tokenizer.nextToken());
			}
			switch (tokens.get(1)) {
			case "rem":
				if (!table.isSymbolInTable(Integer.parseInt(tokens.get(0)))) {
					table.insertTableEntry(Integer.parseInt(tokens.get(0)), 'L', instructionCounter);
				}
				break;
			case "input":
				if (!table.isSymbolInTable(Integer.parseInt(tokens.get(0)))) {
					table.insertTableEntry(Integer.parseInt(tokens.get(0)), 'L', instructionCounter);
				}
				if (!table.isSymbolInTable((int) (tokens.get(2).charAt(0)))) {
					table.insertTableEntry((int) tokens.get(2).charAt(0), 'V', dataCounter);
					smlArray[instructionCounter] = 1000 + dataCounter;
					dataCounter--;
					instructionCounter++;
				}
				break;
			case "if":
				if (!table.isSymbolInTable(Integer.parseInt(tokens.get(0)))) {
					table.insertTableEntry(Integer.parseInt(tokens.get(0)), 'L', instructionCounter);
				}
				if (Character.isDigit(tokens.get(2).charAt(0))) {
					if (!table.isSymbolInTable(Integer.parseInt(tokens.get(2)))) {
						table.insertTableEntry(Integer.parseInt(tokens.get(2)), 'C', dataCounter);
						smlArray[dataCounter--] = Integer.parseInt(tokens.get(2));
					}
				} else {
					if (!table.isSymbolInTable((int) (tokens.get(2).charAt(0)))) {
						table.insertTableEntry((int) tokens.get(2).charAt(0), 'V', dataCounter--);
					}
				}
				if (Character.isDigit(tokens.get(4).charAt(0))) {
					if (!table.isSymbolInTable(Integer.parseInt(tokens.get(4)))) {
						table.insertTableEntry(Integer.parseInt(tokens.get(4)), 'C', dataCounter);
						smlArray[dataCounter--] = Integer.parseInt(tokens.get(4));
					}
				} else {
					if (!table.isSymbolInTable((int) (tokens.get(4).charAt(0)))) {
						table.insertTableEntry((int) tokens.get(4).charAt(0), 'V', dataCounter--);
					}
				}
				if (tokens.get(3).equals("==")) {
					if (Character.isDigit(tokens.get(2).charAt(0))) {
						smlArray[instructionCounter++] = 2000 + table.getLocation(Integer.parseInt(tokens.get(2)));
					} else {
						smlArray[instructionCounter++] = 2000 + table.getLocation((int) tokens.get(2).charAt(0));
					}
					if (Character.isDigit(tokens.get(4).charAt(0))) {
						smlArray[instructionCounter++] = 3100 + table.getLocation(Integer.parseInt(tokens.get(4)));
					} else {
						smlArray[instructionCounter++] = 3100 + table.getLocation((int) tokens.get(4).charAt(0));
					}
					Integer branchLocation = table.searchSymbol(Integer.parseInt(tokens.get(6)));
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4200;
					} else {
						smlArray[instructionCounter++] = 4200 + branchLocation;
					}
				} else if (tokens.get(3).equals("<")) {
					if (Character.isDigit(tokens.get(2).charAt(0))) {
						smlArray[instructionCounter++] = 2000 + table.getLocation(Integer.parseInt(tokens.get(2)));
					} else {
						smlArray[instructionCounter++] = 2000 + table.getLocation((int) tokens.get(2).charAt(0));
					}
					if (Character.isDigit(tokens.get(4).charAt(0))) {
						smlArray[instructionCounter++] = 3100 + table.getLocation(Integer.parseInt(tokens.get(4)));
					} else {
						smlArray[instructionCounter++] = 3100 + table.getLocation((int) tokens.get(4).charAt(0));
					}
					Integer branchLocation = table.searchSymbol(Integer.parseInt(tokens.get(6)));
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4100;
					} else {
						smlArray[instructionCounter++] = 4100 + branchLocation;
					}
				} else if (tokens.get(3).equals(">")) {
					if (Character.isDigit(tokens.get(4).charAt(0))) {
						smlArray[instructionCounter++] = 2000 + table.getLocation(Integer.parseInt(tokens.get(4)));
					} else {
						smlArray[instructionCounter++] = 2000 + table.getLocation((int) tokens.get(4).charAt(0));
					}
					if (Character.isDigit(tokens.get(2).charAt(0))) {
						smlArray[instructionCounter++] = 3100 + table.getLocation(Integer.parseInt(tokens.get(2)));
					} else {
						smlArray[instructionCounter++] = 3100 + table.getLocation((int) tokens.get(2).charAt(0));
					}
					Integer branchLocation = table.searchSymbol(Integer.parseInt(tokens.get(6)));
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4100;
					} else {
						smlArray[instructionCounter++] = 4100 + branchLocation;
					}
				} else if (tokens.get(3).equals("<=")) {
					if (Character.isDigit(tokens.get(2).charAt(0))) {
						smlArray[instructionCounter++] = 2000 + table.getLocation(Integer.parseInt(tokens.get(2)));
					} else {
						smlArray[instructionCounter++] = 2000 + table.getLocation((int) tokens.get(2).charAt(0));
					}
					if (Character.isDigit(tokens.get(4).charAt(0))) {
						smlArray[instructionCounter++] = 3100 + table.getLocation(Integer.parseInt(tokens.get(4)));
					} else {
						smlArray[instructionCounter++] = 3100 + table.getLocation((int) tokens.get(4).charAt(0));
					}
					Integer branchLocation = table.searchSymbol(Integer.parseInt(tokens.get(6)));
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4100;
					} else {
						smlArray[instructionCounter++] = 4100 + branchLocation;
					}
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4200;
					} else {
						smlArray[instructionCounter++] = 4200 + branchLocation;
					}
				} else if (tokens.get(3).equals(">=")) {
					if (Character.isDigit(tokens.get(4).charAt(0))) {
						smlArray[instructionCounter++] = 2000 + table.getLocation(Integer.parseInt(tokens.get(4)));
					} else {
						smlArray[instructionCounter++] = 2000 + table.getLocation((int) tokens.get(4).charAt(0));
					}
					if (Character.isDigit(tokens.get(2).charAt(0))) {
						smlArray[instructionCounter++] = 3100 + table.getLocation(Integer.parseInt(tokens.get(2)));
					} else {
						smlArray[instructionCounter++] = 3100 + table.getLocation((int) tokens.get(2).charAt(0));
					}
					Integer branchLocation = table.searchSymbol(Integer.parseInt(tokens.get(6)));
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4100;
					} else {
						smlArray[instructionCounter++] = 4100 + branchLocation;
					}
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4200;
					} else {
						smlArray[instructionCounter++] = 4200 + branchLocation;
					}
				} else if (tokens.get(3).equals("!=")) {
					if (Character.isDigit(tokens.get(2).charAt(0))) {
						smlArray[instructionCounter++] = 2000 + table.getLocation(Integer.parseInt(tokens.get(2)));
					} else {
						smlArray[instructionCounter++] = 2000 + table.getLocation((int) tokens.get(2).charAt(0));
					}
					if (Character.isDigit(tokens.get(4).charAt(0))) {
						smlArray[instructionCounter++] = 3100 + table.getLocation(Integer.parseInt(tokens.get(4)));
					} else {
						smlArray[instructionCounter++] = 3100 + table.getLocation((int) tokens.get(4).charAt(0));
					}
					Integer branchLocation = table.searchSymbol(Integer.parseInt(tokens.get(6)));
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4100;
					} else {
						smlArray[instructionCounter++] = 4100 + branchLocation;
					}
					if (Character.isDigit(tokens.get(2).charAt(0))) {
						smlArray[instructionCounter++] = 2000 + table.getLocation(Integer.parseInt(tokens.get(2)));
					} else {
						smlArray[instructionCounter++] = 2000 + table.getLocation((int) tokens.get(2).charAt(0));
					}
					if (Character.isDigit(tokens.get(4).charAt(0))) {
						smlArray[instructionCounter++] = 3100 + table.getLocation(Integer.parseInt(tokens.get(4)));
					} else {
						smlArray[instructionCounter++] = 3100 + table.getLocation((int) tokens.get(4).charAt(0));
					}
					if (branchLocation == -1) {
						flags[instructionCounter] = Integer.parseInt(tokens.get(6));
						smlArray[instructionCounter++] = 4100;
					} else {
						smlArray[instructionCounter++] = 4100 + branchLocation;
					}
				}
				break;
			case "let":
				if (!table.isSymbolInTable(Integer.parseInt(tokens.get(0)))) {
					table.insertTableEntry(Integer.parseInt(tokens.get(0)), 'L', instructionCounter);
				}
				for (int i = 2; i < tokens.size(); i++) {
					if (Character.isDigit(tokens.get(i).charAt(0))) {
						if (!table.isSymbolInTable(Integer.parseInt(tokens.get(i)))) {
							table.insertTableEntry(Integer.parseInt(tokens.get(i)), 'C', dataCounter);
							smlArray[dataCounter--] = Integer.parseInt(tokens.get(i));
						}
					} else if (Character.isLetter(tokens.get(i).charAt(0))) {
						if (!table.isSymbolInTable((int) (tokens.get(i).charAt(0)))) {
							table.insertTableEntry((int) tokens.get(i).charAt(0), 'V', dataCounter--);
						}
					}
				}
				StringBuffer buffer = new StringBuffer();
				for (int i = 4; i < tokens.size(); i++) {
					buffer.append(tokens.get(i) + " ");
				}
				String postfix = InfixToPostfixConverter.convert(buffer.toString());
				evaluatePostfixExpressionToInstructions(postfix, (int) (tokens.get(2).charAt(0)));
				break;
			case "goto":
				if (!table.isSymbolInTable(Integer.parseInt(tokens.get(0)))) {
					table.insertTableEntry(Integer.parseInt(tokens.get(0)), 'L', instructionCounter);
				}
				Integer branchLocation = table.searchSymbol(Integer.parseInt(tokens.get(2)));
				if (branchLocation == -1) {
					System.out.println(tokens.size());
					flags[instructionCounter] = Integer.parseInt(tokens.get(2));
					smlArray[instructionCounter++] = 4000;
				} else {
					smlArray[instructionCounter++] = 4000 + branchLocation;
				}
				break;
			case "print":
				if (!table.isSymbolInTable(Integer.parseInt(tokens.get(0)))) {
					table.insertTableEntry(Integer.parseInt(tokens.get(0)), 'L', instructionCounter);
				}
				smlArray[instructionCounter++] = 1100 + table.getLocation((int) tokens.get(2).charAt(0));
				break;
			case "end":
				if (!table.isSymbolInTable(Integer.parseInt(tokens.get(0)))) {
					table.insertTableEntry(Integer.parseInt(tokens.get(0)), 'L', instructionCounter);
				}
				smlArray[instructionCounter++] = 4300;
				break;
			default:

			}
		}
	}

	private void evaluatePostfixExpressionToInstructions(String postfix, Integer storeVariable) {
		StringBuffer postfixExpression = new StringBuffer(postfix);
		Stack<Integer> stack = new Stack<>();
		postfixExpression.append(')');
		while (postfixExpression.charAt(0) != ')') {
			char current = postfixExpression.charAt(0);
			if (Character.isDigit(current)) {
				List<Integer> digits = new ArrayList<>();
				digits.add(0, current - '0');
				int number = 0;
				int digitCounter = 0;
				while (Character.isDigit(postfixExpression.charAt(digitCounter + 1))) {
					digits.add(0, postfixExpression.charAt(digitCounter + 1) - '0');
					digitCounter++;
				}
				for (int i = 0; i < digitCounter + 1; i++) {
					number += digits.remove(0) * (int) (Math.pow(10, i));
				}
				stack.push(table.getLocation(number));
				postfixExpression.delete(0, digitCounter + 1);
			} else if (Character.isLetter(current)) {
				stack.push(table.getLocation((int) current));
				postfixExpression.delete(0, 1);
			} else if (!Character.isWhitespace(current)) {
				stack.push(generateInstruction(stack.pop(), stack.pop(), current));
				postfixExpression.delete(0, 1);
			} else {
				postfixExpression.delete(0, 1);
			}
		}
		smlArray[instructionCounter++] = 2000 + stack.pop();
		smlArray[instructionCounter++] = 2100 + table.getLocation(storeVariable);
	}

	// TODO: finish implementing rest of operations
	private int generateInstruction(int argument1, int argument2, char operator) {
		if (operator == '+') {
			smlArray[instructionCounter++] = 2000 + argument2;
			smlArray[instructionCounter++] = 3000 + argument1;
			smlArray[instructionCounter++] = 2100 + dataCounter;
			return dataCounter--;
		} else if (operator == '-') {
			smlArray[instructionCounter++] = 2000 + argument2;
			smlArray[instructionCounter++] = 3100 + argument1;
			smlArray[instructionCounter++] = 2100 + dataCounter;
			return dataCounter--;
		} else if (operator == '*') {
			smlArray[instructionCounter++] = 2000 + argument2;
			smlArray[instructionCounter++] = 3300 + argument1;
			smlArray[instructionCounter++] = 2100 + dataCounter;
			return dataCounter--;
		} else if (operator == '/') {
			smlArray[instructionCounter++] = 2000 + argument2;
			smlArray[instructionCounter++] = 3200 + argument1;
			smlArray[instructionCounter++] = 2100 + dataCounter;
			return dataCounter--;
		} else {
			return 0;
		}
	}

	private void loadConvertedFileToSimpletron() {
		// TODO: change hard coded path to variable
		new Execute().run("SmlProgram.txt");
	}

	private void readProgramFromFile() {
		// Open file with code
		try {
			System.out.println("Input name of file with instruction:");
			inProgram = new Scanner(Paths.get(input.nextLine()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Loading program from file
		while (inProgram.hasNext()) {
			programInMemory.add(inProgram.nextLine());
		}

		// Close file after loading instructions
		inProgram.close();
	}
}
