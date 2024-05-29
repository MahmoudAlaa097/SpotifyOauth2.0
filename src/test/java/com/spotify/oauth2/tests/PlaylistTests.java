package com.spotify.oauth2.tests;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.pojo.Error;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.DataLoader;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.spotify.oauth2.api.applicationApi.PlaylistApi.*;
import static com.spotify.oauth2.utils.FakerUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Spotify Oauth2.0")
@Feature("Playlist")
public class PlaylistTests extends BaseTests {
    @Story("Create a playlist story")
    @Test(description = "Should be able to create a playlist")
    public void shouldBeAbleToCreatePlaylist() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Story("Create a playlist story")
    @Test(description = "Should not be able to create a playlist without a name")
    public void shouldNotBeAbleToCreatePlaylistWithoutName() {
        Playlist requestPlaylist = playlistBuilder("", generateDescription(), true);
        Response response = post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_400);
        assertError(response.as(Error.class), StatusCode.CODE_400.getCode(), StatusCode.CODE_400.getMsg());
    }

    @Story("Create a playlist story")
    @Test(description = "Should not be able to create a playlist with an expired token")
    public void shouldNotBeAbleToCreatePlaylistWithExpiredToken() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), true);
        Response response = post(generateToken(), requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_401);
        assertError(response.as(Error.class), StatusCode.CODE_401.getCode(), StatusCode.CODE_401.getMsg());
    }

    @Story("Get a playlist story")
    @Test(description = "Should be able to get a playlist")
    public void shouldBeAbleToGetPlaylist() {
        Playlist requestPlaylist = playlistBuilder("Updated Playlist Name", "Updated playlist description", true);
        Response response = get(DataLoader.getInstance().getGetPlaylistId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Story("Get a playlist story")
    @Test(description = "Should not be able to get a playlist with expired token")
    public void shouldNotBeAbleToGetPlaylistWithExpiredToken() {
        Response response = get(generateToken(), DataLoader.getInstance().getGetPlaylistId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_401);
        assertError(response.as(Error.class), StatusCode.CODE_401.getCode(), StatusCode.CODE_401.getMsg());
    }

    @Story("Get a playlist story")
    @Test(description = "Should not be able to get a playlist with wrong playlist id")
    public void shouldNotBeAbleToGetPlaylistWithWrongPlaylistId() {
        Response response = get(generateId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_400);
        assertError(response.as(Error.class), StatusCode.CODE_400.getCode(), "Invalid base62 id");
    }

    @Story("Update a playlist story")
    @Test(description = "Should be able to update a playlist")
    public void shouldBeAbleToUpdatePlaylist() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), true);
        Response response = put(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
    }

    @Story("Update a playlist story")
    @Test(description = "Should be able to update a playlist with expired token")
    public void shouldNotBeAbleToUpdatePlaylistWithExpiredToken() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), true);
        Response response = put(generateToken(), DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_401);
        assertError(response.as(Error.class), StatusCode.CODE_401.getCode(), StatusCode.CODE_401.getMsg());
    }

    @Step
    private Playlist playlistBuilder(String name, String description, boolean _public) {
        return Playlist.builder().
                name(name).
                description(description).
                _public(_public).
                build();
    }

    @Step
    private void assertPlaylistEqual(Playlist requestPlaylist, Playlist responsePlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.is_public(), equalTo(requestPlaylist.is_public()));
    }

    @Step
    private void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.getCode()));
    }

    @Step
    private void assertError(Error error, int expectedStatusCode, String expectedMsg) {
        assertThat(error.getError().getStatus(), equalTo(expectedStatusCode));
        assertThat(error.getError().getMessage(), equalTo(expectedMsg));
    }
}
