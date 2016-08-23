// Grzegorz Koñczak, 23.08.2016
// Exercise number 17.11 page 816
// Exercise from Java:How to program 10th edition

package chapter17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InvoiceManipulation {

	public static void main(String[] args) {

		Invoice[] invoices = { new Invoice(83, "Electric sander", 7, 57.98), new Invoice(24, "Power saw", 18, 99.99),
				new Invoice(7, "Slledge hammer", 11, 21.50), new Invoice(77, "Hammer", 76, 11.99),
				new Invoice(39, "Lawn mower", 3, 79.50), new Invoice(68, "Scredriver", 106, 6.99),
				new Invoice(56, "Jig saw", 21, 11.00), new Invoice(3, "Wrench", 34, 7.50) };

		// sorting by description
		Arrays.stream(invoices).sorted(Comparator.comparing(Invoice::getPartDescryption)).forEach(System.out::println);

		System.out.println();

		// sorting by price
		Arrays.stream(invoices).sorted(Comparator.comparing(Invoice::getPrice)).forEach(System.out::println);

		System.out.println();

		// mapping invoice to description and quantity and sorting by quantity
		Arrays.stream(invoices).collect(Collectors.toMap(Invoice::getPartDescryption, Invoice::getQuantity)).entrySet()
				.stream().sorted(Map.Entry.comparingByValue())
				.forEach((entry) -> System.out.println(entry.getKey() + ": " + entry.getValue()));

		System.out.println();

		// mapping invoice to description and value of invoices and sorting by
		// value
		Arrays.stream(invoices)
				.collect(Collectors.toMap(Invoice::getPartDescryption, i -> i.getPrice() * i.getQuantity())).entrySet()
				.stream().sorted(Map.Entry.comparingByValue())
				.forEach((entry) -> System.out.println(entry.getKey() + ": " + entry.getValue()));

		System.out.println();

		// mapping invoice to description and value of invoices and sorting by
		// value
		Arrays.stream(invoices)
				.collect(Collectors.toMap(Invoice::getPartDescryption, i -> i.getPrice() * i.getQuantity())).entrySet()
				.stream().sorted(Map.Entry.comparingByValue())
				.forEach((entry) -> System.out.println(entry.getKey() + ": " + entry.getValue()));

		System.out.println();

		// mapping invoice to description and value of invoices and sorting by
		// value (only invoices in range 200-500$)
		Predicate<Invoice> twoToFiveHundreds = e -> (e.getPrice() * e.getQuantity() >= 200
				&& e.getPrice() * e.getQuantity() <= 500);
		Arrays.stream(invoices).filter(twoToFiveHundreds)
				.collect(Collectors.toMap(Invoice::getPartDescryption, i -> i.getPrice() * i.getQuantity())).entrySet()
				.stream().sorted(Map.Entry.comparingByValue())
				.forEach((entry) -> System.out.println(entry.getKey() + ": " + entry.getValue()));
	}
}
