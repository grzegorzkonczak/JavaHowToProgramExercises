// Grzegorz Koñczak, 28.06.2016
// Exercise number 3.13 page 140
// Exercise from Java:How to program 10th edition

package chapter3;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public void displayDate(){
		String date = String.format("%d/%02d/%d", day, month, year);
		System.out.println(date);
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
