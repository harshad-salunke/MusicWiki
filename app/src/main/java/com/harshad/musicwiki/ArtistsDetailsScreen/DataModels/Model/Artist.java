package com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.Model;

import com.google.gson.annotations.SerializedName;

public class Artist {
    @SerializedName("artist")
    private ArtistInfo artistInfo;

    public ArtistInfo getArtistInfo() {
        return artistInfo;
    }
}
