import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonWindow implements ActionListener
{
   JFrame frame;
	ColorWindow color;
	SizeWindow sizeW;
	
	public ButtonWindow()
	{
		frame = new JFrame("Master Window");
		frame.setSize(130, 300);
		frame.setLayout(new FlowLayout());
		setWindows();
		setButtons();	
		frame.setVisible(true);
	}

  public void setWindows()
  {
     color = new ColorWindow();
     sizeW = new SizeWindow();
     MouseWindow ms = new MouseWindow();
   }
  private void setButtons()
  {
      JButton size = new JButton("change size");
      JButton color = new JButton("change Color");
      color.addActionListener(this);
      size.addActionListener(this);
      JButton layout = new JButton("Print Something");
      layout.addActionListener(this); 
      
    
      layout.addActionListener(this);
      frame.getContentPane().add(size);
      frame.getContentPane().add(color);
      frame.getContentPane().add(layout);
   
  }
  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("change Color"))
          color.setColor();
     else if(e.getActionCommand().equals("change size"))
          sizeW.changeSize();
  }
}