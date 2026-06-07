/**
*Thusano Masalesa
*453122222
*/
import java.util.*;
import java.io.*;


public class AmGamer extends Gamer implements RegistrationCode, RegistrationFee
{
	
	private int category;
	private int age;
	
	public AmGamer()  throws InvalidIdException
	{
		this("000000", "Unknown", 0);
	}
	
	public AmGamer(String idNum, String name, int category) throws InvalidIdException
	{
		super(idNum, name);
		this.category = category;
		
	}
	
	public void setCategory(int category)
	{
		this.category = category;
		
	}
	
	
	public int getCategory()
	{
		return category;
	}
	
	public void determineAge()
	{
		// Use method names from parent class to access things from parent class
		String ageStr = getIdNum().substring(0,2);
		int yearPart = Integer.parseInt(ageStr);
		int year = 0;
		
		if (yearPart < 25)
		{
			year = Integer.parseInt("20" + yearPart);
		}
		else if (yearPart >= 25)
		{
			year = Integer.parseInt("19" + yearPart);
		}
		
		this.age = 2025 - year;
		
		
	}
	
	public double calcRegFee()
	{
		double regFee = 250;
		double discount = 0.2;
		
		if (age <= 18)
		{
			regFee = regFee - (regFee * discount);
		}
		
		return regFee;
	}
	
	public String getRegCode()
	{
		String code = "A" + getIdNum().substring(0, 5) + "-" + category;
		
		return code;
		
	}
	
	public String toString()
	{
		return super.toString() + "Catergory: " + category;
	}
	
	
	
}