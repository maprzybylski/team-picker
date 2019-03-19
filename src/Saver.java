import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Saver {
	public void save(ArrayList<Player> array) throws IOException  
	{
		FileWriter file=new FileWriter(System.getProperty("user.dir")+"//src//result.txt");
		//FileReader file=new FileReader(file_location);
		if(file.equals(null))
			System.out.println("file error");
	BufferedWriter writer=new BufferedWriter(file);
	if(writer.equals(null))
		System.out.println("writer error");

	for (int i=0;i<array.size();i++)
	{
		writer.write(array.get(i).name+"\r");
		writer.write("-----------------------\r");
	for(int j=0;j<array.get(i).teams.size();j++)
	{
	writer.write(array.get(i).teams.get(j)+"\r");
	}
	writer.write("-----------------------\r");
	}
	
	
	
	writer.close();
	file.close();
	}
	
//	public void saveMatches()
//	{
//		
//	}
}
