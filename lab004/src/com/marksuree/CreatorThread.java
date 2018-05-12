package com.marksuree;

import static com.marksuree.Main.buffer;

/**
 * 
 * This class is responsible for writing data inside the buffer.
 */
public class CreatorThread extends Thread {
	
	public void run()
	{
		try
		{
			buffer.setBuffer(new String ("blablabla "));
		}
		catch(NullPointerException e)
		{
			System.out.println("CreatorThread problem");
		}
	}

}
