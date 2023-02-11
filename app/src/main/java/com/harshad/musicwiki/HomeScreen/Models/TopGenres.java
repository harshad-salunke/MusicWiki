package com.harshad.musicwiki.HomeScreen.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopGenres {



    @SerializedName("tag")
    private ArrayList<Genre> genres;

    public ArrayList<Genre> getGenres() {
        return genres;
    }
}
