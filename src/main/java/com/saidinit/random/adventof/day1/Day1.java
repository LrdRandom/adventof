package com.saidinit.random.adventof.day1;

import java.util.stream.Collectors;

public class Day1 {
	/**
	 * At the first Go / No Go poll, every Elf is Go until the Fuel Counter-Upper.
	 * They haven't determined the amount of fuel required yet.
	 */

	/**
	 * Fuel required to launch a given module is based on its mass. Specifically, to
	 * find the fuel required for a module, take its mass, divide by three, round
	 * down, and subtract 2.
	 */

	/**
	 * The Fuel Counter-Upper needs to know the total fuel requirement. To find it,
	 * individually calculate the fuel needed for the mass of each module (your
	 * puzzle input), then add together all the fuel values.
	 */

	protected int getFuel() {

		return ReadInput.getLines().stream().map(l -> calculateFuel(Integer.valueOf(l))).collect(Collectors.toList())
				.stream().mapToInt(Integer::intValue).sum();
	}

	protected Integer calculateFuel(int mass) {

		return (mass / 3) - 2;

	}
}
