/* Perhaps one of the most intresting features of applets.
   You can let others, especially webmasters, specify options
   for your applet in their HTML code. 
   Often used to determine background colors
   and other layout to fit in any design.
*/


import java.awt.*;
import java.applet.*;

public class ParameterExample extends Applet
{
	// We'll save the first HTM parameter as a String
	String parameter1;
	// the second one we will use as an integer
	int parameter2;
	// third one too
	int parameter3;
	// we'll add param2 to param2
	int result;
	
	public void init() 
	{
		// This method will get the specified parameter's value
		// out of the HTML code that is calling the applet.
		parameter1 = getParameter("param1");
		// Since those are read as text we need to transform them
		// to integers to be able to count with them.
		parameter2 = Integer.parseInt(getParameter("param2"));
		parameter3 = Integer.parseInt(getParameter("param3"));
		
		result = parameter2 + parameter3;
	}
	
	public void paint(Graphics g) 
	{
		// Shows what was in the HTML param code.
		g.drawString("Parameter 1 is: " + parameter1,20,20);
		g.drawString("Parameter 2 is: " + parameter2,20,40);
		g.drawString("Parameter 3 is: " + parameter3,20,60);
		g.drawString("Parameter 2 + parameter 3 is: " + result,20,80);
		
	}
}

/* This only works when those paramters are actually in the HTML code.
   That code for this example is :
	<APPLET CODE="ParameterExample" WIDTH=200 HEIGHT=100>
		<param name="param1" value="Hello">
		<param name="param2" value="14">
		<param name="param3" value="2">
	</APPLET>
  If you make applets for others make sure to use parameters, many
  will appreciate it.

*/