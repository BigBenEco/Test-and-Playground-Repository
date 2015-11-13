import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class gui_ToolBarLayout extends JPanel {
	
	gui_Canvas canvus;

	gui_ToolBarLayout ( gui_Canvas canvus)
	{
		this.canvus = canvus;
		
		JButton box = new JButton("Box");
		JButton undo = new JButton("Undo");
	    JButton clear = new JButton("Clear");
	    
	    box.addActionListener(new ButtonListener());
	    undo.addActionListener(new ButtonListener());
	    clear.addActionListener(new ButtonListener());
	    
	    setLayout(new GridLayout(1, 7));
	    
	    setBackground(Color.RED);
		add(box);
		add(undo);
		add(clear);
		
		//setPreferredSize(new Dimension(450, 50));
        //setBorder(BorderFactory.createCompoundBorder(
        //                        BorderFactory.createMatteBorder(
        //                                        1,1,2,2,Color.black),
        //                        BorderFactory.createEmptyBorder(5,5,5,5)));
	    
	}
	
	private class ButtonListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent ae)
	   {
	       String command = ae.getActionCommand();
	       if(command.equals("Clear"))
	       {
	    	   //canvus.clear();
	       }
	   }
	 }
}
