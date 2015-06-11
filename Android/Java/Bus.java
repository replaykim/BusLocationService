package com.example.busclientb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class Bus extends Activity implements LocationListener {

	static Socket socket1;
	static PrintWriter dataOut;
	private boolean check;
	private LocationManager locationManager;
	private BufferedReader br;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		new NetworkTask().execute();
		locationManager = (LocationManager) this
				.getSystemService(Context.LOCATION_SERVICE);

		locationManager.requestLocationUpdates("network", 1000, 1, Bus.this);
		check = false;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		double lat = location.getLatitude();
		double lng = location.getLongitude();

		Toast.makeText(Bus.this, "위도  : " + lat + " 경도: " + lng,
				Toast.LENGTH_SHORT).show();

		String y = "B/" + lat + "/" + lng;
		if (check == true)
			dataOut.println(y);
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	public class NetworkTask extends AsyncTask<Void, String, Void> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			try {
				// 연결 보내기
				socket1 = new Socket("*.*.*.*", 10002);
				check = socket1.isConnected();
				dataOut = new PrintWriter(socket1.getOutputStream(), true);
				dataOut.println("1");
				br = new BufferedReader(new InputStreamReader(
						socket1.getInputStream()));
				while ((br.readLine()) != null) {

				}

			} catch (UnknownHostException e) {
				e.printStackTrace();

			} catch (IOException e) {
				doInBackground(null);
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
		}

	}

}
