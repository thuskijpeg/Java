import java.util.*;


public class Vehicle implements Comparable<Vehicle>
{
	private String make;
	private int year;
	
	public Vehicle() throws IllegalYearException
	{
		this("", 0);
	}	
	
	public Vehicle (String make, int year) throws IllegalYearException
	{
		this.make = make;
		setYear(year);
	
	}
	
	public void setMake(String make)
	{
		this.make = make;
	}
	
	public void setYear(int year) throws IllegalYearException
	{
		
        if (year < 0)
		{
			throw new IllegalYearException("Invalid Year. Please Enter Valid Year");
		}
		
		this.year = year;
		
	}
	
	public int getYear()
	{
		return year;
	}
	
	public String getMake()
	{
		return make;
	}
	
	@Override
	public String toString()
	{
		return "Make: " + make + "\nYear: " + year;
	
	}
	
	public int compareTo(Vehicle other)
	{
		String key1 = String.format("%05d%-10s", this.year, this.make);
		String key2 = String.format("%05d%-10s", other.year, other.make);
		
		return key1.compareTo(key2);
		
	}



}