// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.14 page 399
// Exercise from Java:How to program 10th edition

// Abandoned - does not fully understand what I am suppose to do in this exercise

package chapter8;

public class fancyTime {
	
	int hour;
	int minute;
	int second;
	String meridiem;

	public String toString(){
		return String.format("%d:%02d:%02d %s", (hour == 0 || hour == 12) ? 12 : hour % 12, minute, second, meridiem);
	}
	
	public String toStringUniversal(){
		return String.format("%d:%02d:%02d", hour, minute, second);
	}
	
	public String toStringShort(){
		return String.format("%d:%02d:", hour, minute);
	}
}
