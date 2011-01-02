/* This Applet will show status bar messages in your browser.
We will use an ActionListener to practice on it.
*/

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class StatusExample extends Applet implements ActionListener
{
	//The text in this field will be shown
	TextField statusField;
	// when this button is clicked
	Button statusButton;

	
	public void init() 
	{
		setLayout(new FlowLayout());
		statusButton = new Button("Set Status");
		statusField = new TextField("Type here");
		statusButton.addActionListener(this);
		// You can add ActionListeners to TextFields too.
		// An ActionEvent will be triggered when the user presses
		// ENTER in the textfield.
		statusField.addActionListener(this);
		add(statusButton);
		add(statusField);

	}
	
	public void actionPerformed(ActionEvent act) 
	{
		if (act.getSource() == statusButton)
			// The simple method to set a Status bar message.
			// This will take the text from thze textfield and append some extra
			// info to it.
			getAppletContext().showStatus(statusField.getText() + " (With Button Action)");
		else
			getAppletContext().showStatus(statusField.getText() + " (With Field Action)");
	}
}
		

// It's really easy. Next example is about opening web pages with 
// a browser through an applet. 
// Go to ShowDocumentExample