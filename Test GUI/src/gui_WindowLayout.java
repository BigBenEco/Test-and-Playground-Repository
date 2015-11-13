
import java.awt.Container;

import javax.swing.JFrame;

public class gui_WindowLayout extends JFrame 
{

	public Container contents;
	
	public int width;
	public int height;
	
	//addMouseListener(new MouseComp());
    gui_WindowLayout ( int swidth, int sheight)
    {
    	super("Paint SL");
        width = swidth;
        height = sheight;
        setSize(width, height);
    	
    }

    public void run()
    {
    	pack();
    	setVisible( true );
    }
}
