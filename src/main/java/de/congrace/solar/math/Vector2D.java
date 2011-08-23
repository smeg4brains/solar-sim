package de.congrace.solar.math;

public class Vector2D {
	private double x;
	private double y;

	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Vector2D subtract(Vector2D v) {
		this.x = x - v.x;
		this.y = y - v.y;
		return this;
	}

	public Vector2D add(Vector2D v) {
		this.x = x + v.x;
		this.y = y + v.y;
		return this;
	}

	public Vector2D scale(double factor) {
		x = x * factor;
		y = y * factor;
		return this;
	}

	public double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	public Vector2D copy(){
		return new Vector2D(x, y);
	}
	
	@Override
	public String toString() {
		return x + "/" + y;
	}
}
