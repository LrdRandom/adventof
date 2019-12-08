package com.saidinit.random.adventof.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day2Test {

	private Day2 day2;

	@BeforeEach
	public void setUp() {
		day2 = new Day2();
	}

	@AfterEach
	public void tearDown() {
		day2 = null;
	}

	@Test
	public void gravity1() {
		int[] t1 = { 2, 0, 0, 0, 99 };
		int[] t2 = { 1, 0, 0, 0, 99 };
		assertEquals(ats(t1), ats(day2.gravity(t2)), "gravity is ok");
	}

	@Test
	public void gravity2() {
		int[] t3 = { 2, 3, 0, 6, 99 };
		int[] t4 = { 2, 3, 0, 3, 99 };
		assertEquals(ats(t3), ats(day2.gravity(t4)), "gravity is ok");
	}

	@Test
	public void gravity3() {
		int[] t5 = { 2, 4, 4, 5, 99, 9801 };
		int[] t6 = { 2, 4, 4, 5, 99, 0 };
		assertEquals(ats(t5), ats(day2.gravity(t6)), "gravity is ok");
	}

	@Test
	public void gravity4() {
		int[] t7 = { 30, 1, 1, 4, 2, 5, 6, 0, 99 };
		int[] t8 = { 1, 1, 1, 4, 99, 5, 6, 0, 99 };
		assertEquals(ats(t7), ats(day2.gravity(t8)), "gravity is ok");
	}

	private String ats(int[] input) {
		System.out.println(Arrays.toString(input));
		return Arrays.toString(input);
	}
}
