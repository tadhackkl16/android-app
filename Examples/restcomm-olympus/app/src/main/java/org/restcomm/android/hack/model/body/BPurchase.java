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
        "packageId"
})
public class BPurchase {

    @JsonProperty("packageId")
    private String packageId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public BPurchase() {

    }

    public BPurchase(String packageId) {
        this.packageId = packageId;
    }

    /**
     * @return The packageId
     */
    @JsonProperty("packageId")
    public String getPackageId() {
        return packageId;
    }

    /**
     * @param packageId The packageId
     */
    @JsonProperty("packageId")
    public void setPackageId(String packageId) {
        this.packageId = packageId;
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
