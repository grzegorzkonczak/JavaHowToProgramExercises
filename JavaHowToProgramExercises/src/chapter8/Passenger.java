// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.19 page 400
// Exercise from Java:How to program 10th edition

package chapter8;

public class Passenger {

	private String firstName;
	private String lastName;
	private int passportNumber;
	private DateEnchanced passportDueDate;
	private boolean wepons;
	private boolean food;
	private boolean moneyOver10000;
	private String[] previousDestinations;
	
	
	
	public Passenger(String firstName, String lastName, int passportNumber, DateEnchanced passportDueDate,
			boolean wepons, boolean food, boolean moneyOver10000, String[] previousDestinations) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
		this.passportDueDate = passportDueDate;
		this.wepons = wepons;
		this.food = food;
		this.moneyOver10000 = moneyOver10000;
		this.previousDestinations = previousDestinations;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(int passportNumber) {
		this.passportNumber = passportNumber;
	}
	public DateEnchanced getPassportDueDate() {
		return passportDueDate;
	}
	public void setPassportDueDate(DateEnchanced passportDueDate) {
		this.passportDueDate = passportDueDate;
	}
	public boolean isWepons() {
		return wepons;
	}
	public void setWepons(boolean wepons) {
		this.wepons = wepons;
	}
	public boolean isFood() {
		return food;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	public boolean isMoneyOver10000() {
		return moneyOver10000;
	}
	public void setMoneyOver10000(boolean moneyOver10000) {
		this.moneyOver10000 = moneyOver10000;
	}
	public String[] getPreviousDestinations() {
		return previousDestinations;
	}
	public void setPreviousDestinations(String[] previousDestinations) {
		this.previousDestinations = previousDestinations;
	}
	
	
}
