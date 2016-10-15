package org.restcomm.android.hack.model;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */

import com.google.gson.annotations.SerializedName;

public class RestError {

    private int code;

    @SerializedName("error")
    private String errorDetails;

    private String errorKind;

    public RestError() {
    }

    public RestError(int code, String errorDetails, String errorKind) {
        this.code = code;
        this.errorDetails = errorDetails;
        this.errorKind = errorKind;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorKind() {
        return errorKind;
    }

    public void setErrorKind(String errorKind) {
        this.errorKind = errorKind;
    }

    @Override
    public String toString() {
        return String.valueOf("ErrorType:" + this.errorKind + ", " + "ErrorCode:" + this.code + ", " + "ErrorMessage:" + this.errorDetails);
    }

}