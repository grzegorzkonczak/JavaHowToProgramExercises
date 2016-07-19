// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.3 page 435
// Exercise from Java:How to program 10th edition

package chapter9;

public class BasePlusCommisionEmployee {

	private double baseSalary; // base salary per week
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private double grossSales;
	private double commissionRate;

	// six-argument constructor
	public BasePlusCommisionEmployee(double baseSalary, String firstName, String lastName, String socialSecurityNumber,
			double grossSales, double commisionRate) {
		// implicit call to Object constructor occurs here

		// if grossSales is invalid throw exception
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		// if commissionRate is invalid throw exception
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
		// if baseSalary is invalid throw exception
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		this.baseSalary = baseSalary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.grossSales = grossSales;
		this.commissionRate = commisionRate;
	}

	// set base salary
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	}

	// calculate earnings
	public double earnings() {
		return getBaseSalary() + getCommissionRate() * getGrossSales();
	}

	// return first name
	public String getFirstName() {
		return firstName;
	}

	// return last name
	public String getLastName() {
		return lastName;
	}

	// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	// set gross sales amount
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		this.grossSales = grossSales;
	}

	// return gross sales amount
	public double getGrossSales() {
		return grossSales;
	}

	// set commission rate
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		this.commissionRate = commissionRate;
	}

	// return commission rate
	public double getCommissionRate() {
		return commissionRate;
	}

	// return String representation of CommissionEmployee object
	@Override
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f", "base-salaried commission employee", getFirstName(),
				getLastName(), "social security number", getSocialSecurityNumber(), "gross sales", getGrossSales(),
				"commission rate", getCommissionRate(), "base salary", getBaseSalary());
	}
} // end class BasePlusCommissionEmployee
