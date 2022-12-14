package serveur;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

import client.*;



public class Server {
	  ServerSocket serveurSocket ;
	  Socket clientSocket ;
	  
	 public Server(ServerSocket serveurSocket) {
		  this.setServeurSocket(serveurSocket);
	  }
 
	 public ServerSocket getServeurSocket() {
		return serveurSocket;
	}

	public void setServeurSocket(ServerSocket serveurSocket) {
		this.serveurSocket = serveurSocket;
	}

	public void start_server(JTextArea textArea) {
		 try {
			 while(!serveurSocket.isClosed()) {
				 clientSocket = serveurSocket.accept();
				 All_client clients= new All_client(clientSocket);
				 System.out.println(clients.getClient_name()+ " est connecte");
				 textArea.append(clients.getClient_name()+ " est connecte \n");
				 Thread thread= new Thread(clients);
				thread.start();
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	
	public void close_server() {
			try {
				if(serveurSocket!=null) {
					serveurSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	
}
