package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Tracks {
    @JsonProperty("href")
    private String href;
    @JsonProperty("items")
    private List<Object> items;
    @JsonProperty("limit")
    private int limit;
    @JsonProperty("next")
    private Object next;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("previous")
    private Object previous;
    @JsonProperty("total")
    private int total;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
