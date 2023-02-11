package com.harshad.musicwiki.AlbumDetailScreen.DataModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AlbumTracks {
    @SerializedName("track")
    private ArrayList<AlbumTrack> albumTrackArrayList;

    public ArrayList<AlbumTrack> getAlbumTrackArrayList() {
        return albumTrackArrayList;
    }

    public void setAlbumTrackArrayList(ArrayList<AlbumTrack> albumTrackArrayList) {
        this.albumTrackArrayList = albumTrackArrayList;
    }
}
