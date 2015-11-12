import javax.swing.JFrame;

import PaintPanel.MouseComp;

public class gui_WindowLayout extends JFrame 
{
	private static gui_WindowLayout current;
	addMouseListener(new MouseComp());
    gui_WindowLayout ()
    {
        add (gui_WindowLayout.getInstance());
        pack();
        setVisible( true );
    }

    public static gui_WindowLayout getInstance()
    {
        if(current == null)
            current = new gui_WindowLayout();
        return current;
    }
}
