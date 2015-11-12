import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends JPanel
{
    PaintPanel pp;

    ButtonPanel(PaintPanel pp)
    {
       this.pp = pp;
       JButton start = new JButton("Start");
       JButton clear = new JButton("Clear");
       start.addActionListener(new ButtonListener());
       clear.addActionListener(new ButtonListener());
       setLayout(new GridLayout(4, 1));
       setBackground(Color.RED);
       add(start);
       add(clear);
       
    }

	public class ButtonListener implements ActionListener
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