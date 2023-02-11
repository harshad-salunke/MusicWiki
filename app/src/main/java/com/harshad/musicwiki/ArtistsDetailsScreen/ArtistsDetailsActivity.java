package com.harshad.musicwiki.ArtistsDetailsScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.harshad.musicwiki.AlbumDetailScreen.AlbumDetialActivity;
import com.harshad.musicwiki.AlbumDetailScreen.DataModels.AlbumTag;
import com.harshad.musicwiki.AlbumDetailScreen.Recyclerview_Adapters.Tag_Adapter;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopAlbumModels.ArtistTopAlbum;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopAlbumModels.ArtistTopAlbums;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopAlbumModels.TopAlbum;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopTracksModels.ArtistTopTrack;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopTracksModels.ArtistTopTracks;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopTracksModels.TopTrack;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.Model.Artist;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.Model.ArtistInfo;
import com.harshad.musicwiki.ArtistsDetailsScreen.RecyclerView_Adapter.Top_Album_Adapter;
import com.harshad.musicwiki.ArtistsDetailsScreen.RecyclerView_Adapter.Top_Track_Adapter;
import com.harshad.musicwiki.LastFmApi.RetrofitInstance;
import com.harshad.musicwiki.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtistsDetailsActivity extends AppCompatActivity {
    private String  artist_name_str;
    private  String artist_img_str;


    private CircleImageView artistcircleImageView;
    private TextView listenre_count,play_count,artist_name,publis_date;
    private  long listenre=0;
    private  long play=0;
    private RecyclerView tag_recyclerview;
    private Tag_Adapter tag_adapter;
    private ArrayList<AlbumTag> album_tagList;
    private ImageView back_btn;

//toalbum
    private RecyclerView album_recyclerview;
    private Top_Album_Adapter top_album_adapter;
    private ArrayList<TopAlbum> topAlbumArrayList;

    private RecyclerView track_recyclerview;
    private Top_Track_Adapter track_album_adapter;
    private ArrayList<TopTrack> topTrackArrayList;
    private ExpandableTextView expandableTextView;

    private ShimmerFrameLayout shimmerFrameLayout1,shimmerFrameLayout2,shimmerFrameLayout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artits_details);
        artist_img_str=getIntent().getStringExtra("ARTIST_COVER");
        artist_name_str=getIntent().getStringExtra("ARTIST_NAME");

        initViews();

        RetrofitInstance.getInstance().lastFmApi.getArtistInfo(getString(R.string.artist_getinfo), artist_name_str, getString(R.string.api_key), getString(R.string.json))
                .enqueue(new Callback<Artist>() {
                    @Override
                    public void onResponse(Call<Artist> call, Response<Artist> response) {
                        ArtistInfo artistInfo=response.body().getArtistInfo();
                        listenre= artistInfo.getArtistStats().getListeners();
                        play=artistInfo.getArtistStats().getPlaycount();
                        listenre_count.setText(listenre+"");
                        play_count.setText(play+"");
                        publis_date.setText(artistInfo.getArtistBio().getPublished());
                        String summaryTemp = artistInfo.getArtistBio().getSummary();
                        String  genre_info=summaryTemp.replaceAll("\\<[^>]*>","");
                        expandableTextView.setText(genre_info);
                        album_tagList.addAll(artistInfo.getAlbumTags().getAlbumTagArrayList());
                        tag_adapter.notifyDataSetChanged();
                        shimmerFrameLayout1.stopShimmer();
                        shimmerFrameLayout1.setVisibility(View.GONE);
                        tag_recyclerview.setVisibility(View.VISIBLE);




                    }

                    @Override
                    public void onFailure(Call<Artist> call, Throwable t) {
                        Toast.makeText(ArtistsDetailsActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


//        getting top album of artist
        RetrofitInstance.getInstance().lastFmApi
                .getArtistTopAlbums(getString(R.string.artist_gettopalbums),artist_name_str,getString(R.string.api_key),getString(R.string.json))
                .enqueue(new Callback<ArtistTopAlbums>() {
                    @Override
                    public void onResponse(Call<ArtistTopAlbums> call, Response<ArtistTopAlbums> response) {
                   ArtistTopAlbum artistTopAlbums= response.body().getArtistTopAlbum();
                   topAlbumArrayList.addAll(artistTopAlbums.getTopAlbumArrayList());
                   top_album_adapter.notifyDataSetChanged();
                        shimmerFrameLayout2.stopShimmer();
                        shimmerFrameLayout2.setVisibility(View.GONE);
                        album_recyclerview.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(Call<ArtistTopAlbums> call, Throwable t) {
                        Toast.makeText(ArtistsDetailsActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


        //        getting top tracks of artist
        RetrofitInstance.getInstance().lastFmApi
                .getArtistTopTracks(getString(R.string.artist_gettoptracks),artist_name_str,getString(R.string.api_key),getString(R.string.json))
                .enqueue(new Callback<ArtistTopTracks>() {
                    @Override
                    public void onResponse(Call<ArtistTopTracks> call, Response<ArtistTopTracks> response) {

                        ArtistTopTrack artistTopTracks=response.body().getArtistTopTrack();
                        topTrackArrayList.addAll(artistTopTracks.getTopTracksArrayList());
                        track_album_adapter.notifyDataSetChanged();
                        shimmerFrameLayout3.stopShimmer();
                        shimmerFrameLayout3.setVisibility(View.GONE);
                        track_recyclerview.setVisibility(View.VISIBLE);

                    }

                    @Override
                    public void onFailure(Call<ArtistTopTracks> call, Throwable t) {
                        Toast.makeText(ArtistsDetailsActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

    }

    private void initViews() {
        artistcircleImageView=findViewById(R.id.album_image);
        listenre_count=findViewById(R.id.lisner_count);
        play_count=findViewById(R.id.paly_count);
        artist_name=findViewById(R.id.album_name);
        publis_date=findViewById(R.id.artist_name);
        tag_recyclerview=findViewById(R.id.tag_recylerview);
        album_recyclerview=findViewById(R.id.top_album_recyclerview);
        track_recyclerview=findViewById(R.id.track_recyclerview);
        expandableTextView=findViewById(R.id.expand_text_view2);

        shimmerFrameLayout1=findViewById(R.id.shimmer_view1);
        shimmerFrameLayout2=findViewById(R.id.shimmer_view2);
        shimmerFrameLayout3=findViewById(R.id.shimmer_view3);
        shimmerFrameLayout1.startShimmer();
        shimmerFrameLayout2.startShimmer();
        shimmerFrameLayout3.startShimmer();


//        setting data to views
        artist_name.setText(artist_name_str);
        Glide.with(this).load(artist_img_str).placeholder(R.drawable.genere).into(artistcircleImageView);
        //tag recycler view init
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        tag_recyclerview.setLayoutManager(linearLayoutManager);
        album_tagList=new ArrayList<>();
        tag_adapter = new Tag_Adapter(album_tagList,this);
        tag_recyclerview.setAdapter(tag_adapter);

        // top album recycler view init
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        album_recyclerview.setLayoutManager(linearLayoutManager2);
        topAlbumArrayList=new ArrayList<>();
        top_album_adapter = new Top_Album_Adapter(topAlbumArrayList,this);
        album_recyclerview.setAdapter(top_album_adapter);


        // top track recycler view init
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        track_recyclerview.setLayoutManager(linearLayoutManager3);
        topTrackArrayList=new ArrayList<>();
        track_album_adapter = new Top_Track_Adapter(topTrackArrayList,this);
        track_recyclerview.setAdapter(track_album_adapter);


        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}