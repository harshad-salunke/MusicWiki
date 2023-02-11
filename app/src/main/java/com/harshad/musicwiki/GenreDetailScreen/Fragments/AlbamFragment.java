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
import com.harshad.musicwiki.GenreDetailScreen.DataModels.AlbumModel.Album;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.AlbumModel.AllAlbums;
import com.harshad.musicwiki.LastFmApi.RetrofitInstance;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AlbamFragment extends Fragment {

    String genreName;
    private ArrayList<Album> albumArrayList;
 private    RecyclerView album_recylerview;
  private   AlbumRecyclerViewAdapter albumRecyclerViewAdapter;
  private   ShimmerFrameLayout shimmerFrameLayout;
    public AlbamFragment(String genreName) {

        this.genreName = genreName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_albam, container, false);
        album_recylerview=view.findViewById(R.id.track_recyclerview);
        shimmerFrameLayout=view.findViewById(R.id.shimmer_view);
        shimmerFrameLayout.startShimmer();
        albumArrayList = new ArrayList<>();
        albumRecyclerViewAdapter=new AlbumRecyclerViewAdapter(albumArrayList,getContext());
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),2);
        album_recylerview.setLayoutManager(layoutManager);
        album_recylerview.setAdapter(albumRecyclerViewAdapter);


        RetrofitInstance.getInstance().lastFmApi.getAlbums(getString(R.string.tag_gettopalbums), genreName, getString(R.string.api_key), getString(R.string.json))
                .enqueue(new Callback<AllAlbums>() {
                    @Override
                    public void onResponse(Call<AllAlbums> call, Response<AllAlbums> response) {
                        albumArrayList.addAll(response.body().getTopAlbums().getAlbumList());
                        albumRecyclerViewAdapter.notifyDataSetChanged();
                        shimmerFrameLayout.stopShimmer();
                        shimmerFrameLayout.setVisibility(View.GONE);
                        album_recylerview.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(Call<AllAlbums> call, Throwable t) {

                    }
                });

        return  view;
    }


}