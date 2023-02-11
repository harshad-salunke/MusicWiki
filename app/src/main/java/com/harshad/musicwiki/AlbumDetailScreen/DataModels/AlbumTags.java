package com.harshad.musicwiki.AlbumDetailScreen.DataModels;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AlbumTags {

    @SerializedName("tag")
    private ArrayList<AlbumTag> albumTagArrayList;

    public ArrayList<AlbumTag> getAlbumTagArrayList() {
        return albumTagArrayList;
    }
}
