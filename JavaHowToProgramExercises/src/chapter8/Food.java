// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.10 page 398
// Exercise from Java:How to program 10th edition

package chapter8;

public enum Food {

	APPLE("fruit", 100),
	BANANA("fruit", 200),
	CARROT("vegetable", 50);
	
	private final String type;
	private final int calories;
	
	Food(String type, int calories){
		this.type = type;
		this.calories = calories;
	}

	public String getType() {
		return type;
	}

	public int getCalories() {
		return calories;
	}
	
	
}
