package org.restcomm.android.hack.api;

import org.restcomm.android.hack.model.Package;

import retrofit.http.GET;
import retrofit.http.Header;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */
public interface PackageInterface {
    @GET("/api/packages/all")
    void getPackages(@Header("x-access-token") String x_access_token, CallbackInterface<Package> callback);
}
