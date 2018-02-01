package com.schulz.erica.dogbreeds;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ericaschulz on 1/30/18.
 */

public class MessageStatus {

    private String status;
    private Message message;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
