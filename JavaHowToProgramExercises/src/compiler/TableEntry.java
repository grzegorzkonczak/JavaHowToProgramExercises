// Grzegorz Koñczak, 01.09.2016
// Special section - building compiler
// Exercise from Java:How to program 10th edition

package compiler;

public class TableEntry {

	private Integer symbol;
	private Character type;
	private Integer location;
	
	public TableEntry(Integer symbol, Character type, Integer location) {
		this.symbol = symbol;
		this.type = type;
		this.location = location;
	}

	public Integer getSymbol() {
		return symbol;
	}

	public void setSymbol(Integer symbol) {
		this.symbol = symbol;
	}

	public Character getType() {
		return type;
	}

	public void setType(Character type) {
		this.type = type;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}
	
	
}
