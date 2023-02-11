package com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.Model;

import com.google.gson.annotations.SerializedName;

public class ImageInfo {

    @SerializedName("#text")
    private String text;

    @SerializedName("size")
    private String size;

    public String getText() {
        return text;
    }

    public String getSize() {
        return size;
    }
}
