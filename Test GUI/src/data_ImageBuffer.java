import java.awt.Graphics2D;

//this makes a limited stack of however many, help lowers the memory usage of the program compared to the stack class with no limitation
public class data_ImageBuffer {
	
	public int length;
	
	private int last, opening; // pointers to the ends of the arrays.
	
	private Graphics2D data[];
	
	public boolean isEmpty = true;
	
	data_ImageBuffer( int size)
	{
		length = size;
		data = new Graphics2D[length];
	}
	
	public void push(Graphics2D top)
	{
		isEmpty = false;
		if(opening == last)
		{
			last += ( last == (length-1) ) ? (1-length) : 1; //moves the pointer to the last data up ahead if it reaches the end
		}
		data[opening] = top;
		opening += ( opening == (length-1) ) ? (1-length) : 1;  //m
	}

	public Graphics2D pop(Graphics2D top) throws CanNotUndoException
	{
		if(isEmpty)
		{
			throw new CanNotUndoException();
		}
		else
		{
			opening += ( opening == 0) ? length-1 : (0-1); 
			isEmpty = (opening == last) ? true : false;  //checks to see if empty now. We know if it is because we just took one thing off the stack, and if moving the pointer to the new spot is the same spot as the last pointer, than we know we cleared the last of the data.
			return data[opening];
		}
	}
}
