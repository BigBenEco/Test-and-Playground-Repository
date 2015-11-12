import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import PaintPanel.MouseComp;

public class gui_Canvus extends JPanel
{
	gui_Canvus ( JPanel )addMouseListener(new MouseComp());
	
	private class ButtonListener implements ActionListener
	{
	   public void actionPerformed(ActionEvent ae)
	   {
	       String command = ae.getActionCommand();
	       if(command.equals("Clear"))
	       {
	           pp.clear();
	       }
	   }
	 }
}
