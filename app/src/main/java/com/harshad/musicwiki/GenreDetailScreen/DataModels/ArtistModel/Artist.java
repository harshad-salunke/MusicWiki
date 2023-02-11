package com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistModel;

import com.google.gson.annotations.SerializedName;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ImageInfo;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.RankAttr;

import java.util.ArrayList;

public class Artist {
    private String name;
    private String mbid;
    private String url;
    private int streamable;

    @SerializedName("image")
    private ArrayList<ImageInfo> image;

    @SerializedName("@attr")
    private RankAttr rankAttr;

    public String getName() {
        return name;
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

    public ArrayList<ImageInfo> getImage() {
        return image;
    }

    public RankAttr getRankAttr() {
        return rankAttr;
    }
}
