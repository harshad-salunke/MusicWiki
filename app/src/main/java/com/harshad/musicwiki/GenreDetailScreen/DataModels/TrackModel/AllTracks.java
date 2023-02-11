package com.harshad.musicwiki.GenreDetailScreen.DataModels.TrackModel;

import com.google.gson.annotations.SerializedName;

public class AllTracks {

    @SerializedName("tracks")
    private TopTracks topTracks;

    public TopTracks getTopTracks() {
        return topTracks;
    }
}
