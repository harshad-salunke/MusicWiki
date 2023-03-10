package com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopTracksModels;

import com.google.gson.annotations.SerializedName;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.Model.ArtistInfo;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ImageInfo;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.RankAttr;


import java.util.ArrayList;

public class TopTrack {
    private String name;
    private long playcount;
    private long listeners;
    private String mbid;
    private String url;
    private int streamable;

    @SerializedName("artist")
    private ArtistInfo artistInfo;

    @SerializedName("image")
    private ArrayList<ImageInfo> imageInfoArrayList;

    @SerializedName("@attr")
    private RankAttr rankAttr;

    public String getName() {
        return name;
    }

    public long getPlaycount() {
        return playcount;
    }

    public long getListeners() {
        return listeners;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public int getStreamable() {
        return streamable;
    }

    public ArtistInfo getArtistInfo() {
        return artistInfo;
    }

    public ArrayList<ImageInfo> getImageInfoArrayList() {
        return imageInfoArrayList;
    }

    public RankAttr getRankAttr() {
        return rankAttr;
    }
}
