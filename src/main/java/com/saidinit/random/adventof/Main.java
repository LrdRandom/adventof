package com.saidinit.random.adventof;

import com.saidinit.random.adventof.day1.Day1;
import com.saidinit.random.adventof.day1.Day1Part2;
import com.saidinit.random.adventof.day2.Day2;

public class Main {

	public static void main(String[] args) {
		Day1 day1 = new Day1();

		System.out.println("Day1: " + day1.getFuel());

		Day1Part2 day1Part2 = new Day1Part2();

		System.out.println("Day1Part2: " + day1Part2.getFuel());

		Day2 day2 = new Day2();

		System.out.println("Day2: " + day2.restore());

		// day2part2 is on a unit test

	}

}
