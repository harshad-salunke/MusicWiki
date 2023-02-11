package com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopAlbumModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArtistTopAlbum {

    @SerializedName("album")
    private ArrayList<TopAlbum> topAlbumArrayList;



    public ArrayList<TopAlbum> getTopAlbumArrayList() {
        return topAlbumArrayList;
    }

}
