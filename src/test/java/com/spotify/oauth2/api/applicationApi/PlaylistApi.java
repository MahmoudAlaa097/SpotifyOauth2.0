package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Route.*;
import static com.spotify.oauth2.api.TokenManager.getToken;

public class PlaylistApi {
    public static Response post(Playlist requestPlaylist){
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId() + PLAYLISTS, getToken(), requestPlaylist);
    }

    public static Response post(String token, Playlist requestPlaylist){
        return RestResource.post(USERS + ConfigLoader.getInstance().getUserId() + PLAYLISTS, token, requestPlaylist);
    }

    public static Response get(String playlistId){
        return RestResource.get(PLAYLISTS + "/" + playlistId, getToken());
    }

    public static Response get(String token, String playlistId){
        return RestResource.get(PLAYLISTS + "/" + playlistId, token);
    }

    public static Response put(String playlistId, Playlist requestPlaylist){
        return RestResource.put(PLAYLISTS + "/" + playlistId, getToken(),requestPlaylist);
    }

    public static Response put(String token, String playlistId, Playlist requestPlaylist){
        return RestResource.put(PLAYLISTS + "/" + playlistId, token,requestPlaylist);
    }
}
