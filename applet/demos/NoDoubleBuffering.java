/* Drawing in applets is almost always done with double-buffering.
This means that drawing is first done to an offscreen image, and when all
is done, the offscreen image is drawn on the screen.
This reduces the nasty flickering applets otherwise have.

*/

import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class NoDoubleBuffering extends Applet implements MouseMotionListener
{
	// The object we will use to write with instead of the standard screen graphics
	Graphics bufferGraphics;
	// The image that will contain everything that has been drawn on
	// bufferGraphics.
	Image offscreen;
	// To get the width and height of the applet.
	Dimension dim;
	int curX, curY;
	
	public void init() 
	{
		// We'll ask the width and height by this
		dim = getSize();
		// We'll redraw the applet eacht time the mouse has moved.
		addMouseMotionListener(this);
		// Just for fun
		setBackground(Color.black);
		// Create an offscreen image to draw on
		// Make it the size of the applet, this is just perfect larger
		// size could slow it down unnecessary.
		offscreen = createImage(dim.width,dim.height);
		// by doing this everything that is drawn by bufferGraphics
		// will be written on the offscreen image.
		bufferGraphics = offscreen.getGraphics();
	}
	
	public void paint(Graphics g) 
	{
		// Wipe off everything that has been drawn before
		// Otherwise previous drawings would also be displayed.
		//g.clearRect(0,0,dim.width,dim.width);
		g.setColor(Color.red);
		g.drawString("Not Double-buffered",10,10);
		// draw the rect at the current mouse position
		// to the offscreen image
		g.fillRect(curX,curY,20,20);
		// draw the offscreen image to the screen like a normal image.
		// Since offscreen is the screen width we start at 0,0.
		//g.drawImage(offscreen,0,0,this);
	}
	
	// Always required for good double-buffering.
	// This will cause the applet not to first wipe off
	// previous drawings but to immediately repaint.
	// the wiping off also causes flickering.
	// Update is called automatically when repaint() is called.
	
	/*public void update(Graphics g)
	{
		paint(g);
	}
	*/
	
	// Save the current mouse position to paint a rectangle there.
	// and request a repaint()
	public void mouseMoved(MouseEvent evt) 
	{
		curX = evt.getX();
		curY = evt.getY();
		repaint();
	}


	// The necessary methods.
	public void mouseDragged(MouseEvent evt) 
	{
	}
	
 }
 
/*
This is all about double-buffering. It's easy to use and recommended to use always.
There is one dangerous pitfall here, when you create an offscreen image that's very large
the applet might run slow because it takes a lot of resources and effort.
I would not recommend offscreen images larger than 500*500 when redrawn at 30FPS.
(see Threads)
*/