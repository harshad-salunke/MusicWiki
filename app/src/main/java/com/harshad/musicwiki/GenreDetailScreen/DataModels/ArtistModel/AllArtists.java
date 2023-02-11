package com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistModel;

import com.google.gson.annotations.SerializedName;

public class AllArtists {

    @SerializedName("topartists")
    private TopArtists topArtists;

    public TopArtists getTopArtists() {
        return topArtists;
    }
}
