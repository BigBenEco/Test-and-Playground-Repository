
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class gui_WindowLayout extends JFrame 
{

	public Container contents;
	public gui_Canvas canvas;
	public gui_ToolBarLayout toolBar;
	

	
	//addMouseListener(new MouseComp());
    gui_WindowLayout ( int width, int height)
    {
    	super("Paint SL");
        setSize(width, height);
        
        contents = getContentPane();
      
        canvas = new gui_Canvas(width, height);
        toolBar = new gui_ToolBarLayout(canvas);
    	
    	contents.add(canvas, BorderLayout.CENTER);
    	contents.add(canvas, BorderLayout.WEST);
    }

    public void run()
    {
    	setExtendedState(JFrame.MAXIMIZED_BOTH);
    	setVisible( true );
    }
}
