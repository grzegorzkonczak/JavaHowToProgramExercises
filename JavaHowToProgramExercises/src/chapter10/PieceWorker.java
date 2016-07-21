// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.14 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class PieceWorker extends Employee {

	private double wage;
	private int pieces;

	public PieceWorker(String firstName, String lastName, String socialSecurityNumber, Date birthDate, double wage,
			int pieces) {
		super(firstName, lastName, socialSecurityNumber, birthDate);
		this.pieces = pieces;
		this.wage = wage;
	}
	
	

	public double getWage() {
		return wage;
	}



	public void setWage(double wage) {
		this.wage = wage;
	}



	public int getPieces() {
		return pieces;
	}



	public void setPieces(int pieces) {
		this.pieces = pieces;
	}



	@Override
	public double earnings() {
		return pieces * wage;
	}

	// return String representation of PiecesEmployee object
	@Override
	public String toString() {
		return String.format("pieces employee: %s%n%s: $%,.2f; %s: %d", super.toString(), "wage per piece", getWage(),
				"pieces made", getPieces());
	}
}
