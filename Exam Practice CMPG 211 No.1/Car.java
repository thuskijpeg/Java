public class Car extends Vehicle
{
	private int numOfDoors;
	public static int numCars;
	
	// Both exceptions cause they inherit
	public Car() throws IllegalYearException, IllegalNumOfDoorsException
	{
		this("", 0, 0);
		
	}
	
	
	public Car(String make, int year, int numOfDoors) throws IllegalYearException, IllegalNumOfDoorsException
	{
		super(make, year);
		setNumOfDoors(numOfDoors); // Use set, not this cause of exceptions
		numCars++;
	}
	
	public void setNumOfDoors(int numOfDoors) throws IllegalYearException, IllegalNumOfDoorsException
	{
		if(numOfDoors < 0)
		{
			throw new IllegalNumOfDoorsException("Invalid number of doors");
		}
		
		this.numOfDoors = numOfDoors;
	}
	
	public int getNumOfDoors()
	{
		return numOfDoors;
	}
	
	public int getNumOfCars()
	{
		return numCars;
	}
	
	public String toString()
	{
		return super.toString() + "\nDoors: " + numOfDoors;
	}
}