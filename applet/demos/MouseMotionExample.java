
/* MouseMotionListener will enable you to perform actions when the mouse moves over
a hotspot. You can also use this to drag things, that will require MouseListener and
MouseMotionListener at the same time.
This applet will show a rectangle that will change color when the mouse moves over it.
It's basically the same as the previous one.
*/

import java.awt.*;
import java.applet.*;
// import an extra class for the MouseMotionListener
import java.awt.event.*;

// Tells the applet you will be using the MouseMotionListener methods.

public class MouseMotionExample extends Applet implements MouseMotionListener
{
	// The X-coordinate and Y-coordinate of the last Mouse Position.
	int xpos;
	int ypos;
	
	// The coordinates of the rectangle we will draw.
	// It is easier to specify this here so that we can later
	// use it to see if the mouse is in that area.
	int rect1xco,rect1yco,rect1width,rect1height;
	
	// wll be true when the Mouse is in the Rectangle
	boolean rect1Active;
	
	public void init() 
	{
		
		rect1xco = 20;
		rect1yco = 20;
		rect1width = 100;
		rect1height = 50;

		// Add the MouseMotionListener to your applet
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g) 
	{
		// Rectangle's color
		// If mouse is in the rectangle then set Color to green
		// else to red.
		if (rect1Active) g.setColor(Color.green);
		else g.setColor(Color.red);
				
		g.fillRect(rect1xco,rect1yco,rect1width,rect1height);
				
		g.setColor(Color.blue);
		
		// This will show the coordinates of the mouse
		// at the place of the mouse.
		g.drawString("("+xpos+","+ypos+")",xpos,ypos);
		
	}

/* If you use MouseMotionListener then these methods have to be here
	public void mouseMoved(MouseEvent me);
	public void mouseDragged(MouseEvent me);
*/

	// This will be excuted whenever the mouse moves in the applet
	public void mouseMoved(MouseEvent me) 
	{		
		xpos = me.getX();
		ypos = me.getY();
		// Check if the mouse is in the rectangle
		if (xpos > rect1xco && xpos < rect1xco+rect1width && ypos >rect1yco && ypos < rect1yco+rect1height) 
			rect1Active = true;
		else 
			rect1Active = false;
		//show the results	of the motion
		repaint();

	}
	
	// This is works like mouseMoved but only when the mouse is being pressed
	// at the same time.
	// To use this for drawing rectangles like in Paint programs
	// you will have to use mousePressed to remember the first coordinates.
	public void mouseDragged(MouseEvent me) 
	{
	}

/* It's quite easy, but this isn't a good example of programming.
You can notice that the applet flickers, this is because it is not double-buffered
You will see this later.
*/

}