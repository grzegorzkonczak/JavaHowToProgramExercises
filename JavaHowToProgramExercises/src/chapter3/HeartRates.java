// Grzegorz Koñczak, 29.06.2016
// Exercise number 3.16 page 141
// Exercise from Java:How to program 10th edition

package chapter3;

public class HeartRates {
	
	private String firstName;
	private String lastName;
	private int day;
	private int month;
	private int year;
	
	public HeartRates(String firstName, String lastName, int day, int month, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int calculateAge(){
		int age = 2016 - year;
		return age;
	}
	
	public int calculateMax(){
		int maxHeartRate = 220 - this.calculateAge();
		return maxHeartRate;
	}
	
	public int calculateTarget(){
		int targetHeartRate = ((int)(this.calculateMax() * (3.0 / 4.0)));
		return targetHeartRate;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
