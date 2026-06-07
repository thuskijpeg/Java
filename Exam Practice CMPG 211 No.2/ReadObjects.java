/**
*Thusano Masalesa
*453122222
*/
import java.io.*;

public class ReadObjects
{
	
	public static void main(String [] args)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("gamers.ser"));
			
			Object obj;
			
			System.out.println("List of gamers");
			
			while(true)
			{
				obj = in.readObject();
				
				if(obj instanceof AmGamer)
				{
					AmGamer gA = (AmGamer)obj;
					
					System.out.println(String.format("%-15s %-20s", gA.getIdNum(), gA.getName()));
				}
					
				else if(obj instanceof ProGamer)
				{
					ProGamer gP = (ProGamer)obj;
					
					System.out.println(String.format("%-15s %-20s", gP.getIdNum(), gP.getName()));
					
				}
				
			}
			
		}
		catch (EOFException ex)
        {
            System.out.println(ex);
        }
		catch (Exception ex)
        {
           System.out.println(ex);
        }
		//Can use ClassNotFoundException.
	}
	
}