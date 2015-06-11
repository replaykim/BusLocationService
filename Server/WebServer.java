package BusServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer extends Thread {
	private Socket sock;
	private BufferedReader br;
	private PrintWriter dataOut;
	private MainServer mainserver;
	private String locationInformation;

	public WebServer(Socket sock, MainServer mainserver, BufferedReader br) {
		this.sock = sock;
		this.mainserver = mainserver;
		try {
			this.br = br;
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void getLocation(){
		this.locationInformation = mainserver.locationInformation;
	}

	@Override
	public void run() {
		getLocation();
		System.out.println("버스 위치 : "+locationInformation);
		try {
			dataOut = new PrintWriter(sock.getOutputStream(), true);
			dataOut.println(locationInformation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
