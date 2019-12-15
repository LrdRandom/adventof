package com.saidinit.random.adventof.day8;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day8 {
	// 25 pixels wide and 6 pixels tall

	// int[][] picture = new int[6][25]; // 150 ints per picture

	public int isItCorrupted() {

		List<Integer[][]> pictures = new ArrayList<>();

		String input = ReadInput.getDay8Input().get(0);

		List<String> firstStep = Arrays.stream(splitByNumber(input, 150)).collect(toList());

		for (int k = 0; k < 100; k++) {
			Integer[][] picture = new Integer[6][25];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 25; j++) {
					int index = j + (i * 25);
					// System.out.println(index);
					Character c = (firstStep.get(k).charAt(index));
					picture[i][j] = Integer.valueOf(c.toString());
				}
			}
			pictures.add(picture);
		}

		int noOfZeros2 = Integer.MAX_VALUE;
		int maybeSolution2 = 0;
		for (int i = 0; i < 100; i++) {
			System.out.println("Picture of: " + i);
			Integer[][] picture = pictures.get(i);
			int auxZeros = countNumOfZeros(picture);
			System.out.println("No of Zeros: " + auxZeros);
			if (auxZeros <= noOfZeros2) {
				noOfZeros2 = auxZeros;
				maybeSolution2 = solution(picture);
				System.out.println("The solution: " + maybeSolution2);
			}

			printLayer(picture);
		}

		System.out.println("Solution: " + maybeSolution2);

		/* ----- new try ---- */

		List<Character> splitted = new ArrayList<>();
		for (char c : input.toCharArray()) {
			splitted.add(c);
		}

		System.out.println("length: " + splitted.size());
		System.out.println("no of images: " + splitted.size() / 150);

		// there are 100 pictures

		// load all pictures
		for (int i = 0; i < 100; i++) {
			Integer[][] aux = new Integer[6][25];
			String onePic = input.substring(i * 150, i * 150 + 150);
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 25; k++) {
					Character c = onePic.charAt(j * k);
					aux[j][k] = Integer.valueOf(c.toString());
				}
			}
			pictures.add(aux);
		}

		int noOfZeros = Integer.MAX_VALUE;
		int maybeSolution = 0;
		for (int i = 0; i < 100; i++) {
			System.out.println("Picture of: " + i);
			Integer[][] picture = pictures.get(i);
			int auxZeros = countNumOfZeros(picture);
			System.out.println("No of Zeros: " + auxZeros);
			if (auxZeros <= noOfZeros) {
				noOfZeros = auxZeros;
				maybeSolution = solution(picture);
				System.out.println("The solution: " + maybeSolution);
			}

			printLayer(picture);
		}

		System.out.println("Solution: " + maybeSolution);
		return maybeSolution;
	}

	private void printLayer(Integer[][] picture) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 25; j++) {
				System.out.print(picture[i][j]);
			}
			System.out.print("\n");
		}
	}

	private int countNumOfZeros(Integer[][] picture) {
		int cont = 0;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 25; j++) {
				if (picture[i][j] == 0) {
					cont++;
				}
			}
		}
		return cont;
	}

	private int solution(Integer[][] picture) {
		int noOfOnes = 0;
		int noOftwos = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 25; j++) {
				if (picture[i][j] == 1) {
					noOfOnes++;
				} else if (picture[i][j] == 2) {
					noOftwos++;
				}
			}
		}
		System.out.println("no of ones: " + noOfOnes);
		System.out.println("no of twos: " + noOftwos);
		return noOfOnes * noOftwos;
	}

	private static String[] splitByNumber(String text, int number) {

		int inLength = text.length();
		int arLength = inLength / number;
		int left = inLength % number;
		if (left > 0) {
			++arLength;
		}
		String ar[] = new String[arLength];
		String tempText = text;
		for (int x = 0; x < arLength; ++x) {

			if (tempText.length() > number) {
				ar[x] = tempText.substring(0, number);
				tempText = tempText.substring(number);
			} else {
				ar[x] = tempText;
			}

		}

		return ar;
	}

}
