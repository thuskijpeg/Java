/**
*Thusano Masalesa
*453122222
*/
import java.util.*;
import java.io.*;


public class ProGamer extends Gamer implements RegistrationCode, RegistrationFee
{
	private int rank;
	private int regYears;
	private int age;
	
	public ProGamer()  throws InvalidIdException
	{
		this("000000", "Unknown", 0, 0);
	}
	
	public ProGamer(String idNum, String name, int rank, int regYears) throws InvalidIdException
	{
		super(idNum, name);
		this.rank = rank;
		this.regYears = regYears;
	}
	
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	
	public void setRegYears(int regYears)
	{
		this.regYears = regYears;
	}
	
	public int getRank()
	{
		return rank;
	}
	
	public int getRegYears()
	{
		return regYears;
	}
	
	public double calcRegFee()
	{
		double regFee = 500;
		double discountRegFee = 0;
		double discountRate = 0.05;
		
		if (regYears > 10)
		{
			discountRegFee = 250;
		}
		else if (regYears <= 10)
		{
			discountRegFee = regFee - (regFee * discountRate * regYears);
		}
		
		return discountRegFee;
		
	}
	
	public void determineAge()
	{
		// Use methods from parent class
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
	
	public String getRegCode()
	{
		String code = String.format("%s%02d%02d%s%02d", "P", rank, age, "-", regYears );
		
		return code;
		
	}



	public String toString()
	{
		return super.toString() + "Rank: " + rank + "Registration Years: " + regYears;
	}
	
	
}