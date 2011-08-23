package de.congrace.solar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.congrace.solar.math.Vector2D;
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

	Vector2D getForceVector(Planet p) {
		double scalar = (Constants.GRAVITATIONAL_CONSTANT * p.getMass() * sun.getMass());
		double distance = sun.getPosition().copy().subtract(p.getPosition()).getMagnitude();
		Vector2D force = sun.getPosition().copy();
		force.subtract(p.getPosition());
		force.scale(1/distance);
		return force.scale(scalar/Math.pow(distance,2));
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
