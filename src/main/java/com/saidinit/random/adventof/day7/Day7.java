package com.saidinit.random.adventof.day7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day7 {

	private Intcode ampA;
	private Intcode ampB;
	private Intcode ampC;
	private Intcode ampD;
	private Intcode ampE;

	static final int[] arrayAmpA = ReadInput.getDay7Input();
	static final int[] arrayAmpB = ReadInput.getDay7Input();
	static final int[] arrayAmpC = ReadInput.getDay7Input();
	static final int[] arrayAmpD = ReadInput.getDay7Input();
	static final int[] arrayAmpE = ReadInput.getDay7Input();

	public int startThrusters() {

		Map<Integer, String> max = new HashMap<>();

		for (int i = 0; i < 5; i++) {
			ampA = new Intcode();
			ampA.setArray(ReadInput.getDay7Input());
			ampA.setPhase(i);
			ampA.setSignal(0);
			int resultA = ampA.runTheTest();

			for (int j = 0; j < 5; j++) {
				ampB = new Intcode();
				ampB.setArray(ampA.getArray());
				ampB.setPhase(j);
				ampB.setSignal(resultA);
				int resultB = ampB.runTheTest();

				for (int k = 0; k < 5; k++) {
					ampC = new Intcode();
					ampC.setArray(ampB.getArray());
					ampC.setPhase(k);
					ampC.setSignal(resultB);
					int resultC = ampC.runTheTest();

					for (int m = 0; m < 5; m++) {
						ampD = new Intcode();
						ampD.setArray(ampC.getArray());
						ampD.setPhase(m);
						ampD.setSignal(resultC);
						int resultD = ampD.runTheTest();

						for (int n = 0; n < 5; n++) {
							ampE = new Intcode();
							ampE.setArray(ampD.getArray());
							ampE.setPhase(n);
							ampE.setSignal(resultD);

							int resultE = ampE.runTheTest();
							String s = resultE + " result for thrusters, using amp: " + i + ", " + j + ", " + k + ", "
									+ m + ", " + n;
							System.out.println("Thruster coded: " + s);
							max.put(resultE, s);

						}
					}

				}

			}
		}
		int maxReal = Integer.MIN_VALUE;
		for (Map.Entry<Integer, String> entry : max.entrySet()) {
			int maxOpt = entry.getKey();
			if (maxOpt > maxReal) {
				maxReal = maxOpt;
			}

		}
		System.out.println("The value of the thrusters is: " + maxReal + " for amps: " + max.get(maxReal));
		return maxReal;
	}

	public int someTest(int[] array) {
		final int[] auxArrayAmpA = array;
		final int[] auxArrayAmpB = array;
		final int[] auxArrayAmpC = array;
		final int[] auxArrayAmpD = array;
		final int[] auxArrayAmpE = array;

		Map<Integer, String> max = new HashMap<>();

		for (int i = 0; i < 5; i++) {
			ampA = new Intcode();
			ampA.setArray(auxArrayAmpA);
			ampA.setOutput(i);
			ampA.runTheTest();
			ampA.setOutput(0);
			int resultA = ampA.runTheTest();

			for (int j = 0; j < 5; j++) {
				ampB = new Intcode();
				ampB.setArray(auxArrayAmpB);
				ampB.setOutput(j);
				ampB.runTheTest();
				ampB.setOutput(resultA);
				int resultB = ampB.runTheTest();

				for (int k = 0; k < 5; k++) {
					ampC = new Intcode();
					ampC.setArray(auxArrayAmpC);
					ampC.setOutput(k);
					ampC.runTheTest();
					ampC.setOutput(resultB);
					int resultC = ampC.runTheTest();

					for (int m = 0; m < 5; m++) {
						ampD = new Intcode();
						ampD.setArray(auxArrayAmpD);
						ampD.setOutput(m);
						ampD.runTheTest();
						ampD.setOutput(resultC);
						int resultD = ampD.runTheTest();

						for (int n = 0; n < 5; n++) {
							ampE = new Intcode();
							ampE.setArray(auxArrayAmpE);
							ampE.setOutput(n);
							ampE.runTheTest();
							ampE.setOutput(resultD);

							int resultE = ampE.runTheTest();
							String s = resultE + " result for thrusters, using amp: " + i + ", " + j + ", " + k + ", "
									+ m + ", " + n;
							System.out.println("Thruster coded: " + s);
							max.put(resultE, s);

						}
					}

				}

			}
		}
		int maxReal = Integer.MIN_VALUE;
		for (Map.Entry<Integer, String> entry : max.entrySet()) {
			int maxOpt = entry.getKey();
			if (maxOpt > maxReal) {
				maxReal = maxOpt;
			}

		}
		System.out.println("The value of the thrusters is: " + maxReal + " for amps: " + max.get(maxReal));
		return maxReal;
	}

	// test libraries are not working WTF
	public void thrustersTest1() {
		String auxArray = "3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0";
		int[] array = transformArray(auxArray);
		int res = this.someTest(array);

		assertEquals(43210, res, "The result should be 43210");
	}

	public void thrustersTest2() {
		String auxArray = "3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0";
		int[] array = transformArray(auxArray);
		int res = this.someTest(array);

		assertEquals(54321, res, "The result should be 54321");
	}

	public void thrustersTest3() {
		String auxArray = "3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0";
		int[] array = transformArray(auxArray);
		int res = this.someTest(array);

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
