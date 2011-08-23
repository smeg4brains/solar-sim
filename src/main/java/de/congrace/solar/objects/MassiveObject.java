package de.congrace.solar.objects;

import de.congrace.solar.math.Vector2D;

public class MassiveObject {
	protected final String name;
	protected final double mass;
	protected final double radius;
	protected Vector2D position;

	public MassiveObject(String name, Vector2D position, double mass, double radius) {
		super();
		this.name = name;
		this.mass = mass;
		this.radius = radius;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public double getMass() {
		return mass;
	}

	public double getRadius() {
		return radius;
	}

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}

}
