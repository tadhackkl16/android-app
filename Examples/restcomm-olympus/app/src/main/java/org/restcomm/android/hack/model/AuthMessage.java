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
        "token",
        "user"
})
public class AuthMessage {

    @JsonProperty("token")
    private String token;
    @JsonProperty("user")
    private UserM user;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The token
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * @param token The token
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return The user
     */
    @JsonProperty("user")
    public UserM getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    @JsonProperty("user")
    public void setUser(UserM user) {
        this.user = user;
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
