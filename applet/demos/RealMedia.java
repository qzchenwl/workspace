import java.util.*;
import java.awt.*;
import java.applet.*;

public class RealMedia extends Component implements Runnable
{
	private Loadable lb;
	private Hashtable htImage, htsound;
	private Stack st1,st2;
	private int delay, size;
	private boolean loadFlag = true;
	private MediaTracker mt;
	private boolean loading;
	private Thread pauseThread;

	public RealMedia(Loadable lb)
	{
		this.lb = lb;
		htImage = new Hashtable();
		htsound = new Hashtable();
		st1 = new Stack();
		st2 = new Stack();
		mt = new MediaTracker(this);
		pauseThread = new Thread(this);
		setDelay(40);
		
	}

	public void add(String file)
	{

		st1.push(getMedia(file));
		st2.push(file);
	}


	public void add(String file,String name)
	{

		st1.push(getMedia(file));
		st2.push(name);
	}

	public Image get(String name)
	{
		
		return (Image)htImage.get(name);
	}
	
	public void play(String name)
	{
		
		AudioClip sound = (AudioClip)htsound.get(name);
		sound.play();
	}
	

	public int getCurrent()
	{
		return size-st1.size();
	}
	
	public int getPercent() 
	{
		return (int)((double)getCurrent()/(double)size*100);
	}
	
	public int getTotalFiles()
	{
		return size;
	}
	
	public void load() 
	{
		
		size = st1.size();
		pauseThread.start();
	}
	
	public void setDelay(int delay)
	{
		this.delay = delay;
	}

	public boolean isLoaded()
	{
		return st1.empty();
	}




	private Object getMedia(String file)
	{
		if (isAudio(file)) return new String(file);
		else return lb.loadImage(file);
	}



	private void loadNext()
	{
		
		
		if (!st1.empty() && !loading)
		{
			
			loading = true;
			mt = new MediaTracker(this);
			Object currentFile = null;
			String currentName = "";
			currentFile = (Object)st1.pop();
			currentName = (String)st2.pop();
						
			if (currentFile instanceof Image)
			{
				
				mt.addImage((Image)currentFile,0);
				htImage.put(currentName,(Image)currentFile);
			
			}
			else if (currentFile instanceof String) 
			{
				htsound.put(currentName,lb.loadAudio((String)currentFile));
			}
			try
			{
				mt.waitForAll();
			}
			catch (Exception p)
			{
			}

		}
		loading = false;
		

		
	}
	
	public void run() 
	{
	  while (!st1.empty()) 
	  {
	  	loadNext();
		lb.repaint();
		try 
		{
			pauseThread.sleep(delay);
		}
		catch (Exception e)
		{
		}
	  }
	  lb.startUp();
	  pauseThread = null;
	  System.out.println("Media Fully Loaded");
	  
	}
	

	
	private boolean isAudio(String file)
	{
		if (file.endsWith(".au")) return true;
		else return false;
	}

}
