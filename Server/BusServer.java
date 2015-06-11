package BusServer;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

public class BusServer extends Thread {
	private Socket sock;
	private BufferedReader br;
	private MainServer mainserver;

	public BusServer(Socket sock, MainServer mainserver, BufferedReader br) {
		this.sock = sock;
		this.mainserver = mainserver;
		try {
			this.br = br;
		} catch (Exception ex) {
			System.out.println(ex);
		}
	} 

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String line = null;
			while ((line = br.readLine()) != null) { 
				int indexOf = line.indexOf("/");
				String busName = line.substring(0, indexOf);
				if (busName.equals("B")) {
					String offSet = line.substring(indexOf + 1);
					mainserver.broadcast("B:" + offSet);
				} else {
					
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			try {
				if (sock != null)
					sock.close();
			} catch (Exception ex) {
			}
		}
	}

}
