// Grzegorz Koñczak, 02.07.2016
// Exercise number 5.29 page 240
// Exercise from Java:How to program 10th edition

package chapter5;

public class TwelveDays {

	public static void main(String[] args) {
		
		System.out.println("The Twelve Days of Christmas\n\n");
		
		for (int i = 0; i < 12; i++){
			System.out.print("On the ");
			
			switch (i){
			case 0:
				System.out.print("first ");
				break;
			case 1:
				System.out.print("second ");
				break;
			case 2:
				System.out.print("third ");
				break;
			case 3:
				System.out.print("fourth ");
				break;
			case 4:
				System.out.print("fifth ");
				break;
			case 5:
				System.out.print("sixth ");
				break;
			case 6:
				System.out.print("seventh ");
				break;
			case 7:
				System.out.print("eighth ");
				break;
			case 8:
				System.out.print("ninth ");
				break;
			case 9:
				System.out.print("tenth ");
				break;
			case 10:
				System.out.print("eleventh ");
				break;
			case 11:
				System.out.print("twelfth ");
				break;
			}
			
			System.out.print("day of Christmas\nmy true love sent to me:\n");
			
			switch (i){
			case 11:
				System.out.print("12 Drummers Drumming\n");
			case 10:
				System.out.print("11 Pipers Piping\n");
			case 9:
				System.out.print("10 Lords a Leaping\n");
			case 8:
				System.out.print("9 Ladies Dancing\n");
			case 7:
				System.out.print("8 Maids a Milking\n");
			case 6:
				System.out.print("7 Swans a Swimming\n");
			case 5:
				System.out.print("6 Geese a Laying\n");
			case 4:
				System.out.print("5 Golden Rings\n");
			case 3:
				System.out.print("4 Calling Birds\n");
			case 2:
				System.out.print("3 French Hens\n");
			case 1:
				System.out.print("2 Turtle Doves\n");
			case 0:
				if (i < 1){
					System.out.print("A");
				}else{
					System.out.print("and a");
				}
				System.out.print(" Partridge in a Pear Tree ");
			}
			
			System.out.print("\n\n");
		}
	}
}
