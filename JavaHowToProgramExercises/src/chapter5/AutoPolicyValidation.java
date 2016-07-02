// Grzegorz Koñczak, 02.07.2016
// Exercise number 5.30 page 241
// Exercise from Java:How to program 10th edition

package chapter5;

public class AutoPolicyValidation {

	private int accountNumber; // policy account number
	private String makeAndModel; // car that the policy applies to
	private String state; // two-letter state abbreviation

	// constructor
	public AutoPolicyValidation(int accountNumber, String makeAndModel, String state) {
		this.accountNumber = accountNumber;
		this.makeAndModel = makeAndModel;
		this.state = state;
	}

	// sets the accountNumber
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	// returns the accountNumber
	public int getAccountNumber() {
		return accountNumber;
	}

	// sets the makeAndModel
	public void setMakeAndModel(String makeAndModel) {
		this.makeAndModel = makeAndModel;
	}

	// returns the makeAndModel
	public String getMakeAndModel() {
		return makeAndModel;
	}

	// sets the state
	public void setState(String state) {
		if (state == "CT" || state == "MA" || state == "ME" || state == "NH" || state == "NJ" || state == "NY" || state == "PA" || state == "VT") {
			this.state = state;
		}else{
			System.out.printf("Error. %s is wrong State code.%n", state);
		}
	}

	// returns the state
	public String getState() {
		return state;
	}

	// predicate method returns whether the state has no-fault insurance
	public boolean isNoFaultState() {
		boolean noFaultState;

		// determine whether state has no-fault auto insurance
		switch (getState()) // get AutoPolicy object's state abbreviation
		{
		case "MA":
		case "NJ":
		case "NY":
		case "PA":
			noFaultState = true;
			break;
		default:
			noFaultState = false;
			break;
		}

		return noFaultState;
	}
}
