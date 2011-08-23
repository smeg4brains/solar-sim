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

	public void subtract(Vector2D v) {
		this.x = x - v.x;
		this.y = y - v.y;
	}

	public void add(Vector2D v) {
		this.x = x + v.x;
		this.y = y + v.y;
	}

	public void scale(double factor) {
		x = x * factor;
		y = y * factor;
	}

	public double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}
}
