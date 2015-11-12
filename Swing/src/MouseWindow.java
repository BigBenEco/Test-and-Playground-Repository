import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class MouseWindow extends JFrame implements MouseListener
{
	
	public MouseWindow()
	{
		super("Mouse Window");
		setSize(200, 200);
		setLocation(300, 500);
		JPanel panel = new JPanel();
		panel.setBackground(Color.black);
		panel.addMouseListener(this);
		getContentPane().add(panel);
		setVisible(true);
		
	}

	  public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed at " + e.getX() + " " +e.getY()); 
    }

    public void mouseReleased(MouseEvent e) {
       
    }

    public void mouseEntered(MouseEvent e) {
       
    }

    public void mouseExited(MouseEvent e) {
       
    }

    public void mouseClicked(MouseEvent e) {
      
    }

}