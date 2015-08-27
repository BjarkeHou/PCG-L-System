package dk.itu.lSystem;

import dk.itu.lSystem.util.Canvas;
import dk.itu.lSystem.util.CanvasInterface;

/**
 * The State class is used to model the different states the turtle will be in while processing the 
 * expansion and moving around.
 * @author Anders Hartzen (andeshh@itu.dk)
 *
 */
public class State implements StateInterface {
	
	/**
	 * The X coordinate for the turtle in this state.
	 */
	private double x;
	/**
	 * The Y coordinate for the turtle in this state.
	 */
	private double y;
	/**
	 * The angle of the turtle in this state.
	 */
	private double angle;
//	/**
//	 * The step length of the turtle in this state.
//	 */
//	private double length;
//	/**
//	 * The turning angle of the turtle in this state.
//	 */
//	private double turningAngle;
	
	public State(double x, double y, double startAngle) {
		this.x = x;
		this.y = y;
		this.angle = startAngle;
//		this.length = lenght;
//		this.turningAngle = turningAngle;
	}

	/* (non-Javadoc)
	 * @see dk.itu.lSystem.StateInterface#State()
	 */
	public void State(){
		
	}

	/* (non-Javadoc)
	 * @see dk.itu.lSystem.StateInterface#getX()
	 */
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

//	/* (non-Javadoc)
//	 * @see dk.itu.lSystem.StateInterface#getLength()
//	 */
//	public double getLength() {
//		// TODO Auto-generated method stub
//		return length;
//	}

	/* (non-Javadoc)
	 * @see dk.itu.lSystem.StateInterface#getAngle()
	 */
	public double getAngle() {
		// TODO Auto-generated method stub
		return angle;
	}

	/* (non-Javadoc)
	 * @see dk.itu.lSystem.StateInterface#getY()
	 */
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
	/**
	 * This method visualizes the state by drawing a line from the turtle's position
	 * to another point passed as parameters xp and yp to the method. 
	 * @param c Canvas to draw on.
	 * @param xp X coordinate of where we want the line to end.
	 * @param yp Y coordiante of where we want the line to end.
	 */
	public void draw(CanvasInterface c, double xp, double yp) {
		c.drawLine((int)x , (int) y, (int)xp, (int)yp);		
	}

//	/* (non-Javadoc)
//	 * @see dk.itu.lSystem.StateInterface#getTurningAngle()
//	 */
//	public double getTurningAngle() {
//		// TODO Auto-generated method stub
//		return turningAngle;
//	}

//	/* (non-Javadoc)
//	 * @see dk.itu.lSystem.StateInterface#print()
//	 */
//	public String print() {
//		// TODO Auto-generated method stub
//		return "x = " +x +" y = "+y+" d = "+length+" a = "+angle;
//	}
	
	
}
