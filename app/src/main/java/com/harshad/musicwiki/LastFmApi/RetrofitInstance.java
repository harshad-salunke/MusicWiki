package com.harshad.musicwiki.LastFmApi;

import android.util.Log;

import com.harshad.musicwiki.R;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
String TAG="Retrofit";
  public static   RetrofitInstance retrofitInstance;
    public LastFmApi lastFmApi;
    RetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         lastFmApi = retrofit.create(LastFmApi.class);
    }
    public static RetrofitInstance getInstance(){
        if(retrofitInstance==null){
            retrofitInstance=new RetrofitInstance();
        }
        return retrofitInstance;
    }
}
