/*
 * Code Not Made By Ben
 * Code may have Been made by my professor or others
 * All I know is this is what he generally uses for teaching
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JPanel;

public class SimpleButton implements ActionListener
{
   private JButton butA;
   
   SimpleButton()
   {
       //button frame
       butA = new JButton("Trial");
       butA.addActionListener(this);  //new MyButtonListerner()
       //Frame set up her
       JFrame.setDefaultLookAndFeelDecorated(false);// makes it look like the operating system.
       JFrame myFrame = new JFrame("Test Button");
       myFrame.setSize(300, 300);

       JPanel pan = new JPanel();
       pan.add(butA);
       
       myFrame.getContentPane().add(pan, BorderLayout.WEST);
       myFrame.setDefaultLookAndFeelDecorated(false);
       myFrame.setVisible(true);
    }


    public void actionPerformed(ActionEvent evt)
    {
        System.out.println(evt);
    }


    public static void main(String [] args)
    {
        new SimpleButton();
    }

    public class MyButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent evt)
        {

         }
    }
   
}