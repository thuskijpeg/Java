/**
*Thusano Masalesa
*45312222
*/
import java.util.*;
import java.io.*;

public class ReadObjects implements Serializable
{
	public static void main (String [] args)
	{
		
		System.out.println("List of teams");
		
		try
		{	
		    ObjectInputStream in = new ObjectInputStream(new FileInputStream("teams.ser"));
		
		    Object obj;
		
		    while(true)
		    {
				obj = in.readObject();
				
				if (obj instanceof AmSoccerTeam)
			    {
				    AmSoccerTeam tA = (AmSoccerTeam)obj;
					
					System.out.println(tA.getTeamNum + " " + tA.getName);
				}
				else if (obj instanceof ProSoccerTeam)
				{
					ProSoccerTeam tP = (ProSoccerTeam)obj;
					
					System.out.println(tP.getTeamNum + " " + tP.getName);
				}
				
			}

			
		catch(ClassNotFoundException ex)
		{
			System.out.println("Error: " + ex);
		}
		catch(EOFException ex)
		{
			System.out.println("End of file reached");
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
			
		
	}
	
}