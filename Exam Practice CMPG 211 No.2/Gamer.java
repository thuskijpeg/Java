/**
*Thusano Masalesa
*453122222
*/
import java.util.*;
import java.io.*;


public abstract class Gamer implements Comparable<Gamer>, Serializable
{
	private String idNum;
	private String name;
	
	public Gamer() throws InvalidIdException
	{
		this("000000", "Unknown");
	}
	
	public Gamer(String idNum, String name) throws InvalidIdException
	{
		this.setIdNum(idNum); // Remember: Neccessary for declaring exception in the method.
		this.name = name;
	}
	
	public void setIdNum(String idNum) throws InvalidIdException
	{
		int num;
		
		try
		{
			num = Integer.parseInt(idNum);
		}
		catch(NumberFormatException ex)
		{
			throw new InvalidIdException("Incorrect ID format: Length must be 6 and may only contain digits: ID = " + idNum);	
		}
		
		if (num > 999999)
		{
			throw new InvalidIdException("Incorrect ID length: Must be 6 digits. ID = " + idNum);	
		}
			
		this.idNum = idNum;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}


	public String getIdNum()
	{
		return idNum;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract String getRegCode();
	
	public abstract double calcRegFee();
	
	public int compareTo(Gamer other)
	{
		return this.idNum.compareTo(other.idNum);
	}
	
	public String toString()
	{
		return "ID: " + idNum + "Name: " + name;
		
	}
	
	
}