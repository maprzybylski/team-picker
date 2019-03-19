import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends JFrame implements ActionListener{
JButton click=new JButton("click to random teams");
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
	add(pl);
	add(p);
	
	tl.setBounds(100, 160, 200, 20);

	t.setBounds(100, 190, 100, 20);
		add(tl);
		add(t);
		
		rl.setBounds(100, 220, 100, 20);

		r.setBounds(100, 250, 100, 20);
			add(rl);
			add(r);
//	p.addActionListener(this);
	//click.setBounds(100, 160, 100, 20);
	add(click);
	click.addActionListener(this);
	Reader reader=new Reader();
	reader.read();
}
@Override
public void actionPerformed(ActionEvent event) {
	Object source=event.getSource();
	if(source==click)
	{
		MatchMaker maker=new MatchMaker();
		
//String temp=p.getText();
		
		//maker.setPlayers(Integer.parseInt(temp));
//		System.out.println(maker.getPlayers());
	}
	// TODO Auto-generated method stub
	
}
public static void main(String[] args) throws IOException
{
	Interface in=new Interface();
	in.setVisible(true);
}
}
