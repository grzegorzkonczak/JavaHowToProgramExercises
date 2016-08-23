// Grzegorz Koñczak, 23.08.2016
// Exercise number 17.9 page 816
// Exercise from Java:How to program 10th edition

package chapter17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CountingCharacters {
	public static void main(String[] args) throws IOException {
		// Regex that matches one or more consecutive whitespace characters
		Pattern pattern = Pattern.compile("");

		// count occurrences of each word in a Stream<String> sorted by word
		Files.lines(Paths.get("toScan.txt"))
				.map(line -> line.replaceAll("\\W+", ""))
				.flatMap(line -> pattern.splitAsStream(line))
				.collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()))
				.forEach((s, l) -> System.out.printf("%s: %d%n", s, l));
	}
} // end class CountingCharacters
