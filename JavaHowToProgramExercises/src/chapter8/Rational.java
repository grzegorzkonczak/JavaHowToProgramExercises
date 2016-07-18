// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.15 page 399
// Exercise from Java:How to program 10th edition

package chapter8;

public class Rational {

	private int numerator;
	private int denominator;

	// Constructor - keeps number in reduced form
	public Rational(int numerator, int denominator) {
		int commonDivisor = GreatestCommonDivisor.gcd(numerator, denominator);
		this.numerator = numerator / commonDivisor;
		this.denominator = denominator / commonDivisor;
	}

	// Default no-argument constructor
	public Rational() {
		this(1, 1);
	}

	// Method for adding two rational numbers
	public static Rational add(Rational number1, Rational number2) {
		int lcd = (Math.abs(number1.getDenominator() * number2.getDenominator()))
				/ GreatestCommonDivisor.gcd(number1.getDenominator(), number2.getDenominator());

		int numerator1 = (lcd / number1.getDenominator()) * number1.getNumerator();
		int numerator2 = (lcd / number2.getDenominator()) * number2.getNumerator();
		return new Rational(numerator1 + numerator2, lcd);
	}

	// Method for subtracting two rational numbers
	public static Rational subtract(Rational number1, Rational number2) {
		int lcd = (Math.abs(number1.getDenominator() * number2.getDenominator()))
				/ GreatestCommonDivisor.gcd(number1.getDenominator(), number2.getDenominator());

		int numerator1 = (lcd / number1.getDenominator()) * number1.getNumerator();
		int numerator2 = (lcd / number2.getDenominator()) * number2.getNumerator();
		return new Rational(numerator1 - numerator2, lcd);
	}
	
	// Method for multiplying two rational numbers
	public static Rational multiply(Rational number1, Rational number2){
		return new Rational(number1.getNumerator() * number2.getNumerator(),
				number1.getDenominator() * number2.getDenominator());
	}
	
	// Method for dividing two rational numbers
		public static Rational divide(Rational number1, Rational number2){
			return new Rational(number1.getNumerator() * number2.getDenominator(),
					number1.getDenominator() * number2.getNumerator());
		}

	public String toString() {
		return String.format("%d/%d", numerator, denominator);
	}
	
	public String toStringFloat(int precision){
		double number = (double)numerator / denominator;
		return String.format("%." + precision + "f", number);
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

}
