package com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopArtists {
    @SerializedName("artist")
    private ArrayList<Artist> artistList;



    public ArrayList<Artist> getArtistList() {
        return artistList;
    }


}
