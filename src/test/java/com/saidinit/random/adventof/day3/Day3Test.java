package com.saidinit.random.adventof.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Day3Test {

	private Day3 day3;

	@BeforeEach
	public void setUp() {
		day3 = new Day3();
	}

	@AfterEach
	public void tearDown() {
		day3 = null;
	}

	@Test
	public void distance8() {
		String a1 = "U1,R1";
		String a2 = "R2,D1,L1,U2";

		assertEquals(2, day3.thirdTry(a1, a2), "Lowest disnatce should be 2");
	}

	@Test
	public void distance7() {
		String a1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
		String a2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";

		assertEquals(135, day3.thirdTry(a1, a2), "Lowest disnatce should be 135");
	}

	@Test
	public void distance6() {
		String a1 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
		String a2 = "U62,R66,U55,R34,D71,R55,D58,R83";

		assertEquals(159, day3.thirdTry(a1, a2), "Lowest disnatce should be 159");
	}
	/*
	 * @Test public void distance5() { String a1 =
	 * "R75,D30,R83,U83,L12,D49,R71,U7,L72"; String a2 =
	 * "U62,R66,U55,R34,D71,R55,D58,R83";
	 * 
	 * assertEquals(159, day3.secondTry(Arrays.asList(a1.split(",")),
	 * Arrays.asList(a2.split(","))), "Lowest disnatce should be 159"); }
	 * 
	 * @Test public void distance() { String a1 =
	 * "R75,D30,R83,U83,L12,D49,R71,U7,L72"; String a2 =
	 * "U62,R66,U55,R34,D71,R55,D58,R83";
	 * 
	 * List<List<String>> route = new ArrayList<>();
	 * 
	 * List<String> routePoints1 = Arrays.asList(a1.split(",")); List<String>
	 * routePoints2 = Arrays.asList(a2.split(","));
	 * 
	 * route.add(routePoints1); route.add(routePoints2);
	 * 
	 * List<Point> points1 = day3.spatial(routePoints1); List<Point> points2 =
	 * day3.spatial(routePoints2);
	 * 
	 * List<Point> intersections = day3.compareRoute(points1, points2);
	 * 
	 * assertEquals(159, day3.lowestDistance(intersections),
	 * "Lowest disnatce should be 159"); }
	 * 
	 * @Test public void distance2() { String a1 =
	 * "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"; String a2 =
	 * "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
	 * 
	 * List<List<String>> route = new ArrayList<>();
	 * 
	 * List<String> routePoints1 = Arrays.asList(a1.split(",")); List<String>
	 * routePoints2 = Arrays.asList(a2.split(","));
	 * 
	 * route.add(routePoints1); route.add(routePoints2);
	 * 
	 * List<Point> points1 = day3.spatial(routePoints1); List<Point> points2 =
	 * day3.spatial(routePoints2);
	 * 
	 * List<Point> intersections = day3.compareRoute(points1, points2);
	 * 
	 * assertEquals(135, day3.lowestDistance(intersections),
	 * "Lowest disnatce should be 135"); }
	 * 
	 * @Test public void disnatce3() { String a1 = "U1,R1"; String a2 =
	 * "R2,D1,L1,U2";
	 * 
	 * List<List<String>> route = new ArrayList<>();
	 * 
	 * List<String> routePoints1 = Arrays.asList(a1.split(",")); List<String>
	 * routePoints2 = Arrays.asList(a2.split(","));
	 * 
	 * route.add(routePoints1); route.add(routePoints2);
	 * 
	 * List<Point> points1 = day3.spatial(routePoints1); List<Point> points2 =
	 * day3.spatial(routePoints2);
	 * 
	 * List<Point> intersections = day3.compareRoute(points1, points2);
	 * 
	 * assertEquals(2, day3.lowestDistance(intersections),
	 * "Lowest disnatce should be 2"); }
	 */
}
