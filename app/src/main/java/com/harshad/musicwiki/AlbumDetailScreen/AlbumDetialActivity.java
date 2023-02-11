package com.harshad.musicwiki.AlbumDetailScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.harshad.musicwiki.AlbumDetailScreen.DataModels.Album;
import com.harshad.musicwiki.AlbumDetailScreen.DataModels.AlbumInfo;
import com.harshad.musicwiki.AlbumDetailScreen.DataModels.AlbumTag;
import com.harshad.musicwiki.AlbumDetailScreen.DataModels.AlbumTrack;
import com.harshad.musicwiki.AlbumDetailScreen.Recyclerview_Adapters.Tag_Adapter;
import com.harshad.musicwiki.AlbumDetailScreen.Recyclerview_Adapters.Track_Adapter;
import com.harshad.musicwiki.HomeScreen.MainActivity;
import com.harshad.musicwiki.LastFmApi.RetrofitInstance;
import com.harshad.musicwiki.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumDetialActivity extends AppCompatActivity {

    private  String albumCover;
    private String albumName;
    private  String artistName;
 private ImageView albumcircleImageView;
  private   TextView listenre_count,play_count,album_name,artist_name;
private  long listenre=0;
private  long play=0;
    private RecyclerView tag_recyclerview,track_recyclerview;
    private Tag_Adapter tag_adapter;
   private ArrayList<AlbumTag> album_tagList;
   private Track_Adapter track_adapter;
  private ArrayList<AlbumTrack> track_list;
   ExpandableTextView expandableTextView;
   private String genre_info;
    private ShimmerFrameLayout shimmerFrameLayout1,shimmerFrameLayout2;
    private ImageView back_btn;

    private String TAG = "AlbumDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detial);
        Intent intent=getIntent();
        albumName=intent.getStringExtra("album_name");
        albumCover=intent.getStringExtra("album_img");
        artistName=intent.getStringExtra("album_artist");

        initView();


        RetrofitInstance.getInstance().lastFmApi.getAlbumInfo(getString(R.string.album_getinfo), getString(R.string.api_key), artistName, albumName,getString(R.string.json))
                .enqueue(new Callback<Album>() {
                    @Override
                    public void onResponse(Call<Album> call, Response<Album> response) {
                        AlbumInfo albumInfo=response.body().getAlbumInfo();
                        listenre= albumInfo.getListeners();
                        play=albumInfo.getPlaycount();
                        listenre_count.setText(listenre+"");
                        play_count.setText(play+"");
                       album_tagList.addAll(albumInfo.getTags().getAlbumTagArrayList());
                       tag_adapter.notifyDataSetChanged();
                       track_list.addAll(albumInfo.getTracks().getAlbumTrackArrayList());
                       track_adapter.notifyDataSetChanged();
                      String summary= albumInfo.getAlbumWiki().getSummary();
                        genre_info=summary.replaceAll("\\<[^>]*>","");
                        expandableTextView.setText(genre_info);
                        shimmerFrameLayout1.startShimmer();
                        shimmerFrameLayout1.setVisibility(View.GONE);
                        shimmerFrameLayout2.startShimmer();
                        shimmerFrameLayout2.setVisibility(View.GONE);
                        tag_recyclerview.setVisibility(View.VISIBLE);
                        track_recyclerview.setVisibility(View.VISIBLE);


                    }

                    @Override
                    public void onFailure(Call<Album> call, Throwable t) {
                        Toast.makeText(AlbumDetialActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

    }

    private void initView() {
        albumcircleImageView=findViewById(R.id.album_image);
        listenre_count=findViewById(R.id.lisner_count);
        play_count=findViewById(R.id.paly_count);
        album_name=findViewById(R.id.album_name);
        artist_name=findViewById(R.id.artist_name);
        tag_recyclerview=findViewById(R.id.tag_recylerview);
        track_recyclerview=findViewById(R.id.track_recyclerview);
        expandableTextView=findViewById(R.id.expand_text_view2);
        shimmerFrameLayout1=findViewById(R.id.shimmer_view);
        shimmerFrameLayout2=findViewById(R.id.shimmer_view2);
        shimmerFrameLayout1.startShimmer();
        shimmerFrameLayout2.startShimmer();

//        data set to home page
        album_name.setText(albumName);
        artist_name.setText(artistName);
        Glide.with(this).load(albumCover).placeholder(R.drawable.genere).into(albumcircleImageView);


//        init recyclerview
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        tag_recyclerview.setLayoutManager(linearLayoutManager);
        album_tagList=new ArrayList<>();
        tag_adapter = new Tag_Adapter(album_tagList,this);
        tag_recyclerview.setAdapter(tag_adapter);


        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        track_recyclerview.setLayoutManager(linearLayoutManager2);
        track_list=new ArrayList<>();
        track_adapter = new Track_Adapter(track_list,this);
        track_recyclerview.setAdapter(track_adapter);

        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}