package math.physics;

import math.Coord;
import math.geometry.Triangle;

public class Vector {
	protected Coord head = new Coord();

	public Vector() { }

	public Vector(Coord c) {
		this.setHead(c);
	}

	public Vector clone() {
		return new Vector(this.getHead().clone());
	}

	public void add(Vector v) {
		this.head.add(v.getHead());
	}

// Head

	public void setHead(Coord c) {
		this.head = c;
	}

	public Coord getHead() {
		return this.head;
	}

	public void setX(double x) {
		this.head.setX(x);
	}

	public double getX() {
		return this.head.getX();
	}

	public void setY(double y) {
		this.head.setY(y);
	}

	public double getY() {
		return this.head.getY();
	}

// Magnitude

	public void setMagnitude(double magnitude) {
		double current = this.getMagnitude();

		if (current != 0) {
			double ratio = magnitude / current;

			this.setX(this.getX() * ratio);
			this.setY(this.getY() * ratio);
		}
	}

	public double getMagnitude() {
		return Triangle.hypotenuse(this.getX(), this.getY());
	}

// Transform

	public void scale(double scale) {
		Coord head = this.getHead();
		double x = head.getX();
		double y = head.getY();

		head.setX(x * scale);
		head.setY(y * scale);
	}
}