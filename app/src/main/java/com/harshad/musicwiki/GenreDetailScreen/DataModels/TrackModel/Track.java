package com.harshad.musicwiki.GenreDetailScreen.DataModels.TrackModel;

import com.google.gson.annotations.SerializedName;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistInfo;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ImageInfo;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.RankAttr;

import java.util.ArrayList;

public class Track {
    private String name;
    private long duration;
    private String mbid;
    private String url;

    @SerializedName("streamable")
    private Streamable streamable;

    @SerializedName("image")
    private ArrayList<ImageInfo> image;

    @SerializedName("artist")
    private ArtistInfo artistInfo;

    @SerializedName("@attr")
    private RankAttr rankAttr;

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public ArtistInfo getArtistInfo() {
        return artistInfo;
    }

    public Streamable getStreamable() {
        return streamable;
    }

    public ArrayList<ImageInfo> getImage() {
        return image;
    }

    public RankAttr getRankAttr() {
        return rankAttr;
    }
}
