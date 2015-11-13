import java.awt.Dimension;
import java.awt.Toolkit;

public class Program_Data {

	public gui_WindowLayout programWindow;
	
	public int width;
	public int height;
	
	Program_Data()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	width = (int) screenSize.getWidth();
    	height = (int) screenSize.getHeight();
	}
	
	public void buildGUI()
	{
		programWindow = new gui_WindowLayout(width, height);
	}
	
	public void run()
	{
		programWindow.run();
	}
	
}
