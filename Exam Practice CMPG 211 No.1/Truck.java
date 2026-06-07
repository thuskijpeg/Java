public class Truck extends Vehicle
{
	private double loadCapacity;
	public static int numTrucks;
	
	
	// Both exceptions cause they inherit
	public Truck() throws IllegalYearException, IllegalLoadCapacityException
	{
		this("", 0, 0);
	}
	

	public Truck(String make, int year, double loadCapacity) throws IllegalYearException, IllegalLoadCapacityException
	{
		super(make, year);
		setLoadCapacity(loadCapacity); // Use set, not this cause of exceptions
		numTrucks++;
		
	}
	
	public void setLoadCapacity(double loadCapacity) throws IllegalYearException, IllegalLoadCapacityException
	{
		if (loadCapacity < 0)
		{
			throw new IllegalLoadCapacityException("Invalid load capacity");
		}
		
		this.loadCapacity = loadCapacity;
	}
	
	public double getLoadCapacity()
	{
		return loadCapacity;
	}
	
	public int getNumOfTrucks()
	{
		return numTrucks;
	}
	
	
	public String toString()
	{
		return super.toString() + "\nCapacity: " + loadCapacity;
	}
}



