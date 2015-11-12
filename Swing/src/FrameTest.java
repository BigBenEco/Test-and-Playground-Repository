import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameTest extends JFrame implements MouseListener
{
   JPanel canvas;
   JButton clear;
   int startX, startY, endX, endY;
   
   FrameTest(String frameName)
   {
       super(frameName);
       setSize(500, 500);
       setLocation(400, 100);
       clear = new JButton("Clear");
       clear.addActionListener(new myButtonHandler());
       canvas = new JPanel();
       canvas.setBackground(Color.yellow);
       canvas.addMouseListener(this);
       getContentPane().add(canvas, BorderLayout.CENTER);
       getContentPane().add(clear, BorderLayout.SOUTH);
       setVisible(true);
    }
    
    public void mouseClicked(MouseEvent e) {}
          
       public void mouseEntered(MouseEvent e) {}
         
       public void mouseExited(MouseEvent e) {}
         
       public void mousePressed(MouseEvent e) {
           startX = e.getX();
           startY = e.getY();
        }
      
      public  void mouseReleased(MouseEvent e)
      {
        endX = e.getX();
        endY = e.getY();
        Graphics g = canvas.getGraphics();
        g.drawLine(startX, startY, endX, endY);
      } 
 
    
    class myButtonHandler implements ActionListener
   {
              public void actionPerformed(ActionEvent e)
              {
                 canvas.repaint();
                
            }
        }
    
}