package com.saidinit.random.adventof.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day7Test {

	Day7 day7;

	@BeforeEach
	public void setUp() {
		day7 = new Day7();
	}

	@AfterEach
	public void tearDown() {
		day7 = null;
	}

	@Test
	public void thrustersTest1() {
		String auxArray = "3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0";
		int[] array = transformArray(auxArray);
		int res = day7.someTest(array);

		assertEquals(43210, res, "The result should be 43210");
	}

	@Test
	public void thrustersTest2() {
		String auxArray = "3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0";
		int[] array = transformArray(auxArray);
		int res = day7.someTest(array);

		assertEquals(54321, res, "The result should be 54321");
	}

	@Test
	public void thrustersTest3() {
		String auxArray = "3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0";
		int[] array = transformArray(auxArray);
		int res = day7.someTest(array);

		assertEquals(65210, res, "The result should be 65210");
	}

	private int[] transformArray(String auxArray) {

		String[] splitted = auxArray.split(",");
		int[] result = new int[splitted.length];
		for (int i = 0; i < splitted.length; i++) {
			result[i] = Integer.parseInt(splitted[i]);
		}
		return result;
	}
}
