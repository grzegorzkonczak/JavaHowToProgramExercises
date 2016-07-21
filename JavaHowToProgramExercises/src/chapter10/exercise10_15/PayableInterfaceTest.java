// Grzegorz Koñczak, 20.07.2016
// Exercise number 10.15 page 482
// Exercise from Java:How to program 10th edition

package chapter10.exercise10_15;

public class PayableInterfaceTest {
	public static void main(String[] args) {
		// create four-element Payable array
		Payable[] payableObjects = new Payable[7];

		// populate array with objects that implement Payable
		payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
		payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
		payableObjects[2] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		payableObjects[3] = new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00);
		payableObjects[4] = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		payableObjects[5] = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);
		payableObjects[6] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300);

		System.out.println("Invoices and Employees processed polymorphically:");

		// generically process each element in array payableObjects
		for (Payable currentPayable : payableObjects) {
			if (currentPayable instanceof BasePlusCommissionEmployee) {
				// downcast Employee reference to
				// BasePlusCommissionEmployee reference
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentPayable;

				employee.setBaseSalary(1.10 * employee.getBaseSalary());

				System.out.printf("%nnew base salary with 10%% increase is: $%,.2f", employee.getBaseSalary());
			}
			// output currentPayable and its appropriate payment amount
			System.out.printf("%n%s %n%s: $%,.2f%n", currentPayable.toString(), // could
																				// invoke
																				// implicitly
					"payment due", currentPayable.getPaymentAmount());
		}
	} // end main
} // end class PayableInterfaceTest