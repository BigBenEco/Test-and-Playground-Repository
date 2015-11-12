/**
 *  This program puts a panel in a frame and adds to buttons to the panel. 
 *  Then it adds a actionlistener to the button so you can tell which 
 *  button is pushed. 
 * 
 * @Hunter lloyd 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanelExample
{
   private JButton button1;
   private JButton button2;
   private JPanel panel1, panel2, panel3;
   
   public static void main(String []args)
          {
             ButtonPanelExample myClass = new ButtonPanelExample();     
             new FrameTest("CS160");
          }
     public ButtonPanelExample()
     {
         JFrame myFrame = new JFrame("Button Example");
         button1 = new JButton("first");
         button2 = new JButton("second");
         button1.addActionListener(new myButtonHandler());
         button2.addActionListener(new myButtonHandler());
         panel1 = new JPanel();
         panel1.add(button1);
         panel1.add(button2);
         myFrame.getContentPane().add(panel1);
         myFrame.setSize(400, 400);
         myFrame.setVisible(true);
     }
	class myButtonHandler implements ActionListener
   {
              public void actionPerformed(ActionEvent e)
              {
                 String answer= e.getActionCommand();
                 System.out.println("Button Pushed " + answer);
            }
        }
}