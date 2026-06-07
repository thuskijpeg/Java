/**
 * Thusano Masalesa
 * 453122222
 */

import java.util.*;
import java.io.*;

public class TestException
{
	public static final int MAX = 25;
	
    public static void main(String[] args)
    {
		Gamer[] gamers = new Gamer[MAX];
		
        try
        {
            Scanner file = new Scanner(new File("invalid.txt"));

            int i = 0;

            // Use hasNextLine, not hasNext, to check if there is a line
            while (file.hasNextLine())
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
        
    }
}