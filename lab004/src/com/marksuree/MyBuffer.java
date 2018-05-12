package com.marksuree;

/**
 * 
 *This class implements buffer for data.
 */
public class MyBuffer {
	
private int size = 50;
private char[] buffer;
private int offset;
public static Boolean isBufferFull = false;

/**
 * Default constructor with field's values
 */
public MyBuffer()
{
	buffer = new char[size];
	isBufferFull = false;
	offset = 0;
}

/**
 * Getter for consumer
 * @return buffer The field, that contains data.
 */
public synchronized char[] getBuffer()
{
	return buffer;
}
	
/**
 * Setter for creator.Add new chars inside the buffer, while size allows. 
 * @param defaultStr Parameter, which contains unique data, which was generated in creator
 */
public synchronized void setBuffer(String defaultStr)
{
	char[] defaultChar;
	defaultChar = defaultStr.toCharArray();
	
	int countOfAvailableChars = size - offset;
	
	if(countOfAvailableChars >= defaultChar.length)
	{
		int i, j = 0;
		for(i = offset; i < (offset + defaultChar.length); i++, j++)
		{
			buffer[i] = defaultChar[j];	
		}
		offset = i;
	}
	else
	{
		int i, j = 0;
		for(i = offset; i < countOfAvailableChars; i++, j++)
		{
			buffer[i] = defaultChar[j];	
		}
		offset = 0;
		isBufferFull = true;
	}
}
}
