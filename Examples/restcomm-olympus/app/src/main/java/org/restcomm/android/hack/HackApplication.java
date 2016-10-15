package org.restcomm.android.hack;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

import org.restcomm.android.hack.db.Auths;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */
public class HackApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration.Builder config = new Configuration.Builder(this);
        config.setDatabaseName("Hack.db");
        config.addModelClasses(Auths.class);
        ActiveAndroid.initialize(config.create());
    }
}
