package com.saidinit.random.adventof.day2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day2Part2Test {

	private static final int MAGIC_NUMBER = 19690720;
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
	public void findTheMagicNumber() {
		boolean found = false;
		int[] input = ReadInput.getDay2Input();
		for (int i = 0; i < 100; i++) {
			if (found) {
				break;
			}
			for (int j = 0; j < 100; j++) {
				int[] inputAux = Arrays.copyOf(input, input.length);
				inputAux[1] = i;
				inputAux[2] = j;
				int result = day2.gravity(inputAux)[0];
				if (result == MAGIC_NUMBER) {
					found = true;
					System.out.println((100 * i) + j);
					break;
				}
			}
		}
		assertTrue(found);
	}

}
