package org.restcomm.android.hack.model;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "_id",
        "username",
        "password",
        "package_id",
        "deviceId",
        "devices"
})
public class UserM {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonProperty("package_id")
    private String packageId;
    @JsonProperty("deviceId")
    private String deviceId;
    @JsonProperty("devices")
    private List<String> devices = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The id
     */
    @JsonProperty("_id")
    public String getId() {
        return id;
    }

    /**
     * @param id The _id
     */
    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * @param username The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return The password
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * @param password The password
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return The packageId
     */
    @JsonProperty("package_id")
    public String getPackageId() {
        return packageId;
    }

    /**
     * @param packageId The package_id
     */
    @JsonProperty("package_id")
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    /**
     * @return The deviceId
     */
    @JsonProperty("deviceId")
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * @param deviceId The deviceId
     */
    @JsonProperty("package_id")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * @return The devices
     */
    @JsonProperty("devices")
    public List<String> getDevices() {
        return devices;
    }

    /**
     * @param devices The devices
     */
    @JsonProperty("devices")
    public void setDevices(List<String> devices) {
        this.devices = devices;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}