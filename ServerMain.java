package serveur;
import java.net.ServerSocket;
import java.net.Socket;

import serveur.Online;
public class ServerMain {
    public static void main(String[] args) throws Exception {
		ServerSocket serverSocket= new ServerSocket(5000);
		Server server= new Server(serverSocket);
		Online co= new Online();
		server.start_server(co.getTextArea());
	}
}
