import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface extends JFrame implements ActionListener{
JButton click=new JButton("click to do the job");
JLabel pl=new JLabel("Players:");
//TextField p=new TextField();
String[] optionsp= {"1","2","3","4"};
JComboBox<String> p=new JComboBox<String>(optionsp);

JLabel tl=new JLabel("Teams per Player:");
//TextField t=new TextField();
String[] optionst= {"1","2","3"};
JComboBox<String> t=new JComboBox<String>(optionst);

JLabel rl=new JLabel("Rematch?");
//TextField r=new TextField();
String[] options= {"yes","no"};
JComboBox<String> r=new JComboBox<String>(options);
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
		
		rl.setBounds(100, 220, 100, 20);

		r.setBounds(100, 250, 100, 20);
		r.setEditable(true);
			add(rl);
			add(r);
//	p.addActionListener(this);
	click.setBounds(100, 280, 200, 20);
	add(click);
	click.addActionListener(this);
//	Reader reader=new Reader();
//	reader.read();
}
@Override
public void actionPerformed(ActionEvent event) {
	Object source=event.getSource();
	if(source==click)
	{
		MatchMaker maker=new MatchMaker();
		String pl,te,re;
		pl=(String) p.getSelectedItem();
		
		te=(String) t.getSelectedItem();
		
		re=(String) r.getSelectedItem();
	
		maker.setPlayers(Integer.parseInt(pl));
		maker.setTeamsPerPlayer(Integer.parseInt(te));
		switch(re) {
		case "yes":
			maker.setRematch(true);
			break;
		case "no":
			maker.setRematch(false);
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
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

for(Player pla:players)
{
	for(int i=0;i<pla.teams.size();i++)
			{
System.out.println(pla.teams.get(i));
			}
}
//List<String> someList = new ArrayList<String>();
////add "monkey", "donkey", "skeleton key" to someList
//for (String item : someList) {
// System.out.println(item);
//}


	}
//	System.out.println(maker.getPlayers());
//	System.out.println(maker.getTeamsPerPlayer());
//	System.out.println(maker.isRematch());
	
//	try {
////		maker.rand();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	}	
//		maker.setRematch(Integer.parse);
//String temp=p.getText();
		
		//maker.setPlayers(Integer.parseInt(temp));
//		System.out.println(maker.getPlayers());
}
	// TODO Auto-generated method stub
public static void main(String[] args) throws IOException
{
	Interface in=new Interface();
	in.setVisible(true);
}
}
