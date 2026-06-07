/**
*Thusano Masalesa
*45312222
*/
import java.util.*;
import java.io.*;

public class Application
{
	public static final int MAX = 25;
	
	public static void main (String [] args)
	{
		SoccerTeam[] team = new SoccerTeam[MAX];
		int highestGames = 0;
		int i = 0;
		
		try
		{
			Scanner file = new Scanner(new File("soccerdata.txt"));
			
			while(file.hasNextLine())
			{
				String line = file.nextLine();
				String[] data = line.split("#");
				
				String teamNum = data[0];
				String name = data[1];
				
				char code = teamNum.charAt(0);
				
				if (code == 'A')
				{
					int goalsScored = Integer.parseInt(data[2]);
					int goalsConceed = Integer.parseInt(data[3]);
					
					team[i] = new AmSoccerTeam(teamNum, name, goalsScored, goalsConceed);
				}
				else if(code == 'P')
				{
					int gamesWon = Integer.parseInt(data[2]);
					int gamesTied = Integer.parseInt(data[3]);
					int gamesLost = Integer.parseInt(data[4]);
					
					team[i] = new ProSoccerTeam(teamNum, name, gamesWon, gamesTied, gamesLost);
				}
				
				i++;
				
			}
			
			
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not found error: " + ex);
			
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		
		System.out.println("List of teams:");
		
		for(SoccerTeam t: team) 
		{
			if(t instanceof AmSoccerTeam)
			{
				AmSoccerTeam tA = (AmSoccerTeam)t;
				
				System.out.println(tA.getTeamNum() + "   " + tA.getName() +  "   " + "Goals Scored: " + tA.getGoalsScored() + "   " + "Goals Conceeded: " + tA.getGoalsConceed());
			}
			else if (t instanceof ProSoccerTeam)
			{
				ProSoccerTeam tP = (ProSoccerTeam)t;
				
				System.out.println(tP.getTeamNum() + "   " + tP.getName() +  "   " + "Games won: " + tP.getGamesWon() + "   " + "Drawn: " + tP.getGamesTied()  + "   " + "Games lost: " + tP.getGamesLost());
				
				if (tP.getGamesWon() > highestGames)
				{
					highestGames = tP.getGamesWon();
				}
			}
			
		}
		
		System.out.println("\nTeam Ratings");
		System.out.println(String.format("%-10s %-20s %-10s", "Number", "Team name", "Rating"));
		
		for(SoccerTeam t: team) 
		{
			if(t instanceof AmSoccerTeam)
			{
				AmSoccerTeam tA = (AmSoccerTeam)t;
				
				System.out.println(String.format("%-10s %-20s %-10d", tA.getTeamNum(), tA.getName(), tA.getRating()));
			}
			else if (t instanceof ProSoccerTeam)
			{
				ProSoccerTeam tP = (ProSoccerTeam)t;
				
				System.out.println(String.format("%-10s %-20s %-10d", tP.getTeamNum(), tP.getName(), tP.getRating()));
			}
			
		}
		
		System.out.println("\nAmateur teams goal difference");
		
		System.out.println(String.format("%-10s %-20s %-10s", "Number", "Team name", "Difference"));
		
		for(SoccerTeam t: team) 
		{
			int difference = 0;
			
			if(t instanceof AmSoccerTeam)
			{
				AmSoccerTeam tA = (AmSoccerTeam)t;
				
				difference =  tA.getGoalsScored() - tA.getGoalsConceed();
				
				System.out.println(String.format("%-10s %-20s %-10d", tA.getTeamNum(), tA.getName(), difference));
			}
			
		}
		
		System.out.println("The team with the most games won is: " + highestGames);
		
		Arrays.sort(team, 0, i);
		
		System.out.println("\nList of teams after sort");
		
		
		for(SoccerTeam t: team) 
		{
			if(t instanceof AmSoccerTeam)
			{
				AmSoccerTeam tA = (AmSoccerTeam)t;
				
				System.out.println(tA.getTeamNum() + "   " + tA.getName() +  "   " + "Goals Scored: " + tA.getGoalsScored() + "   " + "Goals Conceeded: " + tA.getGoalsConceed());
			}
			else if (t instanceof ProSoccerTeam)
			{
				ProSoccerTeam tP = (ProSoccerTeam)t;
				
				System.out.println(tP.getTeamNum() + "   " + tP.getName() +  "   " + "Games won: " + tP.getGamesWon() + "   " + "Drawn: " + tP.getGamesTied()  + "   " + "Games lost: " + tP.getGamesLost());
			}
			
		}
		
		
	
		
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("teams.ser"));
			
			for(int j = 0; j <= i; j++)
			{
				out.writeObject(team[j]);
			}
			
			System.out.println("Objects saved to file");
			
			
		}
		catch(IOException ex)
		{
			System.out.println("Error writing to file: " + ex);
		}
		catch(Exception ex)
		{
			System.out.println("Error: " + ex);
		}
		
		
	}
	
	
}