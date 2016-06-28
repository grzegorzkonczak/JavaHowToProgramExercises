// Grzegorz Koñczak, 28.06.2016
// Exercise number 3.12 page 140
// Exercise from Java:How to program 10th edition

package chapter3;

public class PetrolPurchase {

	private String stationLocation;
	private String petrolType;
	private int quantityInLiters;
	private int pricePerLiter;
	private double discount;
	
	
	public PetrolPurchase(String stationLocation, String petrolType, int quantityInLiters, int pricePerLiter,
			double discount) {
		this.stationLocation = stationLocation;
		this.petrolType = petrolType;
		this.quantityInLiters = quantityInLiters;
		this.pricePerLiter = pricePerLiter;
		this.discount = discount;
	}
	
	public double getPurchaseAmount()
	{
		double result = (quantityInLiters * pricePerLiter) * (1 - discount / 100);
		return result;
	}


	public String getStationLocation() {
		return stationLocation;
	}


	public void setStationLocation(String stationLocation) {
		this.stationLocation = stationLocation;
	}


	public String getPetrolType() {
		return petrolType;
	}


	public void setPetrolType(String petrolType) {
		this.petrolType = petrolType;
	}


	public int getQuantityInLiters() {
		return quantityInLiters;
	}


	public void setQuantityInLiters(int quantityInLiters) {
		this.quantityInLiters = quantityInLiters;
	}


	public int getPricePerLiter() {
		return pricePerLiter;
	}


	public void setPricePerLiter(int pricePerLiter) {
		this.pricePerLiter = pricePerLiter;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
	
}
