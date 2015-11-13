import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class gui_Canvas extends JPanel
{
	int wWidth, wHeight, width, height;
	gui_Canvas( int wWidth, int wHeight)
	{
		this.wWidth = wWidth;
		this.wHeight = wHeight;
		width = wWidth;
		height = wHeight;
		
		setBackground(Color.RED);
		//setPreferredSize(new Dimension(wWidth, wHeight));
	}
	
}
