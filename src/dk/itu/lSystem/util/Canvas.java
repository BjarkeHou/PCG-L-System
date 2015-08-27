package dk.itu.lSystem.util;

/**
 * Class Canvas - a class to allow for simple graphical 
 * drawing on a canvas.
 * 
 * @author: Bruce Quig
 * date: 03-09-1999
 * 
 * Small modifications by Anders Hartzen
 * date: 19-09-2012
 */

import javax.swing.*;

import dk.itu.lSystem.LSystem;
//import dk.itu.lSystem.LSystemAndershh;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Canvas implements CanvasInterface
{
    // instance variables - replace the example below with your own
    private JFrame display;
    public JPanel canvas;
    private Graphics2D graphic;
    private Color backgroundColour;
    
    /**
     * WaitTime is used to stop the main thread momentarily each time 
     * the DrawLine method is called to avoid a graphics bug.
     * Without doing this nothing is shown on screen.
     * 
     */
    public int waitTime = 50; //milliseconds
  

    /**
     * Constructor for objects of class DisplayCanvas
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     * @param bgClour  the desired background clour of the canvas
     */
    public Canvas(String title, int width, int height, Color bgColour)
    {
        display = new JFrame();
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = (JPanel)display.getContentPane();
//        JTextArea t = new JTextArea();
//        t.setSize(new Dimension(50,50));
//        t.setPreferredSize(new Dimension(50,50));
//        display.setLayout(new BorderLayout()); 
//        display.add(t);
//        canvas = new JPanel();
//        canvas.setBackground(Color.WHITE);
//        display.add(canvas);
        display.setTitle(title);
        display.setSize(width, height);
        canvas.setBackground(bgColour);
        backgroundColour = bgColour;
    }

    /**
     * Constructor for objects of class DisplayCanvas with default 
     * height, width and background colour (600, 600, white).
     * @param title  title to appear in Canvas Frame     
     */
    public Canvas(String title)
    {
        this(title, 600, 400, Color.white);        
    }

    /**
     * Constructor for objects of class DisplayCanvas with a default 
     * background colour (white).
     * @param title  title to appear in Canvas Frame
     * @param width  the desired width for the canvas
     * @param height  the desired height for the canvas
     */
    public Canvas(String title, int width, int height)
    {
        this(title, width, height, Color.white);
    }

    /**
     * Sets the canvas visibility and brings canvas to the front of screen
     * when made visible. This method can also be used to bring an already
     * visible canvas to the front of other windows.
     * 
     * @param visible  boolean value representing the desired visibility of
     * the canvas (true or false) 
     */
    public void setVisible(boolean visible)
    {
        display.setVisible(visible);
        if(graphic == null)
            graphic = (Graphics2D)canvas.getGraphics();
    }

   /**
     * provides information on visibility of the Canvas
     * 
     * @return  boolean value representing the visibility of
     * the canvas (true or false) 
     */
    public boolean isVisible()
    {
        return display.isVisible();
    }

    /**
     * draws a given shape onto the canvas
     * 
     * @param  shape  the shape object to be drawn on the canvas
     */
    public void draw(Shape shape)
    {
        graphic.draw(shape);
    }
 
    /**
     * fills the internal dimensions of a given shape
     * with the current foreground colour of the canvas.
     * 
     * @param  shape  the shape object to be filled 
     */
    public void fill(Shape shape)
    {
        graphic.fill(shape);
    }

    /**
     * erases a given shape on the screen
     * @param  shape  the shape object to be erased 
     */
    public void erase(Shape shape)
    {
        // keep track of the current colour
        Color original = graphic.getColor();
        // set colour to that of the canvas background
        graphic.setColor(backgroundColour);
        // fill shape again using background colour
        graphic.fill(shape);
        // revert graphic object back to original foreground colour
        graphic.setColor(original);
    }

    /**
     * draws an image onto the canvas
     * 
     * @param  image   the Image object to be displayed 
     * @param  x   x co-ordinate for Image placement 
     * @param  y   y co-ordinate for Image placement 
     * @return  returns boolean value representing whether 
     * the image was completely loaded 
     */
    public boolean drawImage(Image image, int x, int y)
    {
        return graphic.drawImage(image, x, y, null);
    }

    /**
     * draws a String on the Canvas
     * 
     * @param  text   the String to be displayed 
     * @param  x   x co-ordinate for text placement 
     * @param  y   y co-ordinate for text placement
     */
    public void drawString(String text, int x, int y)
    {
        graphic.drawString(text, x, y);   
    }

    /**
     * erases a String on the Canvas by rewriting the same String
     * using the background colour as the colour of the String.
     * 
     * @param  text   the String to be displayed 
     * @param  x   x co-ordinate for text placement 
     * @param  y   y co-ordinate for text placement
     */
    public void eraseString(String text, int x, int y)
    {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        graphic.drawString(text, x, y);   
        graphic.setColor(original);
    }

    /**
     * Draws a straight line on the Canvas
     * 
     * @param  x1   x co-ordinate of start of line 
     * @param  y1   y co-ordinate of start of line 
     * @param  x2   x co-ordinate of end of line 
     * @param  y2   y co-ordinate of end of line 
     */
    public void drawLine(int x1, int y1, int x2, int y2)
    {
        y1 = getInvertedPos(y1);
        y2 = getInvertedPos(y2);
    	graphic.drawLine(x1, y1, x2, y2);
    	wait(this.waitTime);
    }

    private int getInvertedPos(int y) {
		return display.getHeight() - y;
	}

	/**
     * sets the foreground colour of the Canvas
     * 
     * @param  newColour   the new colour for the foreground of the Canvas 
     */
    public void setForegroundColour(Color newColour)
    {
        graphic.setColor(newColour);
    }

    /**
     * returns the current colour of the foreground
     * 
     * @return   the colour of the foreground of the Canvas 
     */
    public Color getForegroundColour()
    {
        return graphic.getColor();
    }

    /**
     * sets the background colour of the Canvas
     * 
     * @param  newColour   the new colour for the background of the Canvas 
     */
    public void setBackgroundColour(Color newColour)
    {
        backgroundColour = newColour;   
        graphic.setBackground(newColour);
    }

    /**
     * returns the current colour of the background
     * 
     * @return   the colour of the background of the Canvas 
     */
    public Color getBackgroundColour()
    {
        return backgroundColour;
    }

    /**
     * Changes the current Font used on the Canvas
     * 
     * @param  y   a sample parameter for a method 
     * @return     the sum of x and y 
     **/
    public void setFont(Font newFont)
    {
        graphic.setFont(newFont);
    }

    public Font getFont()
    {
        return graphic.getFont();
    }

    /**
     * sets the size of the canvas display
     * 
     * @param  width   new width 
     * @param  height   new height 
     */
    public void setSize(int width, int height)
    {
        display.setSize(width, height);
    }

    /**
     * Waits for a specified number of milliseconds before finishing.
     * This provides an easy way to specify a small delay which can be
     * used when producing animations.
     * @param  milliseconds  the number 
     **/
    public void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }
    
    /**
     * The main method - use this to run your L-system.
     * @param args
     */
    public static void main(String[] args){
    	Canvas c = new Canvas("");
    	c.setVisible(true);
    	
    	LSystem lSystem = new LSystem();
    	lSystem.axiom = "F";
    	lSystem.productionRule.put("F", "F[-F]F[+F][F]");
    	lSystem.expand(5);
    	lSystem.interpret(c.getInstance());
    }

	@Override
	public Canvas getInstance() {
		Canvas c = new Canvas("L-System");
    	c.setVisible(true);
		return c;
	}

}
