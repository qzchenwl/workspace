/*
When you write many programs you notice that most tasks
come back often, and that you can solve that by writing libraries.
Libraries are Objects that you can use over and over again to do
certain things.
We'll now use 2 handy libraries I use often:
HotSpot - A self-written button
RealMedia - an advanced Media Collection.
You need the following .class files:
HotSpotListener.class (interface)
HotSpot.class (component)
Loadable.class (interface)
RealMedia.class (invisible component)
*/


/*
This aplet will have two buttons, when the first one is pressed
image1 will show, when the second one is pressed image2 wil show.
It will make use of nice image buttons and it will show a loading bar.
*/

import java.awt.*;
import java.applet.*;

/* Loadable is required for RealMedia so that it know that this code
can load images and sounds and has the startUp() method
*/
/* HotSpotListener is required to let HotSpot call hotSpotEvent(HotSpot) when it
has been clicked
*/
public class LibraryTest extends Applet implements Loadable, HotSpotListener
{
	// RealMedia will load and save images and sounds.
	// It will also give information on the loading process.
	RealMedia rm;
	// Two buttons that can be clicked on.
	HotSpot hs1,hs2;
	// 1 will show image 1 and 2 will show image 2.
	int x =1;
	
	public void init()
	{
		// We'll place the buttons ourselves.
		setLayout(null);
		setBackground(Color.black);
		// create the RealMedia object
		rm = new RealMedia(this);
		// Start adding all image files you will use
		// image1 called alien4
		rm.add("alien4DS.gif","alien4");
		// image2 called alien5
		rm.add("alien5DS.jpg","alien5");
		// Start button with 3 images
		// Default state, mouseOver and mouseClick state.
		rm.add("bt1c.gif");
		rm.add("bt2c.gif");
		rm.add("bt3c.gif");
		// Other button
		rm.add("bt1b.gif");
		rm.add("bt2b.gif");
		rm.add("bt3b.gif");
		// load the images now
		rm.load();
	}
	
	// This method will be called by RM when it has finished loading.
	// We'll then make the buttons since we have the images ready now.
	public void startUp()
	{
		// Make button 1
		hs1 = new HotSpot(this);
		// Give it a default image
		hs1.setImage(rm.get("bt1c.gif"),1);
		// A mouseOver image
		hs1.setImage(rm.get("bt2c.gif"),2);
		// A mouseClick image
		hs1.setImage(rm.get("bt3c.gif"),3);
		// Define it's size and location
		hs1.setBounds(50,250,80,40);
		// same for button 2
		hs2 = new HotSpot(this);
		hs2.setImage(rm.get("bt1b.gif"),1);
		hs2.setImage(rm.get("bt2b.gif"),2);
		hs2.setImage(rm.get("bt3b.gif"),3);
		hs2.setBounds(170,250,80,40);
		// Place them
		add(hs1);
		add(hs2);
		// Repaint makes sure they are immediately visible.
		hs1.repaint();
		hs2.repaint();
	}
	
	// Here the images are drawn.
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		// When it is still loading show a loading message.
		if (!rm.isLoaded()) 
		{
			
			g.drawString("loading file "+rm.getCurrent(),20,20);
			g.drawString("of "+rm.getTotalFiles(),20,40);			
			g.drawString("Percent: "+rm.getPercent(),20,60);			
			g.fillRect(20,80,rm.getPercent(),20);			
		}
		// Otherwise draw image1 or 2
		else
		{
			if (x == 1)
				g.drawImage(rm.get("alien4"),20,20,this);
			else
				g.drawImage(rm.get("alien5"),20,20,this);
		}	
	}
	
	// This method is called when a button has been clicked
	public void hotSpotEvent(HotSpot hs)
	{
		// if it was button 1 show image1
		if (hs == hs1)
			x = 1;
		// else show image2
		else
			x = 2;
		// and repaint to show them
		repaint();	
	}
	
	// Necessary for RealMedia to load your images
	public Image loadImage(String file) 
	{
		
		return getImage(getCodeBase(),file);
	}

	// Also required but not used this time.
	public AudioClip loadAudio(String file) 
	{
		
		return getAudioClip(getDocumentBase(),file);
	}	
}
			
		
		
/*
You can make use of these classes if you want to. The source is included
in the sourcefiles.zip file.
If you would want to do the same without these classes you would have
a code at least three times as long as this one.

*/

/*
This is the end of this tutorial.
Another tutorial is in development: 
Game programming : Case-study RealTris.
It will go step-by-step through the process of making a whole game (tetris) and will
at least expect you know everything that was written here.
More emphasis will be made on good design and Object-oriented programming.

Bavo Bruylandt.
Bavo@realapplets.com
*/
