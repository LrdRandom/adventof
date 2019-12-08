package com.saidinit.random.adventof.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReadInput {

	public static List<String> getDay1Input() {
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

	public static int[] getDay2Input() {
		String fileName = "D:\\Documents\\My Projects\\workspace\\day1\\src\\main\\resources\\day2input.txt";

		List<String> inputList = new ArrayList<>();
		try {
			inputList = Files.readAllLines(Paths.get(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Arrays.stream(inputList.get(0).split(",")).mapToInt(Integer::parseInt).toArray();

	}
}