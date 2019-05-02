import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	private ArrayList<String> teams;
	public Reader()
	{
		teams=new ArrayList<String>();
	}
public void read()
{
String[] teamss={"FC Barcelona",
		"Real Madrid",
		"FC Bayern",
		"Juventus",
		"Manchester City",
		"Atletico Madrid",
		"PSG",
		"Spurs",
		"Liverpool",
		"Chelsea",
		"Manchester United",
		"Inter",
		"Arsenal",
		"Napoli",
		"Milan",
		"Valencia CF",
		"Roma",
		"Lazio",
		"Villarreal CF",
		"Bor. Dortmund"};
	for(int i=0;i<teamss.length;i++)
	{
		teams.add(teamss[i]);
	}
}


public ArrayList<String> getTeams() {
	return teams;
}
public void setTeams(ArrayList<String> teams) {
	this.teams = teams;
}
public static void main(String[] args)
{
	Reader test=new Reader();
	test.read();
}
}
