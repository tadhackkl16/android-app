package org.restcomm.android.hack;

import android.app.Application;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import org.restcomm.android.hack.db.Auths;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */
public class HackApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        MultiDex.install(this);

        Configuration.Builder config = new Configuration.Builder(this);
        config.setDatabaseName("Hack.db");
        config.addModelClasses(Auths.class);
        ActiveAndroid.initialize(config.create());
    }
}
