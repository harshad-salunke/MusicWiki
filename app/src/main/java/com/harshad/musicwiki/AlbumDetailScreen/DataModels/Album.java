package com.harshad.musicwiki.AlbumDetailScreen.DataModels;

import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("album")
    private AlbumInfo albumInfo;

    public AlbumInfo getAlbumInfo() {
        return albumInfo;
    }
}
