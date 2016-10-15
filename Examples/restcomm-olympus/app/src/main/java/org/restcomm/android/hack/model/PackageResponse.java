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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "success",
        "message"
})
public class PackageResponse {

    @JsonProperty("success")
    private String success;
    @JsonProperty("message")
    private PackageMessage message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The success
     */
    @JsonProperty("success")
    public String getSuccess() {
        return success;
    }

    /**
     * @param success The success
     */
    @JsonProperty("success")
    public void setSuccess(String success) {
        this.success = success;
    }

    /**
     * @return The message
     */
    @JsonProperty("message")
    public PackageMessage getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    @JsonProperty("message")
    public void setMessage(PackageMessage message) {
        this.message = message;
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
