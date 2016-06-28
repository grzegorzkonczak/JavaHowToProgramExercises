// Grzegorz Koñczak, 28.06.2016
// Exercise number 3.12 page 140
// Exercise from Java:How to program 10th edition

package chapter3;

public class Petrol {

	public static void main(String[] args) {
		
		PetrolPurchase lastPurchase = new PetrolPurchase("Orlen", "Diesel", 150, 5, 10.25);
		
		double myLastPurchase = lastPurchase.getPurchaseAmount();
		
		System.out.printf("I was on my station - %s, fillin up some %s.%nIt's nice to have discount! Mine is %.2f %%...%n",
				lastPurchase.getStationLocation(), lastPurchase.getPetrolType(), lastPurchase.getDiscount());
		System.out.printf("The price was %d and I poured about %d liters. But I only paid %.2f - nice!",
				lastPurchase.getPricePerLiter(), lastPurchase.getQuantityInLiters(), myLastPurchase);
	}

}
