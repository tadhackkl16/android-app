package org.restcomm.android.hack.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.restcomm.android.hack.utils.Static;
import org.restcomm.android.olympus.CallActivity;
import org.restcomm.android.olympus.MainActivity;
import org.restcomm.android.olympus.MessageActivity;
import org.restcomm.android.olympus.R;
import org.restcomm.android.sdk.RCDevice;
import org.restcomm.android.sdk.RCDeviceListener;
import org.restcomm.android.sdk.RCPresenceEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ChatActivity extends AppCompatActivity{

    LinearLayout ll_master;
    LinearLayout ll_slave;
    Spinner spinner;
    String callee="";
    SharedPreferences prefs;
    String mine= "";
    Button btn_master;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        Set<String> stringList = new HashSet<String>();



        ll_master = (LinearLayout) findViewById(R.id.ll_master);
        spinner = (Spinner) findViewById(R.id.spinner) ;
        btn_master = (Button) findViewById(R.id.btn_master);

        final ArrayList<String> devices = getIntent().getStringArrayListExtra("devices");
        final String mine = getIntent().getStringExtra("mine");
        final String device = getIntent().getStringExtra("device");
        String type = getIntent().getStringExtra("type");

        if(type.equals("master")){
            devices.remove(device);
        } else {
            devices.removeAll(devices);
            devices.add(device);
        }

        for (String s: devices) {
            stringList.add(s);
        }

        prefEdit.putString(RCDevice.ParameterKeys.SIGNALING_USERNAME, mine);
        prefEdit.putString(RCDevice.ParameterKeys.SIGNALING_PASSWORD, "12345");
        prefEdit.putString(RCDevice.ParameterKeys.SIGNALING_DOMAIN, Static.HUB);
        prefEdit.putStringSet(RCDevice.ParameterKeys.SIGNALING_USERNAME_RECIEVER, stringList);
        prefEdit.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
