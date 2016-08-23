// Grzegorz Koñczak, 23.08.2016
// Exercise number 17.13 page 817
// Exercise from Java:How to program 10th edition

// Not finished

package chapter17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SortingPhoneDirectory {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\s+");

		try {
			List<String> streamedData = Files.lines(Paths.get("directory.txt"))
					.flatMap(line -> pattern.splitAsStream(line)).collect(Collectors.toList());

			streamedData.stream().forEach(System.out::println);

			List<String> phoneNumbers = streamedData.stream().filter(s -> Character.isDigit(s.charAt(0))).sorted()
					.collect(Collectors.toList());

			phoneNumbers.stream().forEach(System.out::println);

			Map<String, List<String>> names = streamedData.stream().filter(s -> Character.isLetter(s.charAt(0))).sorted()
					.collect(Collectors.groupingBy(Function.identity()));
			
			names.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + entry.getValue()));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
