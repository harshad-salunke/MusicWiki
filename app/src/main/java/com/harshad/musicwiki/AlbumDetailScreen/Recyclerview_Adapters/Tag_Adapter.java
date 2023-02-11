package com.harshad.musicwiki.AlbumDetailScreen.Recyclerview_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.harshad.musicwiki.AlbumDetailScreen.DataModels.AlbumTag;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

public class Tag_Adapter extends RecyclerView.Adapter<Tag_Adapter.RecyclerViewHolder> {
    private ArrayList<AlbumTag> albumArrayList;
    private Context mcontext;
    public Tag_Adapter(ArrayList<AlbumTag> recyclerDataArrayList, Context mcontext) {
        this.albumArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tag_view, parent, false);
        return new Tag_Adapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        AlbumTag album=albumArrayList.get(position);
        holder.album_text.setText(album.getName());
    }



    @Override
    public int getItemCount() {
        return   albumArrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView album_text;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            album_text = itemView.findViewById(R.id.album_tag);


        }
    }
}
