package com.harshad.musicwiki.HomeScreen.Models;

import com.google.gson.annotations.SerializedName;

public class AllGenres {

    @SerializedName("toptags")
    private TopGenres topGenres;

    public TopGenres getTopGenres() {
        return topGenres;
    }
}