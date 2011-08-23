package de.congrace.solar.objects;

import de.congrace.solar.math.Vector2D;

public class OrbitingObject extends MassiveObject {
	protected Vector2D velocity;

	public OrbitingObject(String name, Vector2D position, double mass, double radius) {
		super(name, position, mass, radius);
	}

	public Vector2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}
}
