import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui_ToolBarLayout extends JPanel {
	
	gui_panel_canvas canva;

	gui_ToolBarLayout ( gui_panel_canvus canvus)
	{
		this.canvas = canvus;
		
		JButton box = new JButton("Box");
		JButton undo = new JButton("Undo");
	    JButton clear = new JButton("Clear");
	    
	    box.addActionListener(new ButtonListener());
	    undo.addActionListener(new ButtonListener());
	    clear.addActionListener(new ButtonListener());
	    
	    
	    
	}
	
	private class ButtonListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent ae)
	   {
	       String command = ae.getActionCommand();
	       if(command.equals("Clear"))
	       {
	    	   canvas.clear();
	       }
	   }
	 }
}
