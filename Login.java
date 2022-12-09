package affichage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ecouteur.Listener;

public class Login extends JFrame{
	
	public Login() {
		this.setVisible(true);
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Creation creation= new Creation();
		this.add(creation.enter_to_chat());
	}
	
	
}
