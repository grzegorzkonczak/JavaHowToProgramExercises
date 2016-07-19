// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.15 page 436
// Exercise from Java:How to program 10th edition

package chapter9;

public class HourlyEmployee extends Employee {

	private double hours;
	private double wage;

	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber);

		this.wage = wage;
		this.hours = hours;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		if (hours >= 0 && hours <= 168)
			this.hours = hours;
		else
			throw new IllegalArgumentException("Hour's should be between 0 and 168");
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {
		if (wage >= 0)
			this.wage = wage;
		else
			throw new IllegalArgumentException("Wage can't be negative.");
	}
	
	public double earanings(){
		return wage * hours;
	}

	@Override
	public String toString(){
		return String.format("%s%s%s: %.2f%n%s: %.2f%n%s: %.2f%n", "Hourly ", super.toString(), "Wage", getWage(),
				"Hours", getHours(), "Earnings", earanings());
	}
}
