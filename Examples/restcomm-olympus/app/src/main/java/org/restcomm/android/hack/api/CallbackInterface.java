package org.restcomm.android.hack.api;

import android.content.Context;
import android.util.Log;

import org.restcomm.android.hack.model.RestError;

import java.net.SocketTimeoutException;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */
public abstract class CallbackInterface<T> implements Callback<T> {

    private Context _context;

    public CallbackInterface(Context context) {
        this._context = context;
    }

    public abstract void failure(RestError restError);

    public abstract void success(T t, Response response);

    @Override
    public void failure(RetrofitError error) {

        //TODO- Due to error in parsing gson!!
        RestError restError = null;
        try {
            restError = (RestError) error.getBodyAs(RestError.class);
        } catch (Exception e) {
            restError = new RestError();
        }

        switch (error.getKind()) {
            case HTTP:
                if (error.getResponse().getStatus() == 401) {
                    restError = new RestError(restError.getCode(), "Invalid credentials. Please verify login info.", error.getKind().name());
                    //Logout
                    return;
                } else {
                    String errorDetails = (restError.getErrorDetails() == null || restError.getErrorDetails().isEmpty()) ? "Sorry, something went wrong!" : restError.getErrorDetails();
                    restError = new RestError(restError.getCode(), errorDetails, restError.getErrorDetails());
                }
                break;
            case NETWORK:
                if (error.getCause() instanceof SocketTimeoutException)
                    restError = new RestError(500, "Connection Timeout. Please verify your internet connection.", error.getKind().name());
                else
                    restError = new RestError(500, "No Connection. Please verify your internet connection.", error.getKind().name());
                break;
            case CONVERSION:
            case UNEXPECTED:
                restError = new RestError(500, "Sorry, something went wrong!", error.getKind().name());
                break;
        }

        Log.e("ConnectionError", "ErrorType:" + restError.toString());
        failure(restError);
    }
}
