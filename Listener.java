package ecouteur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import affichage.Creation;
import client.Client;
import javafx.stage.FileChooser;

public class Listener implements MouseListener{
	JButton boutton;
	JTextField tf;
	Creation creation;
	JTextArea textArea;
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public Listener(JButton boutton, JTextField tf, Creation creation, JTextArea textArea) {
		this.boutton=boutton;
		this.tf=tf;
		this.creation=creation;
		this.textArea=textArea;
	}
	
	public Listener(JButton boutton, JTextField tf, Creation creation) {
		this.boutton=boutton;
		this.tf=tf;
		this.creation=creation;
	}

	public Listener(JButton button, Creation creation){
		this.boutton=button;
		this.creation=creation;
	}

	public Listener(JButton button){
		this.boutton=button;
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		if(e.getSource() instanceof JButton) {
			JButton button= (JButton) e.getSource();
			if(button.getText()=="Valider") {
				creation.show_chat(tf.getText());
				String username= tf.getText();
				this.setUsername(username);
				Socket socket;
				try {
					socket = new Socket("127.0.0.1",5000);
					creation.setSocket(socket);
					Client client=new Client(creation.getSocket(), username);
					creation.setClient(client);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			if(button.getText()=="Send") {
				try {
					creation.getClient().miheno(creation.getTextArea());
					creation.getClient().send_message(tf.getText());
				} catch (Exception e1) {
					
				}
			}

			if(button.getText().equals("Choose file")){
				JFileChooser fileChooser= new JFileChooser();
				this.creation.setFilechooser(fileChooser);
				int dialogue= this.creation.getfFileChooser().showSaveDialog(null);
				this.creation.getfFileChooser().getSelectedFile();
				if(dialogue==JFileChooser.APPROVE_OPTION){

				}
			}
			if(button.getText().equals("Send file")){
				try {
					//creation.getClient().sendFile(this.creation.getfFileChooser().getSelectedFile(), creation.getSocket());
					//creation.getClient().receiveFile(this.creation.getfFileChooser().getSelectedFile(), creation.getTextArea());
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
