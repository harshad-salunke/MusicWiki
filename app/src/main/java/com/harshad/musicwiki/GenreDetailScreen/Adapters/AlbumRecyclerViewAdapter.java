package com.harshad.musicwiki.GenreDetailScreen.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.harshad.musicwiki.AlbumDetailScreen.AlbumDetialActivity;
import com.harshad.musicwiki.GenreDetailScreen.DataModels.AlbumModel.Album;
import com.harshad.musicwiki.GenreDetailScreen.GenreDetailActivity;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumRecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<Album> albumArrayList;
    private Context mcontext;
    public AlbumRecyclerViewAdapter(ArrayList<Album> recyclerDataArrayList, Context mcontext) {
        this.albumArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        Album album=albumArrayList.get(position);
        holder.album_text.setText(album.getName());
        holder.artist_name.setText(album.getAlbumArtist().getName());
        Glide.with(mcontext)
                .load(album.getImage().get(3).getText()).placeholder(R.drawable.music_holder)
                .into(holder.album_image);
        holder.album_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mcontext, AlbumDetialActivity.class);
                intent.putExtra("album_name",album.getName());
                intent.putExtra("album_img",album.getImage().get(3).getText());
                intent.putExtra("album_artist",album.getAlbumArtist().getName());
                mcontext.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
      return   albumArrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView album_text;
        private ImageView album_image;
        private CardView album_card;
        private  TextView artist_name;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            album_text = itemView.findViewById(R.id.album_text);
            album_image=itemView.findViewById(R.id.album_img);
            album_card=itemView.findViewById(R.id.album_card);
            artist_name=itemView.findViewById(R.id.artist_name);

        }
    }
}