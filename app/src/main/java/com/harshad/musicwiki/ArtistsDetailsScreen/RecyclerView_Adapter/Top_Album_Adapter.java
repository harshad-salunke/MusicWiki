package com.harshad.musicwiki.ArtistsDetailsScreen.RecyclerView_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopAlbumModels.TopAlbum;
import com.harshad.musicwiki.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Top_Album_Adapter extends RecyclerView.Adapter<Top_Album_Adapter.RecyclerViewHolder> {
private ArrayList<TopAlbum> albumArrayList;
private Context mcontext;
public Top_Album_Adapter(ArrayList<TopAlbum> recyclerDataArrayList, Context mcontext) {
        this.albumArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
        }

@NonNull
@Override
public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_ablum_view, parent, false);
        return new Top_Album_Adapter.RecyclerViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            TopAlbum topAlbum=albumArrayList.get(position);
            holder.album_text.setText(topAlbum.getName());
            holder.play_count.setText(topAlbum.getPlaycount()+"");

    Glide.with(mcontext).load(topAlbum.getImageInfoArrayList().get(3).getText())
            .placeholder(R.drawable.music_holder).into(holder.album_image);

        }



@Override
public int getItemCount() {
        return   albumArrayList.size();
        }


public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private TextView album_text,play_count;
    private ImageView album_image;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        album_text = itemView.findViewById(R.id.album_name);
        album_image=itemView.findViewById(R.id.album_image);
        play_count=itemView.findViewById(R.id.play_count);


    }
}
}