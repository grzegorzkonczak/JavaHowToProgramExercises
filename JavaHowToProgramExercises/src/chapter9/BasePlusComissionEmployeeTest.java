// Grzegorz Koñczak, 19.07.2016
// Exercise number 9.14 page 436
// Exercise from Java:How to program 10th edition

package chapter9;

public class BasePlusComissionEmployeeTest {
	public static void main(String[] args) 
	   {
	      // instantiate BasePlusCommissionEmployee object
	      BasePlusComissionEmployee employee = 
	         new BasePlusComissionEmployee(
	            "Bob", "Lewis", "333-33-3333", 5000, .04, 300);
	      
	      // get base-salaried commission employee data
	      System.out.println(
	         "Employee information obtained by get methods:");
	      System.out.printf("%n%s %s%n", "First name is",
	         employee.getFirstName());
	      System.out.printf("%s %s%n", "Last name is", 
	         employee.getLastName());
	      System.out.printf("%s %s%n", "Social security number is", 
	         employee.getSocialSecurityNumber());
	      System.out.printf("%s %.2f%n", "Gross sales is", 
	         employee.getGrossSales());
	      System.out.printf("%s %.2f%n", "Commission rate is",
	         employee.getCommissionRate());
	      System.out.printf("%s %.2f%n", "Base salary is",
	         employee.getBaseSalary());

	      employee.setBaseSalary(1000); 
	      
	      System.out.printf("%n%s:%n%n%s%n", 
	         "Updated employee information obtained by toString", 
	         employee.toString());
	   } // end main
}
