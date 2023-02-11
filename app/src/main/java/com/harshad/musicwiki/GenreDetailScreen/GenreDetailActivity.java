package com.harshad.musicwiki.GenreDetailScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.harshad.musicwiki.GenreDetailScreen.Fragments.AlbamFragment;
import com.harshad.musicwiki.GenreDetailScreen.Fragments.ArtistsFragment;
import com.harshad.musicwiki.GenreDetailScreen.Fragments.TracksFragment;
import com.harshad.musicwiki.GenreDetailScreen.Models.GenreInfo;
import com.harshad.musicwiki.GenreDetailScreen.Adapters.ViewPagerAdapter;
import com.harshad.musicwiki.LastFmApi.RetrofitInstance;
import com.harshad.musicwiki.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreDetailActivity extends AppCompatActivity {
   private String genreName="";
   String TAG="GenreDetialActivity";
   private String  genre_info="";
   ExpandableTextView expandableTextView;
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView Title_text;
    private ImageView back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_detail);
        Intent intent=getIntent();
        genreName=intent.getStringExtra("genreName");
        intiView();
        Title_text.setText(genreName);

        //singletone retrofit instance
        RetrofitInstance.getInstance().lastFmApi
                .getGenreInfo(getString(R.string.tag_getinfo), genreName, getString(R.string.api_key), getString(R.string.json))
                .enqueue(new Callback<GenreInfo>() {
                    @Override
                    public void onResponse(Call<GenreInfo> call, Response<GenreInfo> response) {
                        if(!response.isSuccessful()) {
                            Log.d(TAG, "onResponse: error retrieving data");
                            return;
                        }
                        assert response.body() != null;
                        String name = response.body().getTag().getName().toUpperCase();
                        String summaryTemp = response.body().getTag().getWiki().getSummary();
                        Log.d(TAG,summaryTemp);
                        genre_info=summaryTemp.replaceAll("\\<[^>]*>","");
                        expandableTextView.setText(genre_info);

                    }

                    @Override
                    public void onFailure(Call<GenreInfo> call, Throwable t) {
                        Log.d(TAG, "onResponse: retrofit failure");

                    }
                });
    }

    private void intiView() {
        Title_text=findViewById(R.id.genre_title);
        expandableTextView=findViewById(R.id.expand_text_view);
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tab_layout);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.add(new AlbamFragment(genreName), "ALBAMS");
        viewPagerAdapter.add(new ArtistsFragment(genreName), "ARTISTS");
        viewPagerAdapter.add(new TracksFragment(genreName), "TRACKS");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        back_btn=findViewById(R.id.back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}