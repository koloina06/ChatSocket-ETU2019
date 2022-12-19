package affichage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ecouteur.Listener;

public class Start extends JFrame{
	
	public Start() {
		this.setVisible(true);
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Traitement traitement= new Traitement();
		//this.add(traitement.create_server());
		this.add(traitement.enter_to_chat());
	}
	
	
}
