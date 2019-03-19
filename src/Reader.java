import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	private ArrayList<String> teams;
	public Reader() throws IOException
	{
		teams=new ArrayList<String>();
	}
public void read() throws IOException  
{
	//String file_location=System.getProperty("user.dir")+"/teams.txt";
	
	FileReader file=new FileReader(System.getProperty("user.dir")+"//src//teams.txt");
	//FileReader file=new FileReader(file_location);
	if(file.equals(null))
		System.out.println("file error");
BufferedReader reader=new BufferedReader(file);
if(reader.equals(null))
	System.out.println("reader error");
String temp="";
while((temp=reader.readLine())!=null)
{
teams.add(temp);

}
reader.close();
file.close();

//System.out.println("successed");
}


public ArrayList<String> getTeams() {
	return teams;
}
public void setTeams(ArrayList<String> teams) {
	this.teams = teams;
}
public static void main(String[] args) throws IOException  
{
	Reader test=new Reader();
	test.read();
}
}
