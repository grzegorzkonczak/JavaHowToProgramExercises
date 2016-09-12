// Grzegorz Koñczak, 12.09.2016
// Exercise number 23.16 page 1085
// Exercise from Java:How to program 10th edition

package chapter23;

public class ParallelEmployee
{
   private String firstName;
   private String lastName;
   private double salary; 
   private String department;
   
   // constructor 
   public ParallelEmployee(String firstName, String lastName, 
      double salary, String department)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
      this.department = department;
   } 

   // set firstName
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   // get firstName
   public String getFirstName()
   {
      return firstName;
   }

   // set lastName
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   // get lastName
   public String getLastName()
   {
      return lastName;
   }

   // set salary
   public void setSalary(double salary)
   {
      this.salary = salary;
   }

   // get salary
   public double getSalary()
   {
      return salary;
   }

   // set department
   public void setDepartment(String department)
   {
      this.department = department;
   }

   // get department
   public String getDepartment()
   {
      return department;
   }

   // return Employee's first and last name combined
   public String getName()
   {
      return String.format("%s %s", getFirstName(), getLastName());
   }

   // return a String containing the Employee's information
   @Override
   public String toString() 
   {
      return String.format("%-8s %-8s %8.2f   %s", 
         getFirstName(), getLastName(), getSalary(), getDepartment());
   } // end method toString
}
