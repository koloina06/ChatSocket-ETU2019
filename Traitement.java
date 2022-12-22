package affichage;

import java.net.Socket;
import java.util.Vector;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import client.Client;
import ecouteur.Listener;

public class Traitement {
	 JTextArea textArea;
	Client client;
	Socket socket;
	JFileChooser fileChooser;
	int port;
	String host;
	String username;
	JPanel panel;
	JTextArea connected;
	

	public JTextArea getConnected() {
		return connected;
	}

	public void setConnected(JTextArea connected) {
		this.connected = connected;
	}

	public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

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

	public JPanel create_server() {
		JPanel panel= new JPanel();
		panel.setLayout(null);
		JLabel label= new JLabel("Entrer un port: ");
		label.setBounds(0,20,200,30);
		JTextField textField= new JTextField();
		textField.setBounds(150, 50, 200, 30);
		JButton server= new JButton("Start server");
		server.addMouseListener(new Listener(server,textField,this));
		server.setBounds(150, 100, 200, 30);
		panel.add(server);
		panel.add(label);
		panel.add(textField);
		return panel;
   }

   public JPanel enter_to_chat() {
		// JFrame frame= new JFrame();
		// frame.setSize(400,500);
		// frame.setVisible(true);
		JPanel panel= new JPanel();
		panel.setLayout(null);
		JLabel label= new JLabel("Entrer votre nom: ");
		label.setBounds(0,20,200,30);
		JLabel host= new JLabel("Host: ");
		host.setBounds(0,100,200,30);
		int y=50;
		JTextField[] textField= new JTextField[2];
		for(int i=0; i<textField.length; i++){
			textField[i]= new JTextField();
			textField[i].setBounds(150, y, 200, 30);
			panel.add(textField[i]);
			y=y+50;
		}
		JButton boutton= new JButton("Se connecter");
		boutton.addMouseListener(new Listener(boutton,textField,this));
		boutton.setBounds(100, 200, 200, 30);
		panel.add(label);
		panel.add(host);
		panel.add(boutton);
		//frame.add(panel);
		return panel;
}

	
	public JFrame show_chat(String username) {
		JFrame jFrame= new JFrame();
		jFrame.setSize(500,500);
		jFrame.setVisible(true);
		panel= new JPanel();
		panel.setLayout(null);
		JLabel label= new JLabel(username);
		label.setBounds(20, 20, 100, 50);
		JTextField textField= new JTextField();
		textField.setBounds(70, 20, 200,30);
		textField.setName("Votre message");
		JButton boutton= new JButton("Send");
		 boutton.setBounds(300, 20, 100, 20);
		 Font font = new Font(Font.DIALOG,  Font.BOLD, 15);
		 textArea= new JTextArea();
		 textArea.setBounds(20, 100, 300, 300);
		 textArea.setBackground(Color.BLACK);
		 textArea.setFont(font);
		 textArea.setForeground(Color.white);
		 boutton.addMouseListener(new Listener(boutton,textField,this,textArea));
		 panel.add(label);
		 panel.add(textField);
		 panel.add(boutton);
		 panel.add(textArea);
		 jFrame.add(panel);
		return jFrame;
	}

}
