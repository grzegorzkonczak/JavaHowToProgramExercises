// Grzegorz Koñczak, 28.06.2016
// Exercise number 3.13 page 140
// Exercise from Java:How to program 10th edition

package chapter3;

public class CarApplication {

	public static void main(String[] args) {
		
		Car car1 = new Car("Toyota Yaris", "2010", 7000);
		Car car2 = new Car("Peugeot 307", "2013", 6500);
		
		System.out.printf("First car price: %.2f z³%nSecond car price: %.2f z³%n%n", car1.getPrice(), car2.getPrice());
		
		System.out.println("Applaying discount...");
		
		car1.setPrice(car1.getPrice() * (1 - 5.0 / 100));
		car2.setPrice(car2.getPrice() * (1 - 7.0 / 100));
		
		System.out.printf("First car price: %.2f z³%nSecond car price: %.2f z³%n%n", car1.getPrice(), car2.getPrice());
	}

}
