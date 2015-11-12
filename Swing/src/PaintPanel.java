import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PaintPanel extends JPanel
{
	int startX, flag, startY, endX, endY;
	
	public PaintPanel()
	{
	   startX = startY =0;
	   endX=100;
	   endY=100;
	   flag = 0;
       addMouseListener(new MouseComp());
 	}

 	public void clear()
 	{
 	    repaint();
 	  }
    public void paintComponent(Graphics g)
    {  
         super.paintComponent(g);
     }
    public void drawing()
    {
        Graphics2D g2 = (Graphics2D)getGraphics();
        g2.drawRect(startX, startY, endX, endY);
    }
    
	public class MouseComp implements MouseListener
	{
	   public void mouseClicked(MouseEvent e) {}
       public void mouseEntered(MouseEvent e) {}    
       public void mousePressed(MouseEvent e) 
       {
          startX = e.getX();
	      startY = e.getY();
	      drawing();
	   }
	   
       public void mouseReleased(MouseEvent e){} 
       public void mouseExited(MouseEvent evt){}
	}
	
	
}