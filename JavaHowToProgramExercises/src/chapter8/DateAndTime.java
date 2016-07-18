// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.12 page 399
// Exercise from Java:How to program 10th edition

package chapter8;

public class DateAndTime {

	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59
	private int month; // 1-12
	private int day; // 1-31 based on month
	private int year; // any year
	
	private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };


	public DateAndTime(int day, int month, int year, int hour, int minute, int second) {
		
		// check if hour in range
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		// check if minute in range
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		// check if second in range
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;

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




	public int getHour() {
		return hour;
	}




	public int getMinute() {
		return minute;
	}




	public int getSecond() {
		return second;
	}




	// sets the clock to given hour
	public void setTime(int hour, int minute, int second) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	// validate and set hour
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24)
			throw new IllegalArgumentException("hour must be 0-23");

		this.hour = hour;
	}

	// validate and set minute
	public void setMinute(int minute) {
		if (minute < 0 || minute >= 60)
			throw new IllegalArgumentException("minute must be 0-59");

		this.minute = minute;
	}

	// validate and set second
	public void setSecond(int second) {
		if (second < 0 || second >= 60)
			throw new IllegalArgumentException("second must be 0-59");

		this.second = second;
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
	
		public void tick() {
			if (this.second < 59)
				this.second++;
			else {
				this.second = 0;
				incrementMinute();
			}
		}

		public void incrementMinute() {
			if (this.minute < 59)
				this.minute++;
			else {
				this.minute = 0;
				incrementHour();
			}
		}

		public void incrementHour() {
			if (this.hour < 23)
				this.hour++;
			else{
				this.hour = 0;
				this.nextDay();
			}
		}
		
		// convert to String in universal-time format (HH:MM:SS)
		public String toUniversalString() {
			return String.format("%d/%d/%d  %02d:%02d:%02d", month, day, year, getHour(), getMinute(), getSecond());
		}

		// convert to String in standard-time format (H:MM:SS AM or PM)
		public String toString() {
			return String.format("%d/%d/%d  %d:%02d:%02d %s", month, day, year, ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
					getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
		}

}
