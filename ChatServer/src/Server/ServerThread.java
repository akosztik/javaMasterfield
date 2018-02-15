package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		start();
	}

	@Override
	public void run() {
		//InputStreamReader isr=null;
		try {
			InputStreamReader isr = new InputStreamReader(sock.getInputStream());
			BufferedReader br= new BufferedReader(isr);
			while(true) {
				String text=br.readLine();
				if(text==null) {
					throw new Exception("Kliens kilépett! ");
				}
				//System.out.println(text);
				for (int i = 0; i < threads.size(); i++) {
					threads.elementAt(i).netWrite(text);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			threads.remove(this);
		}
	
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
 