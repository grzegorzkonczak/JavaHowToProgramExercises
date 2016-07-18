// Grzegorz Koñczak, 16.07.2016
// Exercise number 8.7 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public class Time2Enchanced {
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// Time2 no-argument constructor:
	// initializes each instance variable to zero
	public Time2Enchanced() {
		this(0, 0, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour supplied, minute and second defaulted to 0
	public Time2Enchanced(int hour) {
		this(hour, 0, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour and minute supplied, second defaulted to 0
	public Time2Enchanced(int hour, int minute) {
		this(hour, minute, 0); // invoke constructor with three arguments
	}

	// Time2 constructor: hour, minute and second supplied
	public Time2Enchanced(int hour, int minute, int second) {
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

	// Time2 constructor: another Time2 object supplied
	public Time2Enchanced(Time2Enchanced time) {
		// invoke constructor with three arguments
		this(time.getHour(), time.getMinute(), time.getSecond());
	}

	// Set Methods
	// set a new time value using universal time;
	// validate the data
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

	// Get Methods
	// get hour value
	public int getHour() {
		return hour;
	}

	// get minute value
	public int getMinute() {
		return minute;
	}

	// get second value
	public int getSecond() {
		return second;
	}

	// convert to String in universal-time format (HH:MM:SS)
	public String toUniversalString() {
		return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
	}

	// convert to String in standard-time format (H:MM:SS AM or PM)
	public String toString() {
		return String.format("%d:%02d:%02d %s", ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
				getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
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
		else
			this.hour = 0;
	}
} // end class Time2