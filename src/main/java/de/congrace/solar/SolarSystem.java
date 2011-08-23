package de.congrace.solar;

import java.util.ArrayList;
import java.util.List;

import de.congrace.solar.objects.Planet;
import de.congrace.solar.objects.Sun;

class SolarSystem {
	private final String name;
	private final List<Planet> planets;
	private final Sun sun;

	private SolarSystem(Builder b) {
		this.name = b.name;
		this.planets = b.planets;
		this.sun = b.sun;
	}

	List<Planet> getPlanets() {
		return planets;
	}

	Sun getSun() {
		return sun;
	}

	String getName() {
		return name;
	}

	public static class Builder {
		private final List<Planet> planets = new ArrayList<Planet>();
		private final String name;

		private Sun sun;

		public Builder(String name) {
			this.name = name;
		}

		public Builder withSun(Sun s) {
			sun = s;
			return this;
		}

		public Builder withPlanet(Planet p) {
			planets.add(p);
			return this;
		}

		public SolarSystem build() {
			return new SolarSystem(this);
		}

	}
}
