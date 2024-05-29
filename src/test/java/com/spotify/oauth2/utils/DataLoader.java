package com.spotify.oauth2.utils;

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static DataLoader getInstance(){
        if(dataLoader == null)
            dataLoader = new DataLoader();

        return dataLoader;
    }

    public String getGetPlaylistId(){
        String property = properties.getProperty("get_playlsit_id");
        if (property != null)
            return property;
        else
            throw new RuntimeException("Property get_playlsit_id is not specified in the config file");
    }

    public String getUpdatePlaylistId(){
        String property = properties.getProperty("update_playlsit_id");
        if (property != null)
            return property;
        else
            throw new RuntimeException("Property update_playlsit_id is not specified in the config file");
    }
}
