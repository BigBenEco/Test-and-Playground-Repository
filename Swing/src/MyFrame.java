/**
 * Driver for MyPanel
 * 
 * @author Hunter Lloyd
 * @version 1.0
 */

import javax.swing.JFrame;

public class MyFrame extends JFrame
{
    private static MyFrame current;

    MyFrame ()
    {
        add (MyPanel.getInstance());
        pack();
        setVisible( true );
    }

    public static MyFrame getInstance()
    {
        if(current == null)
            current = new MyFrame();
        return current;
    }
    public static void main(String [] args)
    {
       MyFrame.getInstance();
    }
}