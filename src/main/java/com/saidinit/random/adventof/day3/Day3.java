package com.saidinit.random.adventof.day3;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day3 {

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

		int closestDistance = Integer.MAX_VALUE;

		int x = 0;
		int y = 0;
		int d = 0;

		for (int i = 0; i < input.length; i++) {
			int[] dir = getDir(input[i].charAt(0));
			int len = Integer.parseInt(input[i].substring(1));
			for (int j = 0; j < len; j++) {
				int newX = x + dir[0];
				int newY = y + dir[1];
				wire.put(newX + "_" + newY, ++d);
				x = newX;
				y = newY;
			}
		}
		input = line2.split(",");
		x = 0;
		y = 0;
		for (int i = 0; i < input.length; i++) {
			int[] dir = getDir(input[i].charAt(0));
			int len = Integer.parseInt(input[i].substring(1));
			for (int j = 0; j < len; j++) {

				int newX = x + dir[0];
				int newY = y + dir[1];

				if (wire.containsKey(newX + "_" + newY)) {
					closestDistance = Math.min(closestDistance, (int) Math.abs(newX) + (int) Math.abs(newY));
				}
				x = newX;
				y = newY;
			}
		}
		// System.out.println(closestDistance);

		return closestDistance;
	}

	protected int secondTry(List<String> line1, List<String> line2) {

		Map<String, Integer> wire = new HashMap<>();
		// List<String> readLine = ReadInput.getDay3Input().get(0);

		int closest = Integer.MAX_VALUE;
		Point p = new Point(0, 0);
		for (int i = 0; i < line1.size(); i++) {
			List<Point> points = getOneDirection(line1.get(i), p);
			for (int j = 0; j < points.size(); j++) {
				Point auxP = points.get(j);
				wire.put((int) auxP.getX() + "||" + (int) auxP.getY(), j + 1);
			}
		}

		// List<String> readLine2 = ReadInput.getDay3Input().get(1);
		p = new Point(0, 0);
		for (int i = 0; i < line2.size(); i++) {
			List<Point> points = getOneDirection(line2.get(i), p);
			for (int j = 0; j < points.size(); j++) {
				Point auxP = points.get(j);

				if (wire.containsKey((int) auxP.getX() + "||" + (int) auxP.getY())) {
					closest = Math.min(closest, (int) Math.abs(auxP.getX()) + (int) Math.abs(auxP.getY()));
				}

			}
		}

		return closest;

	}

	private List<Point> getOneDirection(String point, Point p) {
		String direction = point.substring(0, 1);
		int distnatce = Integer.parseInt(point.substring(1));
		int y = (int) p.getY();
		int x = (int) p.getX();
		List<Point> ret = new ArrayList<>();
		for (int j = 0; j < distnatce; j++) {
			switch (direction) {
			case "U":
				y++;
				break;
			case "R":
				x++;
				break;
			case "D":
				y--;
				break;
			case "L":
				x--;
				break;
			default:
				System.err.println("Terrible terrible damage!");
				break;

			}

			ret.add(new Point(x, y));
		}
		return ret;
	}

	/**
	 * Transform coordinates into spatial points
	 */
	protected List<Point> spatial(List<String> route) {
		int x = 0;
		int y = 0;
		Point p = new Point(x, y);
		List<Point> ret = new ArrayList<>();

		for (int i = 0; i < route.size(); i++) {
			ret.addAll(getOneDirection(route.get(i), p));
		}

		return ret;

	}

	/**
	 * Manhatham distance, of course.
	 */
	protected int lowestDistance(List<Point> points) {

		int minDistance = Integer.MAX_VALUE;

		for (int i = 1; i < points.size(); i++) {
			Point pos0 = points.get(i - 1);
			Point pos1 = points.get(i);

			int distance = Double.valueOf(Math.abs(pos1.getX() - pos0.getX()) + Math.abs(pos1.getY() - pos0.getY()))
					.intValue();
			if (distance < minDistance) {
				minDistance = distance;
			}

		}

		return minDistance;
	}

	/**
	 * With this we have a list of points where they intersect
	 */
	protected List<Point> compareRoute(List<Point> route1, List<Point> route2) {
		List<Point> ret = new ArrayList<>();

		for (int i = 0; i < route1.size(); i++) {
			for (int j = 0; j < route2.size(); j++) {
				if (route1.get(i).equals(route2.get(j))) {
					ret.add(route1.get(i)); // this is insane
				}
			}
		}

		return ret;
	}

}
