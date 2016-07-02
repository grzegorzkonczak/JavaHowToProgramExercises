// Grzegorz Koñczak, 02.07.2016
// Exercise number 5.30 page 241
// Exercise from Java:How to program 10th edition

package chapter5;

public class AutoPolicyValidationTest {

	public static void main(String[] args)
	   {
	      // create two AutoPolicy objects
	      AutoPolicyValidation policy1 = 
	         new AutoPolicyValidation(11111111, "Toyota Camry", "NJ");
	      AutoPolicyValidation policy2 = 
	         new AutoPolicyValidation(22222222, "Ford Fusion", "NY");
	      
	      policy1.setState("MC");

	      // display whether each policy is in a no-fault state
	      policyInNoFaultState(policy1);
	      policyInNoFaultState(policy2);
	   }

	   // method that displays whether an AutoPolicy 
	   // is in a state with no-fault auto insurance 
	   public static void policyInNoFaultState(AutoPolicyValidation policy)
	   {
	      System.out.println("The auto policy:");
	      System.out.printf(
	         "Account #: %d; Car: %s;%nState %s %s a no-fault state%n%n", 
	         policy.getAccountNumber(), policy.getMakeAndModel(), 
	         policy.getState(), 
	         (policy.isNoFaultState() ? "is": "is not"));
	   } 
}
