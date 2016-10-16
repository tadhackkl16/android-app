package org.restcomm.android.hack.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.restcomm.android.hack.api.CallbackInterface;
import org.restcomm.android.hack.api.UserInterface;
import org.restcomm.android.hack.db.Auths;
import org.restcomm.android.hack.model.RestError;
import org.restcomm.android.hack.model.User;
import org.restcomm.android.hack.model.body.BRegister;
import org.restcomm.android.hack.utils.Static;
import org.restcomm.android.olympus.R;

import java.util.ArrayList;
import java.util.List;

import retrofit.RestAdapter;
import retrofit.client.Response;

public class RegisterDeviceActivity extends AppCompatActivity {

    private RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Static.URL).build();

    private Button btn_slave;
    private Button btn_master;

    private String deviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_device);

        getDeviceId();

        btn_slave = (Button) findViewById(R.id.btn_slave);
        btn_master = (Button) findViewById(R.id.btn_master);

        getCurrentUser();

        btn_master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDevice("master");
            }
        });

        btn_slave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDevice("slave");
            }
        });
    }

    private void getDeviceId() {
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        deviceId = wInfo.getMacAddress();
        deviceId = deviceId.replace(":","");
    }

    private void registerDevice(String type) {
        final UserInterface userInterface = adapter.create(UserInterface.class);

        Auths dbAuth = Auths.getAuth();

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();


        BRegister bRegister = new BRegister(deviceId);

        switch (type) {
            case "master":
                userInterface.registerDeviceMaster(dbAuth.accessToken, bRegister, new CallbackInterface<User>(this) {
                    @Override
                    public void failure(RestError restError) {
                        progressDialog.dismiss();
                        Log.e("error", restError.getCode() + "");
                        Toast.makeText(RegisterDeviceActivity.this, restError.getErrorDetails(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void success(User user, Response response) {
                        progressDialog.dismiss();
                        String device = user.getResponse().getMessage().getUser().getDeviceId();
                        List<String> devices = user.getResponse().getMessage().getUser().getDevices();

                        move(device, devices);
                    }
                });
                break;
            case "slave":
                userInterface.registerDeviceSlave(dbAuth.accessToken, bRegister, new CallbackInterface<User>(this) {
                    @Override
                    public void failure(RestError restError) {
                        progressDialog.dismiss();
                        Log.e("error", restError.getCode() + "");
                        Toast.makeText(RegisterDeviceActivity.this, restError.getErrorDetails(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void success(User user, Response response) {
                        progressDialog.dismiss();
                        String device = user.getResponse().getMessage().getUser().getDeviceId();
                        List<String> devices = user.getResponse().getMessage().getUser().getDevices();

                        move(device, devices);
                    }
                });
                break;
        }
    }

    private void getCurrentUser() {
        final UserInterface userInterface = adapter.create(UserInterface.class);

        Auths dbAuth = Auths.getAuth();

        userInterface.currentUser(dbAuth.accessToken, new CallbackInterface<User>(this) {
            @Override
            public void failure(RestError restError) {
                Log.e("error", restError.getCode() + "");
                Toast.makeText(RegisterDeviceActivity.this, restError.getErrorDetails(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void success(User user, Response response) {
                String device = user.getResponse().getMessage().getUser().getDeviceId();
                List<String> devices = user.getResponse().getMessage().getUser().getDevices();

                move(device, devices);
            }
        });
    }

    private void move(String device, List<String> devices){

        Intent intent = new Intent(RegisterDeviceActivity.this, ChatActivity.class);
        intent.putExtra("device", device);
        if (device.isEmpty()) {
            for (String dev : devices) {
                if (dev.contains(deviceId)) {
                    devices.add(device);
                    intent.putExtra("devices", (ArrayList<String>)devices);
                    intent.putExtra("mine", dev);
                    intent.putExtra("type", "slave");
                    startActivity(intent);
                    finish();
                }
            }
            btn_master.setVisibility(View.VISIBLE);
        } else if(device.contains(deviceId)) {
            devices.add(device);
            intent.putExtra("devices", (ArrayList<String>)devices);
            intent.putExtra("mine", device);
            intent.putExtra("type", "master");
            startActivity(intent);
            finish();
        } else {
            for (String dev : devices) {
                if (dev.contains(deviceId)) {
                    devices.add(device);
                    intent.putExtra("devices", (ArrayList<String>)devices);
                    intent.putExtra("mine", dev);
                    intent.putExtra("type", "slave");
                    startActivity(intent);
                    finish();
                }
            }
            btn_master.setVisibility(View.VISIBLE);
        }
    }
}
