// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.19 page 400
// Exercise from Java:How to program 10th edition

package chapter8;

public class BorderCheck {

	public static void main(String[] args) {
		String[] badPlaces = {"Majorka"};
		DateEnchanced dateClaimed = new DateEnchanced(12, 23, 2020);
		String[] claimedDestinations = {"Poland", "Major"};
		String[] actualDestinations = {"Poland", "Major"};
		
		Passenger claimed = new Passenger("John", "Nowak", 2345, dateClaimed, false, true, false, claimedDestinations);
		
		Passenger actual = new Passenger("John", "Nowak", 2345, dateClaimed, false, true, false, actualDestinations);
		
		boolean action = checkPassenger(claimed, actual, badPlaces);
		
		System.out.println("Any action: " + action);
	}

	private static boolean checkPassenger(Passenger claimed, Passenger actual, String[] badPlaces) {
		if (claimed.getFirstName() != actual.getFirstName())
			return true;
		if (claimed.getLastName() != actual.getLastName())
			return true;
		if (claimed.getPassportNumber() != actual.getPassportNumber())
			return true;
		if (!claimed.getPassportDueDate().isEqualTo(actual.getPassportDueDate()))
			return true;
		if (claimed.isWepons() != actual.isWepons())
			return true;
		if (claimed.isFood() != actual.isFood())
			return true;
		if (claimed.isMoneyOver10000() != actual.isMoneyOver10000())
			return true;
		boolean destinations = false;
		for (int i = 0; i < claimed.getPreviousDestinations().length; i++){
			for (int j = i; j < actual.getPreviousDestinations().length; j++){
				if (claimed.getPreviousDestinations()[i] != actual.getPreviousDestinations()[j])
					destinations = true;
				break;
			}
		}
		for (int i = 0; i < actual.getPreviousDestinations().length; i++){
			for (int j = i; j < claimed.getPreviousDestinations().length; j++){
				if (actual.getPreviousDestinations()[i] != claimed.getPreviousDestinations()[j])
					destinations = true;
				break;
			}
		}
		if (destinations)
			return true;
		for (int i = 0; i < claimed.getPreviousDestinations().length; i++){
			if (claimed.getPreviousDestinations()[i] == badPlaces[0]){
				return true;
			}
		}
		return false;
	}
	
}
