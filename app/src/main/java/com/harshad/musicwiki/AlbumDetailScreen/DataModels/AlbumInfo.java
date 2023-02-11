package com.harshad.musicwiki.AlbumDetailScreen.DataModels;

import com.google.gson.annotations.SerializedName;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.AlbumModel.TopAlbums;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ImageInfo;

import java.util.ArrayList;

public class AlbumInfo {

    private String name;
    private String artist;
    private String mbid;
    private String url;

    @SerializedName("image")
    private ArrayList<ImageInfo> imageInfo;

    private long listeners;
    private long playcount;

    private AlbumTracks tracks;
    private AlbumTags tags;

    @SerializedName("wiki")
    private AlbumWiki albumWiki;

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<ImageInfo> getImageInfo() {
        return imageInfo;
    }

    public long getListeners() {
        return listeners;
    }

    public long getPlaycount() {
        return playcount;
    }

    public AlbumTracks getTracks() {
        return tracks;
    }

    public AlbumTags getTags() {
        return tags;
    }

    public AlbumWiki getAlbumWiki() {
        return albumWiki;
    }
}
