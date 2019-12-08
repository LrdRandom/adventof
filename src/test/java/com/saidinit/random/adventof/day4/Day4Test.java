package com.saidinit.random.adventof.day4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day4Test {
	private Day4 day4;

	@BeforeEach
	public void setUp() {
		day4 = new Day4();
	}

	@AfterEach
	public void tearDown() {
		day4 = null;
	}

	@Test
	public void testSome() {
		assertTrue(day4.proveRightOtherThanRange("111111"), "111111 should be true");
		assertFalse(day4.proveRightOtherThanRange("223450"), "223450 should be false");
		assertFalse(day4.proveRightOtherThanRange("123789"), "123789 should be false");
	}
}
