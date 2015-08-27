package dk.itu.lSystem.util;

public interface CanvasInterface {
	
	public CanvasInterface getInstance();
	
	//the center is the bottom left corner of the window
	public void drawLine(int x0, int y0, int x1, int y1 );

}
