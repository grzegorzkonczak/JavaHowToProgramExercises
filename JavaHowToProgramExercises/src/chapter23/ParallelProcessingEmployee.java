// Grzegorz Koñczak, 12.09.2016
// Exercise number 23.16 page 1085
// Exercise from Java:How to program 10th edition

package chapter23;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ParallelProcessingEmployee
{
   public static void main(String[] args)
   {
      // initialize array of Employees
      ParallelEmployee[] employees = {
         new ParallelEmployee("Jason", "Red", 5000, "IT"),
         new ParallelEmployee("Ashley", "Green", 7600, "IT"),
         new ParallelEmployee("Matthew", "Indigo", 3587.5, "Sales"),
         new ParallelEmployee("James", "Indigo", 4700.77, "Marketing"),
         new ParallelEmployee("Luke", "Indigo", 6200, "IT"),
         new ParallelEmployee("Jason", "Blue", 3200, "Sales"),
         new ParallelEmployee("Wendy", "Brown", 4236.4, "Marketing")};
      
      Instant start;
      Instant end;

      start = Instant.now();
      // get List view of the Employees
      List<ParallelEmployee> list = Arrays.asList(employees);

      // display all Employees
      System.out.println("Complete Employee list:");
      list.stream().parallel().forEach(System.out::println);
      
      // Predicate that returns true for salaries in the range $4000-$6000
      Predicate<ParallelEmployee> fourToSixThousand = 
         e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);

      // Display Employees with salaries in the range $4000-$6000
      // sorted into ascending order by salary
      System.out.printf(
         "%nEmployees earning $4000-$6000 per month sorted by salary:%n");
      list.stream().parallel()
          .filter(fourToSixThousand)
          .sorted(Comparator.comparing(ParallelEmployee::getSalary))
          .forEach(System.out::println);

      // Display first Employee with salary in the range $4000-$6000
      System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n",
         list.stream().parallel()
             .filter(fourToSixThousand)
             .findFirst()
             .get());

      // Functions for getting first and last names from an Employee
      Function<ParallelEmployee, String> byFirstName = ParallelEmployee::getFirstName;
      Function<ParallelEmployee, String> byLastName = ParallelEmployee::getLastName;

      // Comparator for comparing Employees by first name then last name
      Comparator<ParallelEmployee> lastThenFirst = 
         Comparator.comparing(byLastName).thenComparing(byFirstName);

      // sort employees by last name, then first name 
      System.out.printf(
         "%nEmployees in ascending order by last name then first:%n");
      list.stream().parallel()
          .sorted(lastThenFirst)
          .forEach(System.out::println);

      // sort employees in descending order by last name, then first name
      System.out.printf(
         "%nEmployees in descending order by last name then first:%n");
      list.stream().parallel()
          .sorted(lastThenFirst.reversed())
          .forEach(System.out::println);

      // display unique employee last names sorted
      System.out.printf("%nUnique employee last names:%n");
      list.stream().parallel()
          .map(ParallelEmployee::getLastName)
          .distinct()
          .sorted()
          .forEach(System.out::println);

      // display only first and last names
      System.out.printf(
         "%nEmployee names in order by last name then first name:%n"); 
      list.stream().parallel()
          .sorted(lastThenFirst)
          .map(ParallelEmployee::getName)
          .forEach(System.out::println);

      // group Employees by department
      System.out.printf("%nEmployees by department:%n"); 
      Map<String, List<ParallelEmployee>> groupedByDepartment =
         list.stream().parallel()
             .collect(Collectors.groupingBy(ParallelEmployee::getDepartment));
      groupedByDepartment.forEach(
         (department, employeesInDepartment) -> 
         {
            System.out.println(department);
            employeesInDepartment.forEach(
               employee -> System.out.printf("   %s%n", employee));
         }
      );

      // count number of Employees in each department
      System.out.printf("%nCount of Employees by department:%n"); 
      Map<String, Long> employeeCountByDepartment =
         list.stream().parallel()
             .collect(Collectors.groupingBy(ParallelEmployee::getDepartment, 
                TreeMap::new, Collectors.counting()));
      employeeCountByDepartment.forEach(
         (department, count) -> System.out.printf(
            "%s has %d employee(s)%n", department, count));

      // sum of Employee salaries with DoubleStream sum method
      System.out.printf(
         "%nSum of Employees' salaries (via sum method): %.2f%n",
         list.stream().parallel()
             .mapToDouble(ParallelEmployee::getSalary)
             .sum());

      // calculate sum of Employee salaries with Stream reduce method
      System.out.printf(
         "Sum of Employees' salaries (via reduce method): %.2f%n",
         list.stream().parallel()
             .mapToDouble(ParallelEmployee::getSalary)
             .reduce(0, (value1, value2) -> value1 + value2));  

      // average of Employee salaries with DoubleStream average method
      System.out.printf("Average of Employees' salaries: %.2f%n",
         list.stream().parallel()
             .mapToDouble(ParallelEmployee::getSalary)
             .average()
             .getAsDouble());   
      
      end = Instant.now();
      long time = Duration.between(start, end).toMillis();
      System.out.println(time);
   } // end main
} 