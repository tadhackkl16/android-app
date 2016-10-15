package org.restcomm.android.hack.api;

import org.restcomm.android.hack.model.User;
import org.restcomm.android.hack.model.body.BPurchase;
import org.restcomm.android.hack.model.body.BRegister;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */
public interface UserInterface {

    @GET("/api/user/current")
    void currentUser(@Header("x-access-token") String x_access_token, CallbackInterface<User> callback);

    @POST("/api/user/purchase")
    void purchase(@Header("x-access-token") String x_access_token, @Body BPurchase body, CallbackInterface<User> callback);

    @POST("/api/user/register/slave")
    void registerDeviceSlave(@Header("x-access-token") String x_access_token, @Body BRegister body, CallbackInterface<User> callback);

    @POST("/api/user/register/master")
    void registerDeviceMaster(@Header("x-access-token") String x_access_token, @Body BRegister body, CallbackInterface<User> callback);
}
