package com.saidinit.random.adventof.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Part2Test {
	private Day3Part2 day3;

	@BeforeEach
	public void setUp() {
		day3 = new Day3Part2();
	}

	@AfterEach
	public void tearDown() {
		day3 = null;
	}

	@Test
	public void shortest1() {
		String a1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
		String a2 = "U62,R66,U55,R34,D71,R55,D58,R83";

		assertEquals(610, day3.thirdTry(a1, a2), "Lowest disnatce should be 610");
	}

	@Test
	public void distance6() {
		String a1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
		String a2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";

		assertEquals(410, day3.thirdTry(a1, a2), "Lowest disnatce should be 410");
	}
}
