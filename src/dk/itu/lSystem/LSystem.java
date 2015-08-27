package dk.itu.lSystem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import dk.itu.lSystem.util.Canvas;

/**
 * The LSystem class is for implementing your own L-system that can expand
 * n number of times the axiom of the system. And visualize this expansion 
 * utilizing a turtle. 
 * 
 * @author Anders Hartzen
 *
 */
public class LSystem {
	
	/**
	 * The Axiom (i.e. start state) for the L-system.
	 */
	public String axiom;
	
	/**
	 * The production rules for the L-system.
	 */
	public Map<String,String> productionRule = new HashMap<String,String>();
		
	/**
	 *X start position for the turtle. Used for visualization.  
	 */
	public double startx = 100;
	
	/**
	 *Y start position for the turtle. Used for visualization.  
	 */
	public double starty = 200;
	
	/**
	 *Start angle for the turtle. Used for visualization.  
	 */
	public double startAngle = 0;
	
	/**
	 *The turn angle for the turtle to use when a turn symbol is processed. Used for visualization. 
	 *PI/6 is 30 degrees in radians. 
	 */
	public double turnAngle = Math.PI/6;
	
	/**
	 * Length of each step the turtle takes, when a move forward symbol is processed. Used for visualization.
	 */
	public double length = 10;
	
	/**
	 * The expand method is used to expand the axiom of the L-system n number of times.
	 * @param depth The number of times to expand the axiom.
	 */
	public void expand(int depth)
	{
		for (int i = 0; i < depth; i++) {
			String[] symbols = axiom.split("");
			axiom = "";
			for (String symbol : symbols) {
				if(productionRule.containsKey(symbol))
					axiom += productionRule.get(symbol);
				else
					axiom += symbol;
			}
		}
	}
	
	/**
	 * After expansion we need the turtle to process the expansion and move around on screen to draw our plant. 
	 * @param C The canvas to draw turtle movement on.
	 */
	public void interpret(Canvas C)
	{
		String[] symbols = axiom.split("");
		
		Stack<State> TurtleStack = new Stack<State>();
		State curState = new State(startx, starty, startAngle);
		
		for (String symbol : symbols) {
			switch (symbol) {
			case "F":
				
				double newX, newY = 0;
				newX = curState.getX()+(length*Math.cos(curState.getAngle()));
				newY = curState.getY()+(length*Math.sin(curState.getAngle()));
				curState.draw(C, newX, newY);
				curState = new State(newX, newY, curState.getAngle());
				break;

			case "+":
				curState = new State(curState.getX(), curState.getY(), curState.getAngle() + turnAngle) ;
				break;
			case "-":
				curState = new State(curState.getX(), curState.getY(), curState.getAngle() - turnAngle) ;
				break;
			case "[":
				TurtleStack.push(curState);
				break;
			case "]":
				curState = TurtleStack.pop();
				break;
			default:
				break;
			}
		}
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//C.drawLine(200, 200, 400, 400);
	}
}
