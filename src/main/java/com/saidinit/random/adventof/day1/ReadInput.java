package com.saidinit.random.adventof.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReadInput {

	protected static List<String> getDayInput() {
		String fileName = "D:\\Documents\\My Projects\\workspace\\day1\\src\\main\\resources\\day1input.txt";
		List<String> ret = new ArrayList<>();

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(ret::add);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ret;
	}
}
