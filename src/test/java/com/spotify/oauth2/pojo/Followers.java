package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Followers {
    @JsonProperty("href")
    private Object href;
    @JsonProperty("total")
    private int total;

    public Object getHref() {
        return href;
    }

    public void setHref(Object href) {
        this.href = href;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
