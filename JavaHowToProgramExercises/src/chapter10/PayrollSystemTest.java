// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.12 page 481
// Exercise from Java:How to program 10th edition

package chapter10;

public class PayrollSystemTest {
	public static void main(String[] args) {
		// create subclass objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", new Date(1, 13, 1987),
				800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(4, 4, 1988), 16.75,
				40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333",
				new Date(3, 7, 1976), 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis",
				"444-44-4444", new Date(7, 22, 1990), 5000, .04, 300);
		PieceWorker piecesWorker = new PieceWorker("Grzegorz", "Check", "222-22-2522", new Date(8, 4, 1978), 20,
				14);

		System.out.println("Employees processed individually:");

		System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned",
				basePlusCommissionEmployee.earnings());
		System.out.printf("%s%n%s: $%,.2f%n%n", piecesWorker, "earned", piecesWorker.earnings());

		// create four-element Employee array
		Employee[] employees = new Employee[5];

		// initialize array with Employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;
		employees[4] = piecesWorker;

		System.out.printf("Employees processed polymorphically:%n%n");

		// Birthday bonus - current month
		int month = 4;
		// generically process each element in array employees
		for (Employee currentEmployee : employees) {
			System.out.println(currentEmployee); // invokes toString

			// determine whether current employee birthday is this month and calculate salary
			if (currentEmployee.getBirthDate().getMonth() == month){
				System.out.printf("Happy bithday %s! You got $100 bonus!%n", currentEmployee.getFirstName());
				System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings() + 100);
			} else
				System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
		}

		// get type name of each object in employees array
		for (int j = 0; j < employees.length; j++)
			System.out.printf("Employee %d is a %s%n", j, employees[j].getClass().getName());
	} // end
		// main
} // end class PayrollSystemTest
