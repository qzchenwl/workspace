
/* You might want to create yourself areas where the user can click instead
of using buttons. Somtimes your whole applet will have to be clickable and that is
where the MouseListener comes in.
We are going to create an applet that will show where the user has clicked,
that will also tell if he clicked on a hotspot and if the mouse is in the applet
or not.
*/

import java.awt.*;
import java.applet.*;
// import an extra class for the MouseListener
import java.awt.event.*;

// Tells the applet you will be using the MouseListener methods.

public class MouseClickExample extends Applet implements MouseListener
{
	// The X-coordinate and Y-coordinate of the last click.
	int xpos;
	int ypos;
	
	// The coordinates of the rectangle we will draw.
	// It is easier to specify this here so that we can later
	// use it to see if the mouse is in that area.
	int rect1xco,rect1yco,rect1width,rect1height;
	
	// The variable that will tell whether or not the mouse
	// is in the applet area.
	boolean mouseEntered;
	
	// variable that will be true when the user clicked i the rectangle 
	// the we will draw.
	boolean rect1Clicked;
	
	public void init() 
	{
		// Assign values to the rectanagle coordinates.
		rect1xco = 20;
		rect1yco = 20;
		rect1width = 100;
		rect1height = 50;

		// Add the MouseListener to your applet
		addMouseListener(this);
	}
	
	public void paint(Graphics g) 
	{
		// Rectangle's color
		g.setColor(Color.green);
				
		g.fillRect(rect1xco,rect1yco,rect1width,rect1height);
				
		g.setColor(Color.red);
		
		// When the user clicks this will show the coordinates of the click
		// at the place of the click.
		g.drawString("("+xpos+","+ypos+")",xpos,ypos);
		
		// If the click was in the rectangle show this message
		if (rect1Clicked) g.drawString("You clicked in the Rectangle",20,120);
		// else this one
		else g.drawString("You clicked outside of the rectangle",20,120);
		
		if (mouseEntered) g.drawString("Mouse is in the applet area",20,160);
		else g.drawString("Mouse is outside the Applet area",20,160);
	}
	
/* These methods always have to present when you implement MouseListener

	public void mouseClicked (MouseEvent me) {}
	public void mouseEntered (MouseEvent me) {}
	public void mousePressed (MouseEvent me) {}
	public void mouseReleased (MouseEvent me) {}	
	public void mouseExited (MouseEvent me) {}	
*/

	// This method will be called when the mouse has been clicked.
	public void mouseClicked (MouseEvent me) {
		
		// Save the coordinates of the click lke this.
		xpos = me.getX();
		ypos = me.getY();
		
		// Check if the click was inside the rectangle area.
		if (xpos > rect1xco && xpos < rect1xco+rect1width && ypos >rect1yco && ypos < rect1yco+rect1height) 
			rect1Clicked = true;
		// if it was not then rect1Clicked	is false;
		else 
			rect1Clicked = false;
		//show the results	of the click
		repaint();
	
	}

	// This is called when the mous has been pressed
	public void mousePressed (MouseEvent me) {}
	
	// When it has been released
	// not that a click also calls these Mouse-Pressed and Released.
	// since they are empty nothing hapens here.
	public void mouseReleased (MouseEvent me) {}	
	
	// This is executed when the mouse enters the applet. it will only
	// be executed again when the mouse has left and then re-entered.
	public void mouseEntered (MouseEvent me) {
		// Will draw the "inside applet message"
		mouseEntered = true;
		repaint();
	}
	
	// When the Mouse leaves the applet.
	public void mouseExited (MouseEvent me) {
		// will draw the "outside applet message"
		mouseEntered = false;
		repaint();
	}	

/* So now you can use the MouseListener instead of Buttons. These methods will be ones that you will
often use. These methods are good for mouseClicks, but when you need mouseOvers like in Javascript
then you'll need the MouseMotionListener.
Go to MouseMotionExample.java
*/

}		
		
