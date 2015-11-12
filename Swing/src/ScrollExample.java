import javax.swing.*;
import java.awt.*;
/**
 * Creating an example for JScrollPane
 *****************************************************/
public class ScrollExample extends JFrame
{
	ScrollExample()
    {
        setSize(200, 200);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(20, 1));
        for(int i=0; i<20; i++){
           String phrase = "This is label " + i;
           JLabel label = new JLabel(phrase);
           panel.add(label);
        }
      JScrollPane scroll = new JScrollPane(panel);
        getContentPane().add(scroll);
       //getContentPane().add(panel);
    }
   public static void main(String [] args)
   {
       ScrollExample se = new ScrollExample();
       se.setVisible(true);

    }
}