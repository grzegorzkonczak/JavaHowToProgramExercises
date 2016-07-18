// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.8 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class DateEnchanced {

	private int month; // 1-12
	private int day; // 1-31 based on month
	private int year; // any year

	private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// constructor: confirm proper value for month and day given the year
	public DateEnchanced(int month, int day, int year) {
		// check if year in range
		if (year < 0 || year > 9999)
			throw new IllegalArgumentException("year (" + year + ") must be 0 - 9999");

		// check if month in range
		if (month <= 0 || month > 12)
			throw new IllegalArgumentException("month (" + month + ") must be 1-12");

		// check if day in range for month
		if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29)))
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

		// check for leap year if month is 2 and day is 29
		if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
			throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

		this.month = month;
		this.day = day;
		this.year = year;

	}
	
	public boolean isEqualTo(DateEnchanced date){
		if (day != date.getDay())
			return false;
		if (month != date.getMonth())
			return false;
		if (year != date.getYear())
			return false;
		return true;
	}

	// increments to next day
	public void nextDay() {
		if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				&& day < 31) {
			day++;
		} else if (month == 2 && day < 29 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
			day++;
		} else if (month == 2 && day < 28) {
			day++;
		} else if ((month == 4 || month == 6 || month == 9 || month == 11) && day < 30) {
			day++;
		} else {
			day = 1;
			if (month < 12)
				month++;
			else {
				month = 1;
				year++;
			}
		}
	}

	// return a String of the form month/day/year
	public String toString() {
		return String.format("%d/%d/%d", month, day, year);
	}
}
