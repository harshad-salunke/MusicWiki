package com.harshad.musicwiki.GenreDetailScreen.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.harshad.musicwiki.GenreDetailScreen.Adapters.AlbumRecyclerViewAdapter;
import com.harshad.musicwiki.GenreDetailScreen.Adapters.ArtistsRecyclerViewAdapter;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.AlbumModel.Album;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.AlbumModel.AllAlbums;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistModel.AllArtists;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistModel.Artist;
import com.harshad.musicwiki.LastFmApi.RetrofitInstance;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ArtistsFragment extends Fragment {
    String genreName;
    private ArrayList<Artist> ArtistArrayList;
    RecyclerView artists_recylerview;
   private ArtistsRecyclerViewAdapter artistsRecyclerViewAdapter;
   private ShimmerFrameLayout shimmerFrameLayout;
    public ArtistsFragment(String genreName) {
        this.genreName=genreName;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_artists, container, false);
        artists_recylerview=view.findViewById(R.id.artist_recylerview);
        shimmerFrameLayout=view.findViewById(R.id.shimmer_view);
        shimmerFrameLayout.startShimmer();
        ArtistArrayList = new ArrayList<>();
        artistsRecyclerViewAdapter=new ArtistsRecyclerViewAdapter(ArtistArrayList,getContext());
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        artists_recylerview.setLayoutManager(layoutManager);
        artists_recylerview.setAdapter(artistsRecyclerViewAdapter);

        RetrofitInstance.getInstance().lastFmApi.getArtists(getString(R.string.tag_gettopartists), genreName, getString(R.string.api_key), getString(R.string.json))
                .enqueue(new Callback<AllArtists>() {
                    @Override
                    public void onResponse(Call<AllArtists> call, Response<AllArtists> response) {
                    ArtistArrayList.addAll(response.body().getTopArtists().getArtistList());
                    artistsRecyclerViewAdapter.notifyDataSetChanged();
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        artists_recylerview.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(Call<AllArtists> call, Throwable t) {

                    }
                });

        return  view;
    }
}