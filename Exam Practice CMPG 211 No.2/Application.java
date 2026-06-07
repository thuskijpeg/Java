/**
*Thusano Masalesa
*453122222
*/
import java.util.*;
import java.io.*;


public class Application
{
	public static final int MAX = 25;
	
	public static void main(String [] args)
	{
		Gamer[] gamers = new Gamer[MAX];
		int i = 0;
		
		try
		{
			
			Scanner file = new Scanner(new File("gamers.txt"));
		
		    // Use hasNextLine, not hasNext, to check if there is a line
		    while(file.hasNextLine())
		    {
			    String line = file.nextLine();
			
			    String[] data = line.split("@");
			
			    String role = data[0];
			    String iD = data[1];
			    String name = data[2];
			
			    // Use .equals() for String comparison for if statements
			    if (role.equals("Amateur"))
			    {
				    int category = Integer.parseInt(data[3]);
				    gamers[i] = new AmGamer(iD, name, category);
			
			    }
			    else if (role.equals("Professional"))
			    {
				    int years = Integer.parseInt(data[3]);
				    int ranking = Integer.parseInt(data[4]);
				
				    gamers[i] = new ProGamer(iD, name, ranking, years);
			    }
			
			    i++;
		
		    }
		}
		catch (FileNotFoundException ex)
        {
            System.out.println("File not found: " + ex);
        }
		catch (Exception ex)
        {
           System.out.println(ex);
        }
        catch (InvalidIdException ex)
        {
            System.out.println(ex.getMessage());
        }
		// Add your created exception in situations that will trigger the throws exception.
		
		double discountAma = 0;
		double discountPro = 0;
		
		System.out.println("Amateur gamers");
		System.out.println(String.format("%-10s %-15s %-20s %-15s %-20s %-15s", "Code", "ID number", "Name", "Category", "Registration Fee", "Discount"));
		for (Gamer g: gamers)
		{
			double discount = 0;
			
		    if (g instanceof AmGamer)
		    {
			    AmGamer gA = (AmGamer)g;
				
				discount = 250 - gA.calcRegFee();
				discountAma += discount;
				
				System.out.println(String.format("%-10s %-15s %-20s %-15s R%-20.0f R%-15.0f", gA.getRegCode(), gA.getIdNum(), gA.getName(), gA.getCategory(), gA.calcRegFee(), discount));
			
		    }
			
		}
			
			
		System.out.println("\nProfessional gamers");
		System.out.println(String.format("%-10s %-15s %-20s %-10s %-10s %-20s R%-15s", "Code", "ID number", "Name", "Years", "Rank", "Registration Fee", "Discount"));
	
		for (Gamer g: gamers)
		{
			double discount = 0;
			
			if (g instanceof ProGamer)
		    {

			    ProGamer gP = (ProGamer)g;
				
				discount = 500 - gP.calcRegFee();
				discountPro += discount;
				
				System.out.println(String.format("%-10s %-15s %-20s %-10d %-10d R%-20.0f R%-15.0f", gP.getRegCode(), gP.getIdNum(), gP.getName(), gP.getRegYears(), gP.getRank(), gP.calcRegFee(), discount));
			
			
		    }
			
		}
		
		System.out.println("Total discount for Amateurs: " + discountAma);
		
		System.out.println("Total discount for Professionals: " + discountPro);
		
		//Partial sort, remember to avoid null values
		Arrays.sort(gamers, 0, i);
		
		System.out.println("\nAfter Sorting");
		System.out.println(String.format("%-10s %-15s %-20s %-15s", "Code", "ID number", "Name", "Discount"));
		
		for (Gamer g: gamers)
		{
			double discount = 0;
			
			if (g instanceof AmGamer)
		    {
			    AmGamer gA = (AmGamer)g;
				
				discount = 250 - gA.calcRegFee();
				
				System.out.println(String.format("%-10s %-15s %-20s %-15.0f", gA.getRegCode(), gA.getIdNum(), gA.getName(), discount));
			} 
			else if (g instanceof ProGamer)
			{
			    ProGamer gP = (ProGamer)g;
				
				discount = 500 - gP.calcRegFee();
				
				System.out.println(String.format("%-10s %-15s %-20s %-15.0f", gP.getRegCode(), gP.getIdNum(), gP.getName(), discount));
			}
			
		}
		
		
		try
		{
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("gamers.ser"));
			
			// Use normal for loop to avoid writing null objects.
		
		    for (int x = 0; x < i; x++)
            {
				
                out.writeObject(gamers[x]);
            }
			
			System.out.println("Objects saved to file.");
			out.close();
		
		    
		}
		catch(IOException ex)
		{
			System.out.println("Error writing to file: " + ex);
		}
		catch (Exception ex)
        {
           System.out.println(ex);
        }
		

	}
}
	
	
