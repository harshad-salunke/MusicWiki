package com.harshad.musicwiki.AlbumDetailScreen.DataModels;

public class AlbumTag {
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "AlbumTag{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
