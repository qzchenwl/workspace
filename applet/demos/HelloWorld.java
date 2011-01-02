/*
Start of the applet basics tutorial.
Requires some basic knowledge of programming
Will be a walk through if you ever saw Java dos programs 
(the number excercise sand the sort) or even C++.
Otherwise just copy and paste and don't bother why things are
like that in Java.

By Bavo Bruylandt (Http://www.realapplets.com")

*/

// and now The inevidable "Hello World" example :)

// tell the compiler where to find the methods you will use.
// required when you create an applet
import java.applet.*;
// required to paint on screen
import java.awt.*;


// the start of an applet - HelloWorld will be the executable class
// Extends applet means that you will build the code on the standard Applet class
public class HelloWorld extends Applet 
{

// The method that will be automatically called  when the applet is started
	public void init() 
	{
	// It is required but does not need anything.
	}


// This method gets called when the applet is terminated
// That's when the user goes to another page or exits the browser.
	public void stop() 
	{
	// required but no actions neede here now.
	}


// The standard method that you have to use to paint things on screen
// This overrides the empty Applet method, you can't called it "display" for example.
	
	public void paint(Graphics g) 
	{
	//method to draw text on screen
	// String first, then x and y coordinate.
		g.drawString("Hey hey hey",20,20);
		g.drawString("Hellooow World",20,40);

	}

}


// That's it. Next is drawing special shapes on screen and using fonts.
// Go to DrawExample.java.