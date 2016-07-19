// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.15 page 436
// Exercise from Java:How to program 10th edition

package chapter9;

public class HourlyEmployeeTest {

	public static void main(String[] args) {
		
		HourlyEmployee employee = new HourlyEmployee("Zdzich", "Kowalski", "222-222-222", 7.5, 60);
		
		System.out.println(employee);
		
		employee.setHours(95);
		employee.setWage(8.3);
		
		System.out.println(employee);
	}
}
