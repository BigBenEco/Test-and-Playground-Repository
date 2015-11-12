import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Creating an example for pulldown menu
 *****************************************************/
public class PullDown extends JFrame implements ActionListener
{
	PullDown()
    {
        setSize(200, 200);
        JPanel panel = new JPanel();
        //panel.setLayout(new GridLayout(20, 1));
        String title[] = {"first", "second", "third"};
        JComboBox combo = new JComboBox(title);
        combo.setMaximumRowCount(2);
        combo.setActionCommand("HUNTER");
        combo.addActionListener(this);
        panel.add(combo);
     
       getContentPane().add(panel);
    }



   public void actionPerformed(ActionEvent e)
   {
       System.out.println("You chose " + e.getSource() + "    and   " + 
           ((JComboBox)e.getSource()).getSelectedItem() +  "."); 
  } 

   public static void main(String [] args)
   {
       PullDown se = new PullDown();
       se.setVisible(true);

    }
}