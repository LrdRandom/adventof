package com.saidinit.random.adventof.day4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day4Part2Test {
	private Day4Part2 day4;

	@BeforeEach
	public void setUp() {
		day4 = new Day4Part2();
	}

	@AfterEach
	public void tearDown() {
		day4 = null;
	}

	@Test
	public void testSome() {
		assertTrue(day4.proveRightOtherThanRange("112233"), "112233 should be true");
		assertFalse(day4.proveRightOtherThanRange("123444"), "123444 should be false");

	}

	@Test
	public void separateTest() {
		assertTrue(day4.proveRightOtherThanRange("111122"), "111122 should be true");
	}
}
