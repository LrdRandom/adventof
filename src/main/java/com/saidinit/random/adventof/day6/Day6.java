package com.saidinit.random.adventof.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.saidinit.random.adventof.utils.ReadInput;

public class Day6 {

	Map<String, Planet> planets = new HashMap<>();
	List<Planet> fromYouToCom = new ArrayList<>();
	List<Planet> fromSanToCom = new ArrayList<>();

	// this is going to be with java trees right? god I hate trees...
	// not doing it with trees, fuck it
	private void loadTree() {
		List<String> data = ReadInput.getDay6Input();

		data.forEach(s -> {
			Planet p1 = new Planet();
			p1.setName(s.split("\\)")[0]);
			planets.put(p1.getName(), p1);
			Planet p2 = new Planet();
			p2.setName(s.split("\\)")[1]);
			planets.put(p2.getName(), p2);
		});

		data.forEach(s -> {
			String planetOrbits = s.split("\\)")[0];
			String planetName = s.split("\\)")[1];
			Planet planet = planets.get(planetName);
			Planet orbits = planets.get(planetOrbits);
			planet.setOrbit(orbits);
			orbits.getSat().add(planet);
		});
	}

	public void countSatelliteAndOrbits() {
		loadTree();
		int totalOrbits = 0;
		int totalSatellite = 0;

		for (Map.Entry<String, Planet> entry : planets.entrySet()) {
			Planet p = planets.get(entry.getKey());
			totalOrbits += p.getOrbitCount();
			totalSatellite += p.getSatCount();
		}

		System.out.println("orbits: " + totalOrbits); // this is the right
														// answer
		System.out.println("satellite: " + totalSatellite);
	}

	public void findSanta() {
		// this doesnt work
		/*
		 * Set<Integer> jumps = new HashSet<>(); Set<String> searchedPlanets =
		 * new HashSet<>(); Planet you = planets.get("YOU"); int jump =
		 * you.searchElement(0, "SAN", jumps,
		 * searchedPlanets).stream().sorted().findFirst().get();
		 * 
		 * System.out.println("number of jumps " + jump);
		 */

		// new plan, the latest intersection between the travel from YOU to CON
		// and from
		// SAN to CON
		// will be the quickest way to connect each other (I hope).
		// we get a list of planets from YOU to CON and from SAN to CON (we know
		// YOU has
		// no satellites)
		// we get the latest intersection on each, we count what is remaining
		// we also know SAN doesn't have any satellites
		/*
		 * Planet san = planets.get("SAN"); Planet you = planets.get("YOU");
		 * List<Planet> lp1 = new ArrayList<>(); lp1.add(san); List<Planet> lp2
		 * = new ArrayList<>(); lp2.add(you);
		 * 
		 * Integer jumps = something(lp1, lp2, 0);
		 * System.out.println("Number of jumps: " + jumps); Set<String> allJumps
		 * = new HashSet<>(); for (int i = 0; i < lp1.size(); i++) {
		 * allJumps.add(lp1.get(i).getName()); }
		 * 
		 * lp1.clear(); for (int i = 0; i < lp2.size(); i++) {
		 * allJumps.add(lp2.get(i).getName()); }
		 * 
		 * lp2.clear(); allJumps.remove("SAN"); allJumps.remove("YOU");
		 * allJumps.forEach(p -> System.out.println(p));
		 * System.out.println(allJumps.size() - 1);
		 */
		// 394 was too high, weird. (also 393, just in case I missed on less
		// someway)
		/*
		 * loadFromSanToCom(); loadFromYouToCom(); fromYouToCom.forEach(p ->
		 * System.out.println(p.getName())); fromSanToCom.forEach(p ->
		 * System.out.println(p.getName()));
		 */

		somethingelse();
	}

	private void somethingelse() {
		Planet san = planets.get("SAN");
		Planet you = planets.get("YOU");
		String nextPlanet;
		List<String> pathSanToCom = new ArrayList<>();
		List<String> pathYouToCom = new ArrayList<>();
		System.out.println("Planets from SAN to COM:");
		nextPlanet = san.getOrbit().getName();
		do {

			nextPlanet = planets.get(nextPlanet).getOrbit().getName();
			// System.out.print(nextPlanet + "-");
			pathSanToCom.add(nextPlanet);
		} while (!nextPlanet.equals("COM"));

		System.out.println("\nPlanets from YOU to COM:");
		nextPlanet = you.getOrbit().getName();
		do {
			nextPlanet = planets.get(nextPlanet).getOrbit().getName();
			// System.out.print(nextPlanet + "-");
			pathYouToCom.add(nextPlanet);
		} while (!nextPlanet.equals("COM"));

		int jumps = 0;
		for (int i = 0; i < pathSanToCom.size(); i++) {
			String pl = pathSanToCom.get(i);
			if (pathYouToCom.contains(pl)) {
				jumps += i;
				break;
			}
		}
		System.out.println("jumps: " + jumps);
		for (int i = 0; i < pathYouToCom.size(); i++) {
			String pl = pathYouToCom.get(i);
			if (pathSanToCom.contains(pl)) {
				jumps += i;
				break;
			}
		}
		System.out.println("jumps: " + jumps); // 350 nope

	}

	private int something(List<Planet> lp1, List<Planet> lp2, Integer jumps) {
		boolean found = false;
		for (int i = 0; i < lp1.size(); i++) {
			if (lp2.contains(lp1.get(i))) {
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Not found, going to the next level: " + jumps);
			// get the last planets orbit, add them to the arrays

			Planet p1 = lp1.get(lp1.size() - 1);
			Planet p2 = lp2.get(lp2.size() - 1);
			lp1.add(p1.getOrbit());
			lp2.add(p2.getOrbit());
			jumps += 1;
			something(lp1, lp2, jumps);
		}
		if (found) {
			// lp1.forEach(p -> System.out.println(p.getName()));
			// lp2.forEach(p -> System.out.println(p.getName()));

		}
		return jumps;
	}

	/*
	 * private List<Planet> loadFromYouToCom() { Planet you =
	 * planets.get("YOU"); Planet orbit = you.getOrbit(); while
	 * (!orbit.getName().equals("COM")) { fromYouToCom.add(you);
	 * loadFromYouToCom(); } fromYouToCom.add(you); return fromSanToCom; }
	 * 
	 * private List<Planet> loadFromSanToCom() { Planet you =
	 * planets.get("SAN"); Planet orbit = you.getOrbit(); while
	 * (!orbit.getName().equals("COM")) { fromSanToCom.add(you);
	 * loadFromSanToCom(); } fromSanToCom.add(you); return fromSanToCom; }
	 */

}
