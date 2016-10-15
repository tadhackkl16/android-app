package org.restcomm.android.hack.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.restcomm.android.olympus.R;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    LinearLayout ll_master;
    LinearLayout ll_slave;
    Spinner spinner;


    String callee="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ll_slave = (LinearLayout) findViewById(R.id.ll_slave);
        ll_master = (LinearLayout) findViewById(R.id.ll_master);
        spinner = (Spinner) findViewById(R.id.spinner) ;

        final ArrayList<String> devices = getIntent().getStringArrayListExtra("devices");
        final String device = getIntent().getStringExtra("device");
        final String mine = getIntent().getStringExtra("mine");
        String type = getIntent().getStringExtra("type");

        if(type.equals("slave")){
            ll_slave.setVisibility(View.VISIBLE);
            callee = device;
        } else {
            ll_master.setVisibility(View.VISIBLE);
            spinner.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,devices));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    callee = devices.get(i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }


    }
}
