package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;

public class All_client implements Runnable {
	public static Vector<All_client> liste_client= new Vector<>();
	public Socket socket;
	String client_name;
	BufferedReader in;
	 BufferedWriter out;
	 DataInputStream dis;
	 DataOutputStream dos;
	 boolean username=true;

		public boolean isUsername() {
        return username;
    }

    public void setUsername(boolean username) {
        this.username = username;
    }

        public String getClient_name() {
			return client_name;
		}

		public void setClient_name(String client_name) {
			this.client_name = client_name;
		}

//	
	public All_client(Socket socket) {
		try {
			this.socket=socket;
			out= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			dis= new DataInputStream(socket.getInputStream());
			dos= new DataOutputStream(socket.getOutputStream());
			 this.setClient_name(in.readLine());
			 liste_client.add(this);
			// this.get_all_message(client_name+ " est connecte");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void run() {
		String msg;
		 try {
			 while(socket.isConnected()){
				 msg = in.readLine();
				 get_all_message(msg);
			 }
			out.close();
		 } catch (Exception e) {
	
		 }
	}

	public void get_all_message(String message) {
		for(All_client client : liste_client) {
			try {
					client.out.write(message);
					client.out.newLine();
					client.out.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public void remove_client() {
		liste_client.remove(this);
		get_all_message("client "+client_name+" deconnecte");
	}
	
	public void close_connection(Socket socket,BufferedReader in, BufferedWriter out) {
		remove_client();
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
