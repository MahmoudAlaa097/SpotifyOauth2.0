package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {
    @JsonProperty("collaborative")
    boolean collaborative;
    @JsonProperty("description")
    String description;
    @JsonProperty("external_urls")
    ExternalUrls external_urls;
    @JsonProperty("followers")
    Followers followers;
    @JsonProperty("href")
    String href;
    @JsonProperty("id")
    String id;
    @JsonProperty("images")
    Object images;
    @JsonProperty("name")
    String name;
    @JsonProperty("owner")
    Owner owner;
    @JsonProperty("primary_color")
    Object primary_color;
    @JsonProperty("public")
    boolean _public;
    @JsonProperty("snapshot_id")
    String snapshot_id;
    @JsonProperty("tracks")
    Tracks tracks;
    @JsonProperty("type")
    String type;
    @JsonProperty("uri")
    String uri;
}
