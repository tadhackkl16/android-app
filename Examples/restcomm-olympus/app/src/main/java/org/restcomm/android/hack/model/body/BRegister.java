package org.restcomm.android.hack.model.body;

/**
 * Created by samialmouhtaseb on 15/10/16.
 */

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "deviceId"
})
public class BRegister {

    @JsonProperty("deviceId")
    private String deviceId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public BRegister() {

    }

    public BRegister(String deviceId) {
        this.deviceId = deviceId;
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
    @JsonProperty("deviceId")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
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
