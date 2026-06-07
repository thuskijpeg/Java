/**
*Thusano Masalesa
*45312222
*/
import java.util.*;
import java.io.*;

//Implement serializable on object members
public class ProSoccerTeam extends SoccerTeam implements Serializable
{
	private int gamesWon;
	private int gamesTied;
	private int gamesLost;
	
	public ProSoccerTeam() throws InvalidTeamNumberException
	{
		this("Unknown", "Unknown", 0, 0, 0);
	}
	
	public ProSoccerTeam(String teamNum, String name, int gamesWon, int gamesTied, int gamesLost) throws InvalidTeamNumberException
	{
		super(teamNum, name);
		this.gamesWon = gamesWon;
		this.gamesTied = gamesTied;
		this.gamesLost = gamesLost;
	}
	
	public void setGamesWon(int gamesWon)
	{
		this.gamesWon = gamesWon;
	}
	
	public void setGamesTied(int gamesTied)
	{
		this.gamesTied = gamesTied;
	}
	
	public void setGamesLost(int gamesLost)
	{
		this.gamesLost = gamesLost;
	}
		
	public int getGamesWon()
	{
		return gamesWon;
	
	}
	
	public int getGamesTied()
	{
		return gamesTied;
	}
	
	
	public int getGamesLost()
	{
		return gamesLost;
	}
	
	
	public int getRating()
	{
		return (3 * gamesWon + gamesTied - 2 * gamesLost) * 200 / (gamesWon + gamesTied + gamesLost);
	}
	
	
	public String toString()
	{
		return super.toString() + "Games Won: " + gamesWon + "Games Tied: " + gamesTied + "Games Lost: " + gamesLost;
	}
	
}
	