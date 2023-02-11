package com.harshad.musicwiki.GenreDetailScreen.DataModels.TrackModel;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TopTracks {
    @SerializedName("track")
    private ArrayList<Track> trackList;



    public ArrayList<Track> getTrackList() {
        return trackList;
    }


}
