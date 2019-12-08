package com.saidinit.random.adventof.day1;

import java.util.stream.Collectors;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day1Part2 {

	/**
	 * Fuel itself requires fuel just like a module - take its mass, divide by
	 * three, round down, and subtract 2. However, that fuel also requires fuel, and
	 * that fuel requires fuel, and so on. Any mass that would require negative fuel
	 * should instead be treated as if it requires zero fuel; the remaining mass, if
	 * any, is instead handled by wishing really hard, which has no mass and is
	 * outside the scope of this calculation.
	 */

	public int getFuel() {
		return ReadInput.getDay1Input().stream().map(l -> calculateFuel(Integer.valueOf(l))).collect(Collectors.toList())
				.stream().mapToInt(Integer::intValue).sum();
	}

	protected Integer calculateFuel(int mass) {
		int fuel = (mass / 3) - 2;

		if (fuel < 1) {
			return 0;
		} else {
			return fuel + calculateFuel(fuel);
		}
	}
}
