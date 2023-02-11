package com.harshad.musicwiki.AlbumDetailScreen.DataModels;

import com.google.gson.annotations.SerializedName;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistInfo;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.RankAttr;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.TrackModel.Streamable;

public class AlbumTrack {

    private String name;
    private String url;
    private long duration;

    @Override
    public String toString() {
        return "AlbumTrack{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", duration=" + duration +
                ", rankAttr=" + rankAttr +
                ", streamable=" + streamable +
                ", artistInfo=" + artistInfo +
                '}';
    }

    @SerializedName("@attr")
    private RankAttr rankAttr;

    private Streamable streamable;

    @SerializedName("artist")
    private ArtistInfo artistInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public RankAttr getRankAttr() {
        return rankAttr;
    }

    public void setRankAttr(RankAttr rankAttr) {
        this.rankAttr = rankAttr;
    }

    public Streamable getStreamable() {
        return streamable;
    }

    public void setStreamable(Streamable streamable) {
        this.streamable = streamable;
    }

    public ArtistInfo getArtistInfo() {
        return artistInfo;
    }

    public void setArtistInfo(ArtistInfo artistInfo) {
        this.artistInfo = artistInfo;
    }
}
