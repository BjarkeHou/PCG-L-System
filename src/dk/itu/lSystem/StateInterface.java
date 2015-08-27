package dk.itu.lSystem;

import dk.itu.lSystem.util.CanvasInterface;

public interface StateInterface {

	public abstract double getX();

//	public abstract double getLength();

	public abstract double getAngle();

	public abstract double getY();

	/**
	 * draw the current state
	 * @param c
	 * @param xp draw from x state position to xp
	 * @param yp draw from y state position to yp
	 */
	public abstract void draw(CanvasInterface c, double xp, double yp);

//	public abstract double getTurningAngle();

//	public abstract String print();

}