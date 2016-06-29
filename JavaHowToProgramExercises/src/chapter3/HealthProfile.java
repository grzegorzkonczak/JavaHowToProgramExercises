// Grzegorz Koñczak, 29.06.2016
// Exercise number 3.17 page 141
// Exercise from Java:How to program 10th edition

package chapter3;

public class HealthProfile {

	private String firstName;
	private String lastName;
	private int day;
	private int month;
	private int year;
	private String gender;
	private double weight;
	private double height;
	
	public HealthProfile(String firstName, String lastName, int day, int month, int year, String gender, double weight,
			double height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.day = day;
		this.month = month;
		this.year = year;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
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
	
	public double calculateBmi(){
		double bmi = weight / (height * height);
		return bmi;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	
}
