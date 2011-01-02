
import java.awt.*;
import java.awt.event.*;

public class HotSpot extends Canvas implements MouseListener
{
	private static HotSpotListener hsl;
	private Color fgcolor1,fgcolor2,fgcolor3;
	private Color bgcolor1,bgcolor2,bgcolor3;
	private String mesg1,mesg2,mesg3;
	private Image bgimage1,bgimage2,bgimage3;
	private int width;
	private int height;
	private boolean mouseOver, mousePressed;;
	private boolean enabled;
	private boolean useImages;
	private boolean action;
	private FontMetrics fm;
	private int fontwidth, fontsize;
	private Image buff;
	private Graphics g;
	

	public HotSpot(HotSpotListener hsl)
	{

		bgcolor1 = new Color(0,0,0);
		bgcolor2 = new Color(0,0,0);
		bgcolor3 = new Color(0,0,0);
		fgcolor1 = new Color(0,0,000);
		fgcolor2 = new Color(060,060,060);
		fgcolor3 = new Color(255,255,255);
		mesg1 = "";
		mesg2 = "";
		mesg3 = "";
		setBackground(Color.yellow);
		this.hsl = hsl;
		addMouseListener(this);
	}

	public HotSpot(String mesg1,HotSpotListener hsl)
	{
		this(hsl);
		this.mesg1 = mesg1;

	}

	public void setImage(Image img,int state)
	{
		switch (state)
		{
		case 1 : this.bgimage1 = img; break;
		case 2 : this.bgimage2 = img; break;
		case 3 : this.bgimage3 = img; break;
		default : this.bgimage1 = img;
		}

	}


	public void paint(Graphics g2)
	{

		Dimension dim = getSize();
		if (buff == null)
		{
			buff = createImage(dim.width,dim.height);
			g = buff.getGraphics();
		}


		int bgwidth, bgheight = 0;

		if (mousePressed)
		{
			g.setColor(bgcolor3);
			g.fillRect(0,0,dim.width,dim.height);

			if (bgimage3 != null)
			{
				bgwidth = bgimage3.getWidth(this)/2;
				bgheight = bgimage3.getHeight(this)/2;

				g.drawImage(bgimage3,dim.width/2-bgwidth,dim.height/2-bgheight,this);
			}
	
		}
		else if (mouseOver)
		{
			g.setColor(bgcolor2);
			g.fillRect(0,0,dim.width,dim.height);
			if (bgimage2 != null)
			{
				bgwidth = bgimage2.getWidth(this)/2;
				bgheight = bgimage2.getHeight(this)/2;
				g.drawImage(bgimage2,dim.width/2-bgwidth,dim.height/2-bgheight,this);
			}


		}
		else
		{
			g.setColor(bgcolor1);
			g.fillRect(0,0,dim.width,dim.height);
			if (bgimage1 != null)
			{
				bgwidth = bgimage1.getWidth(this)/2;
				bgheight = bgimage1.getHeight(this)/2;
				g.drawImage(bgimage1,dim.width/2-bgwidth,dim.height/2-bgheight,this);
			}

		}
		g2.drawImage(buff,0,0,this);

	}



	public void update(Graphics g3)
	{
		paint(g3);
	}	

	public void mouseClicked(MouseEvent me)
	{

		repaint();
	}
	public void mouseReleased(MouseEvent me)
	{
		hsl.hotSpotEvent(this);
		mousePressed = false;

		repaint();
	}
	public void mousePressed(MouseEvent me)
	{
		mousePressed = true;

		repaint();

	}
	public void mouseEntered(MouseEvent me)
	{
		mouseOver =true;
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		repaint();
	}
	public void mouseExited(MouseEvent me)
	{
		mouseOver = false;
		mousePressed = false;
		setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		repaint();
	}


}
	
