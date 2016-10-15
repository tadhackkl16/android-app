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
        "_id",
        "name",
        "description",
        "devices",
        "hours"
})
public class MyPackage {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("devices")
    private Integer devices;
    @JsonProperty("hours")
    private Integer hours;
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
     * @return The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * @param description The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return The devices
     */
    @JsonProperty("devices")
    public Integer getDevices() {
        return devices;
    }

    /**
     * @param devices The devices
     */
    @JsonProperty("devices")
    public void setDevices(Integer devices) {
        this.devices = devices;
    }

    /**
     * @return The hours
     */
    @JsonProperty("hours")
    public Integer getHours() {
        return hours;
    }

    /**
     * @param hours The hours
     */
    @JsonProperty("hours")
    public void setHours(Integer hours) {
        this.hours = hours;
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
