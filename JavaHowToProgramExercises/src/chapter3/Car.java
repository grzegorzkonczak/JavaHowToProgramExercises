// Grzegorz Koñczak, 28.06.2016
// Exercise number 3.13 page 140
// Exercise from Java:How to program 10th edition

package chapter3;

public class Car {

	private String model;
	private String productionYear;
	private double price;
	
	public Car(String model, String productionYear, double price){
		this.model = model;
		this.productionYear = productionYear;
		if (price > 0)
			this.price = price;
	}
	
	public void setModel (String model){
		this.model = model;
	}
	
	public void setProductionYear (String productionYear){
		this.productionYear = productionYear;
	}
	
	public void setPrice (double price){
		if (price > 0)
			this.price = price;
	}
	
	public String getModel(){
		return model;
	}
	
	public String getProductionYear(){
		return productionYear;
	}
	
	public double getPrice(){
		return price;
	}
}
