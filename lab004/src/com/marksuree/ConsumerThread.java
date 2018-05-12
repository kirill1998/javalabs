package com.marksuree;
import static com.marksuree.Main.buffer;

/**
 * 
 * This class create new thread to read data from buffer.
 *
 */
public class ConsumerThread extends Thread {
	
	public char[] result;
	
	public void run()
	{
		try {
			result = new char[buffer.getBuffer().length];
			for(int i = 0; i < buffer.getBuffer().length; i++)
				result[i] += buffer.getBuffer()[i];
			}
			catch(NullPointerException e)
			{
				System.out.println("ConsumerThread problem");
			}
			
		}
}
