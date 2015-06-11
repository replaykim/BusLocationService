package BusServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer implements Runnable {

	ServerSocket serverSocket;
	public String locationInformation;

	public MainServer() {		

		try {
			serverSocket = new ServerSocket(10002);
			System.out.println("서버 Start");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void broadcast(String msg) {
		locationInformation = msg;
		System.out.println("버스 정보 : " + msg);
	} // broadcast

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Socket sock = serverSocket.accept();			
				BufferedReader br = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));
				int checkInt = Integer.parseInt(br.readLine()); 

				if (checkInt == 1) {
					System.out.println(sock.getInetAddress() + "IP 주소의 버스가 접속했습니다.");
					BusServer busthread = new BusServer(sock, this, br);
					busthread.start();
				}
				
				else {
					System.out.println(sock.getInetAddress() + " 사용자가 접속했습니다.");
					WebServer webServer = new WebServer(sock, this, br);
					webServer.start();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} // while
	}
	
	public static void main(String[] args) {
		MainServer mainserver = new MainServer();
		mainserver.run();
	}
}
