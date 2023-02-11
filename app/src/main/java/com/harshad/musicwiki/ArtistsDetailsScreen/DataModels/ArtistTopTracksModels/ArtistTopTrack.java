package com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopTracksModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ArtistTopTrack {

    @SerializedName("track")
    private ArrayList<TopTrack> topTracksArrayList;



    public ArrayList<TopTrack> getTopTracksArrayList() {
        return topTracksArrayList;
    }

}
