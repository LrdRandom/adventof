package com.saidinit.random.adventof.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Planet {
	private String name;
	private Planet orbit;
	private List<Planet> sat = new ArrayList<>();

	public int getOrbitCount() {
		if (orbit != null) {
			return 1 + orbit.getOrbitCount();
		}
		return 0;
	}

	public int getSatCount() {
		if (sat.isEmpty()) {
			return 0;
		}

		return sat.size();
	}

	// this searches all orbits and satellites of those orbits, but it doesn't
	// do
	// multiple satellites down
	public Set<Integer> searchElement(int jumps, String name, Set<Integer> jumpList,
			Set<String> alreadySearchedPlanets) {
		alreadySearchedPlanets.add(getName());
		if (orbit == null) {
			return jumpList;
		} else if (alreadySearchedPlanets.contains(orbit.getName())) {
			return jumpList;
		} else if (orbit.getName().equals(name)) {
			jumpList.add(jumps);
			return jumpList;
		} else {
			searchElement(jumps + 1, name, jumpList, alreadySearchedPlanets);
		}
		for (int i = 0; i < sat.size(); i++) {
			Planet satellite = sat.get(i);
			if (satellite.getName().equals(name)) {
				jumpList.add(jumps);
				return jumpList;
			}
		}

		// so, search for extra satellites
		for (int i = 0; i < sat.size(); i++) {
			Planet satellite = sat.get(i);
			if (!alreadySearchedPlanets.contains(satellite.getName())) {
				searchElement(jumps + 1, name, jumpList, alreadySearchedPlanets);
			}
		}

		return jumpList;
	}

}
