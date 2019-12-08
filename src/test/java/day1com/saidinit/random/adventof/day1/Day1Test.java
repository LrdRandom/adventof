package day1com.saidinit.random.adventof.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.saidinit.random.adventof.day1.Day1;

public class Day1Test {

	private Day1 day1;

	@BeforeEach
	public void setUp() {
		day1 = new Day1();
	}

	@AfterEach
	public void tearDown() {
		day1 = null;
	}

	@Test
	public void testFuel() {
		assertEquals(2, day1.calculateFuel(12), "Mass of 12 should return 2");
		assertEquals(2, day1.calculateFuel(14), "Mass of 14 should return 2");
		assertEquals(654, day1.calculateFuel(1969), "Mass of 1969 should return 654");
		assertEquals(33583, day1.calculateFuel(100756), "Mass of 100756 should return 33583");
	}
}
