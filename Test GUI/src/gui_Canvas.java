import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class gui_Canvas extends JPanel
{
	
	
	public Tools.tool myTool;
	
	int wWidth, wHeight, width, height, startX, startY;
	gui_Canvas( int wWidth, int wHeight)
	{
		this.wWidth = wWidth;
		this.wHeight = wHeight;
		width = wWidth;
		height = wHeight;
		
		myTool = Tools.tool.Mouse;
		
		//setBackground(Color.RED);
		addMouseListener(new MouseComp());
		setPreferredSize(new Dimension(wWidth, wHeight));
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
        //g2.drawRect(startX, startY, endX, endY);
    }
    
    public class MouseComp implements MouseListener
	{
	   public void mouseClicked(MouseEvent e) {}
       public void mouseEntered(MouseEvent e) {}    
       public void mousePressed(MouseEvent e) 
       {
          startX = e.getX();
	      startY = e.getY();
	      Tools.start(myTool, startX, startY);
	   }
	   
       public void mouseReleased(MouseEvent e){} 
       public void mouseExited(MouseEvent evt){}
	}
    
    public class MouseTracker implements MouseMotionListener
    {
    	
          
         public void mouseMoved(MouseEvent e) {
             //if(e.getX() < 20){System.out.println("mouse at "+e.getX()+" and "+e.getY() ); toolBar.setSize(29, 29); toolBar.repaint(); }
             //else{toolBar.setSize(293, 293); toolBar.repaint();}
        	 switch(myTool)
        	 {
	        	 case Mouse:
	        	 {
	        		 //nomnomnom
	        	 }	break;
	        	 case Box:
	        	 {
	        		 //maybe change the icon.
	        	 }	break;
	        	 default:
	        	 {
	        		 //potato
	        	 }
        	 }
        	 
         }
          
         public void mouseDragged(MouseEvent e) {
             
         }
    }
    
    public void setTool( tool myTool)
    {
    	this.myTool = myTool;
    }
    
}
