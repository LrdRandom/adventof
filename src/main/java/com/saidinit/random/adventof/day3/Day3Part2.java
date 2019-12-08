package com.saidinit.random.adventof.day3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day3Part2 {
	public int solve() {

		List<String> input = ReadInput.getDay3Input2();

		return thirdTry(input.get(0), input.get(1));
	}

	private static int[] getDir(char c) {
		switch (c) {
		case 'U':
			return new int[] { 0, 1 };
		case 'D':
			return new int[] { 0, -1 };
		case 'L':
			return new int[] { -1, 0 };
		case 'R':
			return new int[] { 1, 0 };
		}
		return null;
	}

	protected int thirdTry(String line1, String line2) {
		Map<String, Integer> wire = new HashMap<String, Integer>();
		String[] input = line1.split(",");

		int shortestWire = Integer.MAX_VALUE;

		int x = 0;
		int y = 0;
		int distance = 0;

		for (int i = 0; i < input.length; i++) {
			int[] dir = getDir(input[i].charAt(0));
			int len = Integer.parseInt(input[i].substring(1));
			for (int j = 0; j < len; j++) {
				int newX = x + dir[0];
				int newY = y + dir[1];
				wire.put(newX + "_" + newY, ++distance);
				x = newX;
				y = newY;
			}
		}
		input = line2.split(",");
		x = 0;
		y = 0;
		distance = 0;
		for (int i = 0; i < input.length; i++) {
			int[] dir = getDir(input[i].charAt(0));
			int len = Integer.parseInt(input[i].substring(1));
			for (int j = 0; j < len; j++) {

				int newX = x + dir[0];
				int newY = y + dir[1];
				distance++;

				if (wire.containsKey(newX + "_" + newY)) {
					shortestWire = Math.min(shortestWire, wire.get(newX + "_" + newY) + distance);
				}
				x = newX;
				y = newY;
			}
		}
		// System.out.println(shortestWire);

		return shortestWire;
	}
}
