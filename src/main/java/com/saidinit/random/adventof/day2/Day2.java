package com.saidinit.random.adventof.day2;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day2 {

	public int[] gravity(int[] input) {

		for (int i = 0; i < input.length; i += 4) {

			int operation = input[i];
			int op1;
			int op2;
			int pos;

			switch (operation) {
			case 1: // we sum
				op1 = input[input[i + 1]];
				op2 = input[input[i + 2]];
				pos = input[i + 3];
				input[pos] = op1 + op2;
				break;
			case 2: // we multiply
				op1 = input[input[i + 1]];
				op2 = input[input[i + 2]];
				pos = input[i + 3];
				input[pos] = op1 * op2;
				break;
			case 99: // we finish
				return input;
			default: // something went wrong;
				System.err.println("1202 program alarm (your computer will burrsts into flames)");
				break;
			}
		}
		System.err.println("1202 program alarm (your computer will burrsts into flames)");
		return input;
	}

	public int restore() {

		int[] input = ReadInput.getDay2Input();
		input[1] = 12;
		input[2] = 2;

		return gravity(input)[0];
	}
}
