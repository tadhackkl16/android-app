package org.restcomm.android.hack.api;

import org.restcomm.android.hack.model.Auth;
import org.restcomm.android.hack.model.body.BAuth;

import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */
public interface AuthInterface {
    @POST("/api/auth/login")
    void signUpOrSignin(@Body BAuth auth, CallbackInterface<Auth> response);
}
