package com.harshad.musicwiki.GenreDetailScreen.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.harshad.musicwiki.GenreDetailScreen.Adapters.ArtistsRecyclerViewAdapter;
import com.harshad.musicwiki.GenreDetailScreen.Adapters.TracksRecyclerViewAdapter;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistModel.AllArtists;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.ArtistModel.Artist;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.TrackModel.AllTracks;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.TrackModel.Track;
import com.harshad.musicwiki.LastFmApi.RetrofitInstance;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TracksFragment extends Fragment {

    String genreName;
    private ArrayList<Track> trackArrayList;
    RecyclerView track_recylerview;
    TracksRecyclerViewAdapter trackRecyclerViewAdapter;
    private ShimmerFrameLayout shimmerFrameLayout;

    public TracksFragment(String genreName) {
        this.genreName=genreName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_tracks, container, false);
        track_recylerview=view.findViewById(R.id.tracksrecyclerview);
        shimmerFrameLayout=view.findViewById(R.id.shimmer_view);
        shimmerFrameLayout.startShimmer();
        trackArrayList = new ArrayList<>();
        trackRecyclerViewAdapter=new TracksRecyclerViewAdapter(trackArrayList,getContext());
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        track_recylerview.setLayoutManager(layoutManager);
        track_recylerview.setAdapter(trackRecyclerViewAdapter);

        RetrofitInstance.getInstance().lastFmApi.getTracks(getString(R.string.tag_gettoptracks), genreName, getString(R.string.api_key), getString(R.string.json))
                .enqueue(new Callback<AllTracks>() {
                    @Override
                    public void onResponse(Call<AllTracks> call, Response<AllTracks> response) {
                        trackArrayList.addAll(response.body().getTopTracks().getTrackList());
                        trackRecyclerViewAdapter.notifyDataSetChanged();
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        track_recylerview.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(Call<AllTracks> call, Throwable t) {

                    }
                });

        return  view;
    }
}