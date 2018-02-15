package Server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class ServerThread extends Thread {
	private Socket sock;
	private Vector<ServerThread> threads;
	
	public ServerThread(Socket sock, Vector<ServerThread> threads) {
		this.sock = sock;
		this.threads=threads;
	}

	@Override
	public void run() {
		
	}
	
	public void netWrite(String text) {
		try {
			OutputStream os = sock.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.println(text);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
 