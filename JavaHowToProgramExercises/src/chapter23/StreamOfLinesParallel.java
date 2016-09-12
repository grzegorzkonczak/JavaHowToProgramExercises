// Grzegorz Koñczak, 12.09.2016
// Exercise number 23.15 page 1085
// Exercise from Java:How to program 10th edition

package chapter23;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamOfLinesParallel {
	public static void main(String[] args) throws IOException {
		
		Instant start;
		Instant end;
		// Regex that matches one or more consecutive whitespace characters
		Pattern pattern = Pattern.compile("\\s+");

		start = Instant.now();
		// count occurrences of each word in a Stream<String> sorted by word
		Map<String, Long> wordCounts = Files.lines(Paths.get("Chapter2Paragraph.txt")).parallel()
				.map(line -> line.replaceAll("(?!')\\p{P}", "")).flatMap(line -> pattern.splitAsStream(line))
				.collect(Collectors.groupingBy(String::toLowerCase, TreeMap::new, Collectors.counting()));

		// display the words grouped by starting letter
		wordCounts.entrySet().stream().parallel()
				.collect(Collectors.groupingBy(entry -> entry.getKey().charAt(0), TreeMap::new, Collectors.toList()))
				.forEach((letter, wordList) -> {
					System.out.printf("%n%C%n", letter);
					wordList.stream().forEach(word -> System.out.printf("%13s: %d%n", word.getKey(), word.getValue()));
				});
		
		end = Instant.now();
		
		long time = Duration.between(start, end).toMillis();
		System.out.println(time);
	}
} // end class StreamOfLines
