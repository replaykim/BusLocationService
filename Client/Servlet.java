
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/BusServlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String locationInformation;
	private String latitude;
	private String longitude;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		test();
		out.println("setMarker("+latitude+","+longitude+");");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void test() {

		Socket socket = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {
			
			String IP = "*.*.*.*"; // Server IP
			int port = 10002; // Port Number
			
			socket = new Socket(IP, port); 
			PrintWriter dataOut = new PrintWriter(socket.getOutputStream(), true);
			dataOut.println("2");
						
			reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			
			locationInformation = reader.readLine();
			System.out.println("위치 정보 : " + locationInformation);
			
			int indexOf1 = locationInformation.indexOf(":");
			int indexOf2 = locationInformation.indexOf("/");
			latitude = locationInformation.substring(indexOf1 + 1, indexOf2);
			longitude = locationInformation.substring(indexOf2 + 1);	
			
			

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// 자원해제
			if (reader != null)
				try {
					reader.close();
				} catch (Exception e) {
				}
			if (writer != null)
				try {
					writer.close();
				} catch (Exception e) {
				}
			if (socket != null)
				try {
					socket.close();
				} catch (Exception e) {
				}
		}
	}
}
