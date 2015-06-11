package com.example.busclientb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class WifiReceiver extends BroadcastReceiver {
    String action;
     
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
    	Intent i = new Intent(context, Bus.class);
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
    }
}