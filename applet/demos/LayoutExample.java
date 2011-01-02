/* 
This example demonstrated the use of a layout manager to
place components
The Layout manager here is BorderLayout
*/


import java.awt.*;
import java.applet.*;

public class LayoutExample extends Applet 
{
	Button okButton1;
	Button okButton2;
	Button okButton3;
	Button okButton4;
	Button okButton5;

	public void init()
	{
		// sets the LayoutManager to BorderLayout
		setLayout(new BorderLayout());
		okButton1 = new Button("Centered");
		okButton2 = new Button("North");
		okButton3 = new Button("West");
		okButton4 = new Button("East");
		okButton5 = new Button("South");
		// always says where the component should be placed when adding
		// Options are center,East,West,Nort and South
		add(okButton1,"Center");
		add(okButton2,"North");
		add(okButton3,"West");
		add(okButton4,"East");
		add(okButton5,"South");
	}
}


// There are more layout managers available. The easiest is
// FlowLayout() which will kee adding components horizontally until 
// there is no more space, then it will continue a row lower.

// Now that you are able to create a GUI let's bind actions to those
// components. Wouldn't be handy? :)

// Go to ActionExample