package affichage;

import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import client.Client;
import ecouteur.Listener;

public class Creation {
	 JTextArea textArea;
	 Client client;
	Socket socket;
	JFileChooser fileChooser;
	
	public JFileChooser getfFileChooser(){
		return fileChooser;
	}

	public void setFilechooser(JFileChooser fichier){
		this.fileChooser=fichier;
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JPanel enter_to_chat() {
		 JPanel panel= new JPanel();
		 panel.setLayout(null);
		 JLabel label= new JLabel("Entrer votre nom: ");
		 label.setBounds(0,20,200,30);
		 JTextField textField= new JTextField();
		 textField.setBounds(150, 20, 200, 30);
		 JButton boutton= new JButton("Valider");
		 boutton.addMouseListener(new Listener(boutton,textField,this));
		 boutton.setBounds(150, 100, 100, 30);
		 panel.add(label);
		 panel.add(textField);
		 panel.add(boutton);
		 return panel;
	}
	
	public JFrame show_chat(String username) {
		JFrame jFrame= new JFrame();
		jFrame.setSize(600,600);
		jFrame.setVisible(true);
		JPanel panel= new JPanel();
		panel.setLayout(null);
		JLabel label= new JLabel(username);
		label.setBounds(20, 20, 100, 50);
		JTextField textField= new JTextField();
		textField.setBounds(70, 20, 200,30);
		textField.setName("Votre message");
		JButton boutton= new JButton("Send");
		 boutton.setBounds(250, 20, 100, 20);
		 textArea= new JTextArea();
		 textArea.setBounds(20, 100, 500, 300);
		 boutton.addMouseListener(new Listener(boutton,textField,this,textArea));
		 JButton choice= new JButton("Choose file");
		 choice.addMouseListener(new Listener(choice,this));
		 choice.setBounds(350, 20, 100, 20);
		 JButton file= new JButton("Send file");
		 file.addMouseListener(new Listener(file,this));
		 file.setBounds(450, 20, 100, 20);
		 panel.add(choice);
		 panel.add(file);
		 panel.add(label);
		 panel.add(textField);
		 panel.add(boutton);
		 panel.add(textArea);
		 jFrame.add(panel);
		return jFrame;
	}

	public JPanel choose_chat(){
		JPanel content= new JPanel();
		JButton group= new JButton("group");
		return content;
	}

	
}
