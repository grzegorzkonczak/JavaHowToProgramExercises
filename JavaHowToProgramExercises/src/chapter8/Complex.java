// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.11 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class Complex {

	private double realPart;
	private double imaginaryPart;
	
	public Complex(){
		this(1.0, 1.0);
	}
	
	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public Complex add(Complex number1){
		double realSum = this.getRealPart() + number1.getRealPart();
		double imaginarySum = this.getImaginaryPart()+ number1.getImaginaryPart();
		return new Complex(realSum, imaginarySum);
	}
	
	public Complex subtract(Complex number1){
		double realDif = this.getRealPart() - number1.getRealPart();
		double imaginaryDif = this.getImaginaryPart() - number1.getImaginaryPart();
		return new Complex(realDif, imaginaryDif);
	}
	
	public String toString(){
		return String.format("%s %.2f%n%s %.2f*i", "Real part:", realPart, "Imaginary part:", imaginaryPart);
	}

	public double getRealPart() {
		return realPart;
	}

	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	
	
}
