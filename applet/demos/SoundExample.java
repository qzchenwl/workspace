/* Using sounds in applets is easy. Perhaps the hardest thing is to find
 them and decide wether or not to use them.
 We'll use a MouseListener to play a sound when the mouse has been clicked.
*/

import java.applet.*;
import java.awt.event.*;
import java.awt.*;

public class SoundExample extends Applet implements MouseListener
{
	// To refer to the sounds.
	AudioClip soundFile1;
	AudioClip soundFile2;
	
	public void init() 
	{
		// This loads the sounds from the server in the same way
		// as an Image.
		soundFile1 = getAudioClip(getDocumentBase(),"dataS.au");
		soundFile2 = getAudioClip(getDocumentBase(),"shootS.au");
		
		// When the applet gets here the sounds are loaded.
		// Add the mouselistener
		addMouseListener(this);
		// Just for fun
		setBackground(Color.yellow);
		// Play the first sound to let the user know the applet
		// is loaded.
		soundFile1.play();
	}
	
	public void paint(Graphics g) 
	{
		g.drawString("Click to hear a sound",20,20);
	}
	
	// Play the second sound on a click.
	public void mouseClicked(MouseEvent evt) 
	{
		// This will play your sound file.
		soundFile2.play();
	}


	// The necessary methods.
	public void mousePressed(MouseEvent evt) 
	{
	}
	public void mouseReleased(MouseEvent evt) 
	{
	}
	public void mouseEntered(MouseEvent evt) 
	{
	}
	public void mouseExited(MouseEvent evt) 
	{
	}
}
	
		

/*
Because applets are most often served through the internet using sounds
is often not a good idea. I loads very long.
If you need sounds look for .au files (JDK1.1 only plays those) or use
a program like CoolEdit to transform any sound type
to .au (mu-law,8000 sample rate).
*/