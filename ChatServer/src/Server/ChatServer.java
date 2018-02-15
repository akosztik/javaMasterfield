package Server;

import java.io.*;
import java.net.*;
import java.util.Vector;

public class ChatServer{

	public static void main(String[] args) {
		Vector<ServerThread> threads= new Vector<>();   //diamond szintaktika
		try {
			ServerSocket ss = new ServerSocket(1035);
			while (true) {
				Socket sock=ss.accept();
				ServerThread st =new ServerThread(sock,threads);// c�mszerinti �tad�s, ez�rt l�tja mindenki ha bel�p egy �j ember a chatszob�ba.
				threads.add(st);
				//st.netWrite("Hello!");
				
				System.out.println("kapcsolat �rkezett");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
