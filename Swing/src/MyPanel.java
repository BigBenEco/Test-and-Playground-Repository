/**
 * We are changing colors of panels using buttons
 * 
 * @author Hunter Lloyd
 * @version 1.0
 */

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyPanel extends JPanel
{
    private static MyPanel current;

    private Color currentBackground;

    private MyPanel()
    {
        currentBackground = Color.red;
        add (new MyButton("Blue", this, Color.blue));
        add (new MyButton("Yellow", this, Color.yellow));
        add (new MyButton("Green", this, Color.green));
    }

    public static MyPanel getInstance()
    {
        if(current==null)
           current = new MyPanel();
        return current;

    }

        
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        setBackground(currentBackground);
    }
    

    class MyButton extends JButton implements ActionListener
    {
        MyButton (String label, MyPanel parent, Color background)
        {
            setText(label);
            addActionListener(this);
            setPreferredSize(new Dimension(100, 100));
            this.parent = parent;
            color = background;
        }
        
        public void actionPerformed (ActionEvent evt)
        {
            currentBackground = color;
            parent.repaint();
        }
        
        private MyPanel parent;
        private Color color;
    }
}