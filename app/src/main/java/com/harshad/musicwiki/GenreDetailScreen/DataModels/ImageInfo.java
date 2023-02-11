package com.harshad.musicwiki.GenreDetailScreen.DataModels;

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
