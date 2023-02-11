package com.harshad.musicwiki.GenreDetailScreen.DataModels.AlbumModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopAlbums {
    @SerializedName("album")
    private ArrayList<Album> albumList;


    public ArrayList<Album> getAlbumList() {
        return albumList;
    }


}
