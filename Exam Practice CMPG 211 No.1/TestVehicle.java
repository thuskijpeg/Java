import java.util.*;

public class TestVehicle
{
	public static final int MAX_VEHICLES = 3;
	
	
	public static void displayVehicles(Vehicle[] vehicles)
	{
		
		for(Vehicle v: vehicles)
		{
			if (v instanceof Car)
			{
				Car c = (Car)v;
				
				System.out.println("==Car==");
				
				System.out.println(c);
			
			
			}
			else if (v instanceof Truck) 
			{
				Truck t = (Truck)v;
				
			    System.out.println("==Car==");
				System.out.println(t);
				
				
			}
			
		}
		
		System.out.println("==Totals==");
		System.out.println("Total Cars: " + Car.numCars);
		System.out.println("Total Trucks: " + Truck.numTrucks);
		
		
		
	}
	
	public static void sortVehicles(Vehicle[] vehicles)
	{
		Arrays.sort(vehicles);
	}
	
	
	public static void main (String [] args)
	{
		
		
		try
		{
			Vehicle[] vehicles = new Vehicle[MAX_VEHICLES];
		
		    vehicles[0] = new Car("BMW", 2018, 4);
			vehicles[1] = new Truck("Toyotla", 2029, 5559.8);
			vehicles[2] = new Car("Ford", 2024, 2);
			
			displayVehicles(vehicles);
            sortVehicles(vehicles);
			displayVehicles(vehicles);
			
		}
		catch(IllegalYearException ex)
		{
			
			System.out.println(ex.getMessage());
			System.exit(0);
		
			
			
		}
		catch(IllegalNumOfDoorsException ex)
		{
			
			System.out.println(ex.getMessage());
			System.exit(0);
			
		}
		catch(IllegalLoadCapacityException ex)
		{
			
			System.out.println(ex.getMessage());
			System.exit(0);
			
		}
		
		
	}
	
}