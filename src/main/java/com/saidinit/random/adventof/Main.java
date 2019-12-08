package com.saidinit.random.adventof;

import com.saidinit.random.adventof.day1.Day1;
import com.saidinit.random.adventof.day1.Day1Part2;
import com.saidinit.random.adventof.day2.Day2;
import com.saidinit.random.adventof.day3.Day3;
import com.saidinit.random.adventof.day3.Day3Part2;
import com.saidinit.random.adventof.day4.Day4;
import com.saidinit.random.adventof.day4.Day4Part2;
import com.saidinit.random.adventof.day5.Day5;
import com.saidinit.random.adventof.day5.Day5Part2;
import com.saidinit.random.adventof.day6.Day6;

public class Main {

	public static void main(String[] args) {
		Day6 day6 = new Day6();
		day6.countSatelliteAndOrbits();

		day6.findSanta();

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

		Day4 day4 = new Day4();
		System.out.println("There are this many ok: " + day4.howManyAreOk());

		Day4Part2 day4part2 = new Day4Part2();
		System.out.println("There are this many ok: " + day4part2.howManyAreOk());

		Day5 day5 = new Day5();
		System.out.println("Lets check what day5 gives us: ");
		day5.runTheTest();

		Day5Part2 day5Part2 = new Day5Part2();
		System.out.println("Lets check what day5 gives us: ");
		day5Part2.runTheTest();
	}

}
