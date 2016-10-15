package org.restcomm.android.hack.db;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */

import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "Auths")
public class Auths extends Model {
    //@Expose
    @Column(name = "Username")
    public String username;

    //@Expose
    @Column(name = "AccessToken")
    public String accessToken;

    public Auths() {
        super();
    }

    public static Auths getAuth() {
        return new Select().from(Auths.class).orderBy("Id DESC").executeSingle();
    }

    public void deleteAuth() {
        try {
            new Delete().from(Auths.class).where("Username = ?", username).execute();
        } catch (Exception e) {
            Log.e("deleteAuthFromAuth", e.toString());
        }

    }
}