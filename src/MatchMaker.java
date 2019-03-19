import java.util.ArrayList;
import java.util.Random;

public class MatchMaker {
private int players;
private int teamsPerPlayer;
private boolean rematch;
ArrayList<String> randingArray;
int howMany;
public MatchMaker(ArrayList<String> readed)
{
	randingArray=readed;
	howMany=randingArray.size();
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
	while(counter>0)
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

public void getPairs(ArrayList<Player> players)
{
	int howManyTeams=getPlayers()*getTeamsPerPlayer();
	if(isRematch())
	{
	int howManyMatches=howManyTeams*((howManyTeams-1)*2);
	System.out.println(howManyMatches);
	}
	else
	{
		int howManyMatches=howManyTeams*(howManyTeams-1);
		System.out.println(howManyMatches);
	}
	ArrayList<Player> playersCopy=players;
	Random rand=new Random();
	int randomNumber=rand.nextInt(playersCopy.size());
	rand=new Random();
	int randomNumber2=rand.nextInt(playersCopy.get(randomNumber).teams.size());
	System.out.println(playersCopy.get(randomNumber).teams.get(randomNumber2));
	//playersCopy.remove(randomNumber);
	
	rand=new Random();
	randomNumber=rand.nextInt(playersCopy.size());
	rand=new Random();
	randomNumber2=rand.nextInt(playersCopy.get(randomNumber).teams.size());
	System.out.println(playersCopy.get(randomNumber).teams.get(randomNumber2));
	playersCopy.remove(randomNumber);
}

}
