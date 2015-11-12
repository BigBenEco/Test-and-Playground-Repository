import javax.swing.*;
import java.awt.*;

public class ColorWindow extends JFrame
{
	private JPanel jp;
	private int flag = 0;
	
	public ColorWindow()
	{
	   super("color window");
	   setSize(400, 60);
	   setLocation(150, 20);
	   jp = new JPanel();
	   jp.setBackground(Color.red);
	   getContentPane().add(jp);
	   setVisible(true);
	}
    public void setColor()
    {
       flag = ++flag % 3;
       switch(flag)
       {
         case 0:
            jp.setBackground(Color.red);
            break;
         case 1:
            jp.setBackground(Color.blue);
            break;
          default:
            jp.setBackground(Color.yellow);
        }
     
    }
    
}
