// Grzegorz Koñczak, 23.08.2016
// Exercise number 17.10 page 816
// Exercise from Java:How to program 10th edition

package chapter17;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileTypes {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println("Enter directory you want to check:");
		Path path = Paths.get(input.nextLine());

		if (Files.exists(path)) { // if path exists, output info about it
			if (Files.isDirectory(path)) // output directory listing
			{
				System.out.printf("%nTypes of files and how many there are:%n");

				// object for iterating through a directory's contents
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);

				List<File> pathsList = new ArrayList<>();

				for (Path path2 : directoryStream) {
					pathsList.add(path2.toFile());
				}

				pathsList.stream().filter(file -> !file.isDirectory()).map(file -> getFileExtension(file))
						.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()))
						.forEach((extension, count) -> System.out.printf("%-8s: %d%n", extension, count));

			}
		}
	}

	private static String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);
		} catch (Exception e) {
			return "";
		}
	}
}
