/**
*Thusano Masalesa
*45312222
*/
import java.util.*;
import java.io.*;

public abstract class SoccerTeam implements GetRating, Comparable<SoccerTeam>
{
	private String teamNum;
	private String name;
	
	public SoccerTeam() throws InvalidTeamNumberException
	{
		this("Unknown", "Unknown");
	}
	
	public SoccerTeam(String teamNum, String name) throws InvalidTeamNumberException
	{
		this.setTeamNum(teamNum);
		this.name = name;
		
	}
	
	public void setTeamNum(String teamNum) throws InvalidTeamNumberException
	{
		// Look at set method and variable its using, use that variable in the parameter and then whatever else is involved use the get method
		if (teamNum.charAt(0) != 'P' && teamNum.charAt(0) != 'A')
        {
            throw new InvalidTeamNumberException("Incorrect code: " + teamNum + " for team " + getName());
        }
        else if (teamNum.length() != 4)
        {
            throw new InvalidTeamNumberException("Team number " + teamNum + " must have length of 4");
        }
        else
        {
            try
            {
                int num = Integer.parseInt(teamNum.substring(1, 4));
            }
            catch (NumberFormatException ex)
            {
                throw new InvalidTeamNumberException("Last 3 characters of " + teamNum + " must be digits");
            }
        }

        this.teamNum = teamNum;

	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getTeamNum()
	{
		return teamNum;
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract int getRating();
	
	public int compareTo(SoccerTeam other)
	{
		String key1 = String.format("%-10s%05d", this.teamNum.charAt(0), this.getRating());
		String key2 = String.format("%-10s%05d", other.teamNum.charAt(0), other.getRating());
		
		return key1.compareTo(key2);
	}
	
	public String toString()
	{
		return "Team Number: " + teamNum + " Team Name: " + name;
	}
	
	
}