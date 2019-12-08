package com.saidinit.random.adventof.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day1Part2Test {

	Day1Part2 day1Part2;

	@BeforeEach
	public void setUp() {
		day1Part2 = new Day1Part2();
	}

	@AfterEach
	public void tearDown() {
		day1Part2 = null;
	}

	@Test
	public void getFuel() {
		assertEquals(2, day1Part2.calculateFuel(14), "Mass of 14 should return 2");
		assertEquals(966, day1Part2.calculateFuel(1969), "Mass of 1969 should return 966");
		assertEquals(50346, day1Part2.calculateFuel(100756), "Mass of 100756 should return 50346");
	}
}
