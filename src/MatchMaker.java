import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MatchMaker {
private int players;
private int teamsPerPlayer;
private boolean rematch;

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

public ArrayList<String> rand() throws IOException {
	Reader reader=new Reader();
	reader.read();
	
	ArrayList<String> randingArray=reader.getTeams();
	ArrayList<String> resultTeams=new ArrayList<String>();
	
	Random rand;
	int counter=teamsPerPlayer;
	while(counter!=0)
	{
		rand=new Random();
	int randomValue=rand.nextInt(26);
	if(randingArray.get(randomValue)!=null)
	{
	resultTeams.add(randingArray.get(randomValue));
	randingArray.remove(randomValue);
	counter--;
	}
	}
	return resultTeams;
}
}
