package com.harshad.musicwiki.HomeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.harshad.musicwiki.HomeScreen.Adapter.GenerRecyclerViewAdapter;
import com.harshad.musicwiki.HomeScreen.Models.AllGenres;
import com.harshad.musicwiki.HomeScreen.Models.Genre;
import com.harshad.musicwiki.LastFmApi.RetrofitInstance;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> genreList = new ArrayList<String>();
  private   RecyclerView genre_recyclerview;
  private   GenerRecyclerViewAdapter generRecyclerViewAdapter;
    private String TAG = "MainActivity";
    private CardView seemore_gener;
    private  boolean isClicked=false;
    private TextView see_more_text;
    private ImageView see_more_img;
    private ShimmerFrameLayout shimmerFrameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        seemore_gener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isClicked){
                    isClicked=true;
                    generRecyclerViewAdapter.setAllItem();
                    see_more_text.setText("See Less Genres");
                    see_more_img.setImageDrawable(getDrawable(R.drawable.ic_baseline_arrow_circle_up_24));
                }else {
                    isClicked=false;
                    generRecyclerViewAdapter.setLimitItem();
                    see_more_text.setText("See More Genres");
                    see_more_img.setImageDrawable(getDrawable(R.drawable.ic_baseline_arrow_circle_down_24));
                }
            }
        });

        RetrofitInstance.getInstance().
                lastFmApi.getGenres(getString(R.string.tag_getTopTags), getString(R.string.api_key), getString(R.string.json)).enqueue(new Callback<AllGenres>() {
            @Override
            public void onResponse(Call<AllGenres> call, Response<AllGenres> response) {

                if(!response.isSuccessful()) {
                    Log.d(TAG, "onResponse: error retrieving data");
                    return;
                }
                for (Genre tag : response.body().getTopGenres().getGenres()) {
                    genreList.add(tag.getName());
                }
                generRecyclerViewAdapter.notifyDataSetChanged();
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
                genre_recyclerview.setVisibility(View.VISIBLE);

            }

            @Override
            public void onFailure(Call<AllGenres> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initViews() {
        genre_recyclerview=findViewById(R.id.genre_recyclerview);
        seemore_gener=findViewById(R.id.see_more);
        see_more_text=findViewById(R.id.see_more_text);
        see_more_img=findViewById(R.id.see_more_image);
        generRecyclerViewAdapter=new GenerRecyclerViewAdapter(genreList,this);
        shimmerFrameLayout=findViewById(R.id.genre_shimmer);
        shimmerFrameLayout.startShimmer();
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        genre_recyclerview.setLayoutManager(layoutManager);
        genre_recyclerview.setAdapter(generRecyclerViewAdapter);
    }
}