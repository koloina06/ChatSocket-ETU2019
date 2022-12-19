package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.PublicKey;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Client {

	Socket clientSocket;
	 BufferedReader in;
	BufferedWriter out;
	 String username;
	 boolean anarana= true;
	 DataInputStream dis;
	 DataOutputStream dos;
	 FileInputStream fis;

	 public boolean isAnarana(){
		return this.anarana;
	 }

	 public void setAnarana(boolean anarana){
		this.anarana=anarana;
	 }
	 
	public Client(Socket clientSocket,String username) {
		try {
			this.clientSocket=clientSocket;
			this.username=username;
			out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
			 in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			 dis= new DataInputStream(clientSocket.getInputStream());
			dos= new DataOutputStream(clientSocket.getOutputStream());
		} catch (Exception e) {
			
		}
	}

	public void send_message(String message) {
		try {
			if(this.isAnarana()==true){
				out.write(username);
				out.newLine();
				out.flush();
				this.setAnarana(false);
			}
			 while(clientSocket.isConnected()) {
				 	out.write(username+ ":  "+ "  "+ message);
				 	out.newLine();
				 	out.flush();
					break;
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void miheno(JTextArea textArea) {
		new Thread(new Runnable() {
			public void run() {
				String all_message=null;
				while(clientSocket.isConnected()) {
					try {
							all_message= in.readLine();
							textArea.append(all_message+ "\n");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	public void private_chat(JTextArea textArea,String username,String user) {
		new Thread(new Runnable() {
			public void run() {
				String all_message=null;
				while(clientSocket.isConnected()) {
					try {
							if(username.equalsIgnoreCase(user)){
								all_message= in.readLine();
								textArea.append(all_message+ "\n");
							}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	
	public Socket getClientSocket() {
		return clientSocket;
	}

	public void setClientSocket(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public BufferedReader getIn() {
		return in;
	}

	public void setIn(BufferedReader in) {
		this.in = in;
	}

	public BufferedWriter getOut() {
		return out;
	}

	public void setOut(BufferedWriter out) {
		this.out = out;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void close_connection(Socket socket,BufferedReader in, BufferedWriter out) {
		try {
			if(in!=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
			if(socket!=null) {
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
