/**
*Thusano Masalesa
*45312222
*/
import java.util.*;
import java.io.*;

//Implement serializable on object members
public class AmSoccerTeam extends SoccerTeam implements Serializable
{
	private int goalsScored;
	private int goalsConceed;
	
	public AmSoccerTeam() throws InvalidTeamNumberException
	{
		this("Unknown", "Unknown", 0, 0);
	}
	
	public AmSoccerTeam(String teamNum, String name, int goalsScored, int goalsConceed) throws InvalidTeamNumberException
	{
		super(teamNum, name);
		this.goalsScored = goalsScored;
		this.goalsConceed = goalsConceed;
	}
	
	public void setGoalsScored(int goalsScored)
	{
		this.goalsScored = goalsScored;
	}
	
	public void setGoalsConceed(int goalsConceed)
	{
		this.goalsConceed = goalsConceed;
	}
	
	public int getGoalsScored()
	{
		return goalsScored;
	
	}
	
	public int getGoalsConceed()
	{
		return goalsConceed;
	}
	
	
	public int getRating()
	{
		return (4 * goalsScored - 3 * goalsConceed) * 200 / (goalsScored + goalsConceed);
	}
	
	
	
	public String toString()
	{
		return super.toString() + "Goals Scored: " + goalsScored + "Goals Conceeded: " + goalsConceed;
		
	}
	
	
	
}