package ecouteur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import affichage.Traitement;
import client.Client;
import serveur.Server;

public class Listener implements MouseListener{
	JButton boutton;
	JTextField tf;
	JTextField[] textFields;
	Traitement traitement;
	JTextArea textArea;
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public Listener(JButton boutton, JTextField[] textFields, Traitement traitement) {
		this.boutton=boutton;
		this.textFields=textFields;
		this.traitement=traitement;
	}

	public Listener(JButton button, Traitement traitement){
		this.boutton=button;
		this.traitement=traitement;
	}
	public Listener(JButton button,JTextField tf ,Traitement traitement){
		this.boutton=button;
		this.tf=tf;
		this.traitement=traitement;
	}

	

	public Listener(JButton button){
		this.boutton=button;
	}

	public Listener(JButton boutton,JTextField tf , Traitement traitement, JTextArea textArea) {
		this.boutton=boutton;
		this.tf=tf;
		this.traitement=traitement;
		this.textArea=textArea;
	}
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		if(e.getSource() instanceof JButton) {
			JButton button= (JButton) e.getSource();
			// if(button.getText().equalsIgnoreCase("Start server")) {
			// 	this.traitement.setPort(Integer.parseInt(this.tf.getText()));
			// 	try {
			// 		this.traitement.enter_to_chat();
			// 		ServerSocket serverSocket= new ServerSocket(this.traitement.getPort());
			// 		Server server= new Server(serverSocket);
			// 		server.start_server();
			// 	} catch (Exception e1) {
					
			// 	}
			// }

			if(button.getText()=="Se connecter") {
				this.traitement.setHost(textFields[1].getText());
				this.traitement.setUsername(textFields[0].getText());
				traitement.show_chat(this.traitement.getUsername());
				Socket socket;
				try {
					socket = new Socket(this.traitement.getHost(),5000);
					traitement.setSocket(socket);
					Client client=new Client(traitement.getSocket(),this.traitement.getUsername());
					traitement.setClient(client);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if(button.getText()=="Send") {
				try {
						traitement.getClient().miheno(traitement.getTextArea());
					traitement.getClient().send_message(tf.getText());
				} catch (Exception e1) {
					
				}
			}

		}
	}

	public void mouseReleased(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

}
