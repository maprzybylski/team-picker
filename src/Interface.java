import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Interface extends JFrame implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton click=new JButton("START");
JLabel pl=new JLabel("Players:");
//TextField p=new TextField();
String[] optionsp= {"1","2","3","4"};
JComboBox<String> p=new JComboBox<String>(optionsp);

JLabel tl=new JLabel("Teams per Player:");
//TextField t=new TextField();
String[] optionst= {"1","2","3"};
JComboBox<String> t=new JComboBox<String>(optionst);

JLabel sv =new JLabel("Save to text file?");
String[] options= {"yes","no"};
JComboBox<String> s =new JComboBox<String>(options);
boolean ifSave=false;
public Interface() throws IOException
{
	setSize(640,480);
	setTitle("Team Picker");
	setLayout(null);

	pl.setBounds(100, 100, 100, 20);

p.setBounds(100, 130, 100, 20);
p.setEditable(true);
	add(pl);
	add(p);
	
	tl.setBounds(100, 160, 150, 20);

	t.setBounds(100, 190, 100, 20);
	t.setEditable(true);
		add(tl);
		add(t);
		
		sv.setBounds(100, 220, 100, 20);

		s.setBounds(100, 250, 100, 20);
		s.setEditable(true);
			add(sv);
			add(s);
//	p.addActionListener(this);
	click.setBounds(100, 280, 200, 20);
	add(click);
	click.addActionListener(this);
}
@Override
public void actionPerformed(ActionEvent event){
	Object source=event.getSource();
	if(source==click)
	{
try {
	setMaker();
	dispose();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
}
	// TODO Auto-generated method stub

public void setMaker() throws IOException
{
	Reader reader=new Reader();
	reader.read();
	MatchMaker maker=new MatchMaker(reader.getTeams());
	String pl,te,sav;
	pl=(String) p.getSelectedItem();
	
	te=(String) t.getSelectedItem();
	
	sav=(String) s.getSelectedItem();

	if((Integer.parseInt(pl)*Integer.parseInt(te))<26)
	{
	maker.setPlayers(Integer.parseInt(pl));
	maker.setTeamsPerPlayer(Integer.parseInt(te));
	switch(sav) {
	case "yes":
		ifSave=true;
		break;
	case "no":
		ifSave=false;
		break;
		default:
			break;
	
	}
ArrayList<Player> players=new ArrayList<Player>();
for (int i=0;i<maker.getPlayers();i++)
{
try {
	players.add(new Player(JOptionPane.showInputDialog("What is your name?"),maker.rand()));
} catch (HeadlessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

		for(int i=0;i<players.size();i++)
		{
			String playerTeams="";
			for(int j=0;j<players.get(i).teams.size();j++) {
				playerTeams+=players.get(i).teams.get(j);

				if(players.get(i).teams.size()>1) {
					if(players.get(i).teams.size()>j+1)
						playerTeams += ", ";
				}
				if(players.get(i).teams.size()==1||players.get(i).teams.size()-1==j)
				{
					playerTeams+=".";
				}
			}
			JOptionPane.showMessageDialog(this, players.get(i).name+": "+playerTeams);
		}

if(ifSave) {
	Saver saver = new Saver();
	saver.save(players);
}
	}
	else
	{
		JOptionPane.showMessageDialog(this, "Too many players&teams, MAX 25");
		dispose();
	}
}
public static void main(String[] args) throws IOException
{
	
	Interface in=new Interface();
	in.setVisible(true);
}
}
