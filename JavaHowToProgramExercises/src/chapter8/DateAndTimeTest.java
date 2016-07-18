// Grzegorz Koñczak, 18.07.2016
// Exercise number 8.12 page 399
// Exercise from Java:How to program 10th edition

package chapter8;

public class DateAndTimeTest {

	public static void main(String[] args) {

		DateAndTime test1 = new DateAndTime(31, 12, 2016, 23, 59, 59);
		System.out.println(test1.toUniversalString());
		
		while (true) {
			
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}

			test1.tick();
			System.out.println(test1.toUniversalString());
		}
	}
}
