import javax.swing.*;
import java.util.Random;

public class SizeWindow
{
     JFrame frame;
     int size[] = {20, 60, 100, 200, 300, 400};
     
	 SizeWindow()
	 {
	    frame = new JFrame("Size Window");
	    frame.setLocation(150, 100);
	    
	    frame.setSize(size[2], size[2]);
	    frame.setVisible(true);
	 }
	 public void changeSize()
	 {
	     Random r = new Random();
	     int i = r.nextInt(6);
	     int j = r.nextInt(6);
         frame.setSize(size[i], size[j]);	     
	 }
}