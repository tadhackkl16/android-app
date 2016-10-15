package org.restcomm.android.hack.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import org.restcomm.android.hack.adapter.PackageAdapter;
import org.restcomm.android.hack.api.CallbackInterface;
import org.restcomm.android.hack.api.PackageInterface;
import org.restcomm.android.hack.db.Auths;
import org.restcomm.android.hack.model.MyPackage;
import org.restcomm.android.hack.model.Package;
import org.restcomm.android.hack.model.RestError;
import org.restcomm.android.hack.utils.Static;
import org.restcomm.android.olympus.R;

import java.util.ArrayList;

import retrofit.RestAdapter;
import retrofit.client.Response;

public class PackagesActivity extends AppCompatActivity {

    private RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Static.URL).build();

    private ArrayList<MyPackage> myPackages = new ArrayList<>();

    private PackageAdapter packageAdapter;
    private android.support.v7.widget.RecyclerView recycler_view_packages;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_packages);


        recycler_view_packages = (RecyclerView) findViewById(R.id.recycler_view_packages);
        mLayoutManager = new LinearLayoutManager(this);
        recycler_view_packages.setLayoutManager(mLayoutManager);

        packageAdapter = new PackageAdapter(this, myPackages);
        recycler_view_packages.setAdapter(packageAdapter);

        getPackages();
    }

    private void getPackages() {
        final PackageInterface packageInterface = adapter.create(PackageInterface.class);

        Auths dbAuth = Auths.getAuth();

        packageInterface.getPackages(dbAuth.accessToken, new CallbackInterface<Package>(PackagesActivity.this) {
            @Override
            public void failure(RestError restError) {
                Log.e("error", restError.getCode() + "");
                Toast.makeText(PackagesActivity.this, restError.getErrorDetails(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void success(Package aPackage, Response response) {
                myPackages.addAll(aPackage.getResponse().getMessage().getPackages().getMyPackages());
                packageAdapter.notifyDataSetChanged();
            }
        });


    }
}
