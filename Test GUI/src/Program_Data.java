import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;

public class Program_Data {

	public gui_WindowLayout programWindow;
	
	public int width;
	public int height;

	public data_ImageBuffer imageBuffer;
	public BufferedImage currentPainting = null;
	
	Program_Data()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	width = (int) screenSize.getWidth();
    	height = (int) screenSize.getHeight();
    	
    	// lets not deal with this right now imageBuffer = new data_ImageBuffer(5); //thats all that's needed to be noticeable for the score of the undo feature.
    	//currentPainting.createGraphics();
 	}
	
	public void buildGUI()
	{
		programWindow = new gui_WindowLayout(width, height);
	}
	
	public void run()
	{
		programWindow.run();
	}
	
	public void log(BufferedImage newFrame)
	{
		// lets not deal with this right now imageBuffer.push(currentPainting); //currently I do not think this will work, I think it is passing by reference, but I want to pass by value, so I need to some how generate new images, but I don't see any method to get the raw images, so maybe this will work, but it gives you the idea atleast.
		currentPainting.setData(newFrame.getData() );
	}
	
	public BufferedImage painting()
	{
		//BufferedImage cool; this may be of some use to me as this is were I am going to no
	     //Graphics2D painting = (Graphics2D)getGraphics();
		BufferedImage standIn = null;
		standIn.createGraphics();
		standIn.setData( currentPainting.getData() );
		return standIn;
	}
}
