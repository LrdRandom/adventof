package com.saidinit.random.adventof;

import com.saidinit.random.adventof.day1.Day1;
import com.saidinit.random.adventof.day1.Day1Part2;
import com.saidinit.random.adventof.day2.Day2;
import com.saidinit.random.adventof.day3.Day3;
import com.saidinit.random.adventof.day3.Day3Part2;
import com.saidinit.random.adventof.day4.Day4;
import com.saidinit.random.adventof.day4.Day4Part2;

public class Main {

	public static void main(String[] args) {
		Day4 day4 = new Day4();
		System.out.println("There are this many ok: " + day4.howManyAreOk());

		Day4Part2 day4part2 = new Day4Part2();
		System.out.println("There are this many ok: " + day4part2.howManyAreOk());
	}

	private static void oldMains() {
		Day1 day1 = new Day1();

		System.out.println("Day1: " + day1.getFuel());

		Day1Part2 day1Part2 = new Day1Part2();

		System.out.println("Day1Part2: " + day1Part2.getFuel());

		Day2 day2 = new Day2();

		System.out.println("Day2: " + day2.restore());

		// day2part2 is on a unit test

		Day3 day3 = new Day3();
		System.out.println("Day3: " + day3.solve());

		Day3Part2 day3part2 = new Day3Part2();
		System.out.println("Day3Part2 " + day3part2.solve());
	}

}
