package com.saidinit.random.adventof.day4;

public class Day4 {

	private static final String PUZZLE_INPUT = "272091-815432";

	// I know, I can solve this with regex
	// and then I can have TWO problems

	private boolean isSixDigit(String underTest) {
		String regex = "^[0-9]{1,6}$";
		return underTest.matches(regex);
	}

	private boolean isWithinRange(String underTest) {
		int min = Integer.valueOf(PUZZLE_INPUT.split("-")[0]);
		int max = Integer.valueOf(PUZZLE_INPUT.split("-")[1]);

		int test = Integer.parseInt(underTest);
		if (test < min || test > max) {
			return false;
		}
		return true;
	}

	private boolean hasTwoAdjacentNumbersTheSame(String underTest) {
		for (int i = 1; i < underTest.length(); i++) {
			char c0 = underTest.charAt(i - 1);
			char c1 = underTest.charAt(i);

			if (c0 == c1) {
				return true;
			}
		}
		return false;
	}

	private boolean digitsAlwaysIncrease(String underTest) {
		for (int i = 1; i < underTest.length(); i++) {
			int i0 = Integer.valueOf(underTest.charAt(i - 1));
			int i1 = Integer.valueOf(underTest.charAt(i));
			if (i0 > i1) {
				return false;
			}
		}
		return true;
	}

	private boolean proveRight(String underTest) {
		return isSixDigit(underTest) && isWithinRange(underTest) && hasTwoAdjacentNumbersTheSame(underTest)
				&& digitsAlwaysIncrease(underTest);
	}

	protected boolean proveRightOtherThanRange(String underTest) {
		return isSixDigit(underTest) && hasTwoAdjacentNumbersTheSame(underTest) && digitsAlwaysIncrease(underTest);
	}

	public int howManyAreOk() {
		int count = 0;
		for (int i = 272091; i <= 815432; i++) {
			if (proveRight(String.valueOf(i))) {
				count++;
				// System.out.println("The number " + i + " could be a valid pass. Total count:
				// " + count);
			}
		}

		return count;
	}

}
