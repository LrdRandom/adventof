package com.saidinit.random.adventof.day5;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day5 {

	private static final int SUM = 1;
	private static final int MUL = 2;
	private static final int INPUT = 3;
	private static final int OUTPUT = 4;
	private static final int HALT = 99;

	private int cursor = 0;
	private int output = 1; // the first instruction is 1

	private void sum(int[] array, int modeOp1, int modeOp2, int modePos) {
		int operator1 = 0;
		int operator2 = 0;
		int position = 0;
		if (modeOp1 == 0) {
			operator1 = array[array[cursor + 1]];
		} else {
			operator1 = array[cursor + 1];
		}
		if (modeOp2 == 0) {
			operator2 = array[array[cursor + 2]];
		} else {
			operator2 = array[cursor + 2];
		}
		if (modePos == 0) {
			position = array[cursor + 3];
		} else {
			position = array[cursor + 3];
		}
		cursor += 4;
		array[position] = operator1 + operator2;
	}

	private void mul(int[] array, int modeOp1, int modeOp2, int modePos) {
		int operator1 = 0;
		int operator2 = 0;
		int position = 0;
		if (modeOp1 == 0) {
			operator1 = array[array[cursor + 1]];
		} else {
			operator1 = array[cursor + 1];
		}
		if (modeOp2 == 0) {
			operator2 = array[array[cursor + 2]];
		} else {
			operator2 = array[cursor + 2];
		}
		if (modePos == 0) {
			position = array[cursor + 3];
		} else {
			position = array[cursor + 3];
		}
		cursor += 4;
		array[position] = operator1 * operator2;
	}

	private void input(int[] array, int modePos, int input) {
		int position = 0;
		if (modePos == 0) {
			position = array[cursor + 1];
		} else {
			position = array[cursor + 1];
		}
		cursor += 2;
		array[position] = input;
	}

	private int output(int[] array, int modePos) {
		int position = 0;
		if (modePos == 0) {
			position = array[cursor + 1];
			cursor += 2;
			return array[position];
		} else {
			cursor += 2; // since we have to plus it here, insetad of cursor +1 next, it will be -1
			return array[cursor - 1];
		}

	}

	public void runTheTest() {
		int[] array = ReadInput.getDay5Input();
		for (int i = 0; cursor < array.length; i++) {
			// System.out.println("Number of instructions processed: " + i);
			String inst = String.format("%05d", array[cursor]);

			int opcode = Integer.parseInt(inst.substring(3));
			// System.out.println("We are processing a..." + opcode);
			if (opcode == SUM) {
				sum(array, Integer.parseInt(inst.substring(2, 3)), Integer.parseInt(inst.substring(1, 2)),
						Integer.parseInt(inst.substring(0, 1)));
				continue;
			} else if (opcode == MUL) {
				mul(array, Integer.parseInt(inst.substring(2, 3)), Integer.parseInt(inst.substring(1, 2)),
						Integer.parseInt(inst.substring(0, 1)));
				continue;
			} else if (opcode == INPUT) {
				input(array, Integer.parseInt(inst.substring(2, 3)), output);
				continue;
			} else if (opcode == OUTPUT) {
				output = output(array, Integer.parseInt(inst.substring(2, 3)));
				System.out.println("An output ocurred: " + output + " (should be 0, otherwise you have an error)");
				continue;
			} else if (opcode == HALT) {
				break;
			}
			System.err.println(
					"An instruction we do not understand (" + opcode + "), your computer will now catch fire!");
		}
	}

}
