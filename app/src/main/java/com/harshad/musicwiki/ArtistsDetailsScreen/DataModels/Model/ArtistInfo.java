package com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.Model;

import com.google.gson.annotations.SerializedName;
import com.harshad.musicwiki.AlbumDetailScreen.DataModels.AlbumTags;

import java.util.ArrayList;

public class ArtistInfo {
    private String name;
    private String mbid;
    private String url;
    private long streamable;
    private long ontour;

    @SerializedName("stats")
    private ArtistStats artistStats;

    public void setName(String name) {
        this.name = name;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setStreamable(long streamable) {
        this.streamable = streamable;
    }

    public void setOntour(long ontour) {
        this.ontour = ontour;
    }

    public void setArtistStats(ArtistStats artistStats) {
        this.artistStats = artistStats;
    }

    public void setArtistsSimilar(ArtistsSimilar artistsSimilar) {
        this.artistsSimilar = artistsSimilar;
    }

    public void setAlbumTags(AlbumTags albumTags) {
        this.albumTags = albumTags;
    }

    public void setArtistBio(ArtistBio artistBio) {
        this.artistBio = artistBio;
    }

    @SerializedName("similar")
    private ArtistsSimilar artistsSimilar;

    @SerializedName("tags")
    private AlbumTags albumTags;

    @SerializedName("bio")
    private ArtistBio artistBio;

    public ArrayList<ImageInfo> getImageInfoArrayList() {
        return imageInfoArrayList;
    }

    public void setImageInfoArrayList(ArrayList<ImageInfo> imageInfoArrayList) {
        this.imageInfoArrayList = imageInfoArrayList;
    }

    @SerializedName("image")
    ArrayList<ImageInfo> imageInfoArrayList;


    public String getName() {
        return name;
    }

    public String getMbid() {
        return mbid;
    }

    public String getUrl() {
        return url;
    }



    public long getStreamable() {
        return streamable;
    }

    public long getOntour() {
        return ontour;
    }

    public ArtistsSimilar getArtistsSimilar() {
        return artistsSimilar;
    }

    public ArtistStats getArtistStats() {
        return artistStats;
    }

    public AlbumTags getAlbumTags() {
        return albumTags;
    }

    public ArtistBio getArtistBio() {
        return artistBio;
    }
}
