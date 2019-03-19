import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MatchMaker {
private int players;
private int teamsPerPlayer;
private boolean rematch;
ArrayList<String> randingArray;
int howMany=26;
public MatchMaker(ArrayList<String> readed)
{
	randingArray=readed;
}
public int getPlayers() {
	return players;
}
public void setPlayers(int players) {
	this.players = players;
}

public int getTeamsPerPlayer() {
	return teamsPerPlayer;
}
public void setTeamsPerPlayer(int teamsPerPlayer) {
	this.teamsPerPlayer = teamsPerPlayer;
}

public boolean isRematch() {
	return rematch;
}
public void setRematch(boolean rematch) {
	this.rematch = rematch;
}

public ArrayList<String> rand() {
	
	ArrayList<String> resultTeams=new ArrayList<String>();
	
	Random rand;
	int counter=teamsPerPlayer;
	while(counter!=0)
	{
		rand=new Random();
	int randomValue=rand.nextInt(howMany);
	
	resultTeams.add(randingArray.get(randomValue));
	randingArray.remove(randomValue);
	counter--;
	howMany--;
	}
	return resultTeams;
}
}
