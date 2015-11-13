import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class gui_Canvas extends JPanel
{
	
	public int wWidth, wHeight, width, height;
	public Tool_Box toolBox = new Tool_Box();
	
	
	
	gui_Canvas( int wWidth, int wHeight)
	{
		this.wWidth = wWidth;
		this.wHeight = wHeight;
		width = wWidth;
		height = wHeight;
		
		//setBackground(Color.RED);
		addMouseListener(new MouseComp());
		setPreferredSize(new Dimension(wWidth, wHeight));
	}
	
	public void clear()
 	{
 	    repaint();
 	    Graphics2D painting = (Graphics2D)getGraphics();  //goes through the logging process so that it can be part of the undo to.
 	    Driver.global.imageBuffer.push(painting);
	    paintComponent(painting);
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
          int startX = e.getX();
	      int startY = e.getY();
	      toolBox.start(toolBox.myTool, startX, startY);
	   }
	   
       public void mouseReleased(MouseEvent e){
    	  int endX = e.getX();
 	      int endY = e.getY();
 	      Graphics2D painting = Driver.global.painting();
 	      
 	      painting = toolBox.end(toolBox.myTool, painting, endX, endY);
 	      
 	      Driver.global.imageBuffer.push(painting);
 	      paintComponent(painting);
 	      
       } 
       public void mouseExited(MouseEvent evt){}
	}
    
    public class MouseTracker implements MouseMotionListener
    {
    	
          
         public void mouseMoved(MouseEvent e) {
             //if(e.getX() < 20){System.out.println("mouse at "+e.getX()+" and "+e.getY() ); toolBar.setSize(29, 29); toolBar.repaint(); }
             //else{toolBar.setSize(293, 293); toolBar.repaint();}
        	 switch(toolBox.myTool)
        	 {
	        	 case Mouse:
	        	 {
	        		 //nomnomnom
	        	 }	break;
	        	 case Box:
	        	 {
	        		 //maybe change the icon of mouse.
	        		 int curX = e.getX();
	        	     int curY = e.getY();
	        	     Graphics2D painting = Driver.global.painting();
	        	     
	        	     painting = toolBox.hold(toolBox.myTool, painting, curX, curY); // this function will oporate at all time, but is capable of turning off when not in use.
	        	     
	        	     /////////////////Driver.global.imageBuffer.push(painting);  Similar process to before, this alows for the displaing of things, but does not record it.
	        	     paintComponent(painting);
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
    
}
