// Grzegorz Koñczak, 01.09.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package compiler;

public class SymbolTable {

	private TableEntry[] tableEntryArray = new TableEntry[100];
	private static Integer tableCounter = 0;

	public boolean isSymbolInTable(Integer symbol) {
		for (TableEntry tableEntry : tableEntryArray) {
			if (tableEntry != null) {
				if (tableEntry.getSymbol() == symbol) {
					return true;
				}
			}
		}
		return false;
	}

	public void insertTableEntry(Integer symbol, Character type, Integer location) {
		tableEntryArray[tableCounter] = new TableEntry(symbol, type, location);
		tableCounter++;
	}

	public Integer getLocation(Integer symbol) {
		for (TableEntry tableEntry : tableEntryArray) {
			if (tableEntry.getSymbol() == symbol) {
				return tableEntry.getLocation();
			}
		}
		return -1;
	}

	public Integer searchSymbol(Integer symbol) {
		for (TableEntry tableEntry : tableEntryArray) {
			if (tableEntry != null) {
				if (tableEntry.getSymbol() == symbol) {
					return tableEntry.getLocation();
				}
			}
		}
		return -1;
	}

	public void print() {
		System.out.printf("%-6s%-6s%-6s%n", "Symbol", "Type", "Location");
		for (TableEntry tableEntry : tableEntryArray) {
			if (tableEntry != null) {
				System.out.printf("%-6d %-6c %-6d%n", tableEntry.getSymbol(), tableEntry.getType(),
						tableEntry.getLocation());
			}
		}
	}
}
