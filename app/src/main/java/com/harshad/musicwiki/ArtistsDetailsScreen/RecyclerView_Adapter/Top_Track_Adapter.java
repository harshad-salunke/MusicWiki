package com.harshad.musicwiki.ArtistsDetailsScreen.RecyclerView_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.harshad.musicwiki.AlbumDetailScreen.DataModels.AlbumTrack;
import com.harshad.musicwiki.AlbumDetailScreen.Recyclerview_Adapters.Track_Adapter;
import com.harshad.musicwiki.ArtistsDetailsScreen.DataModels.ArtistTopTracksModels.TopTrack;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

public class Top_Track_Adapter extends RecyclerView.Adapter<Top_Track_Adapter.RecyclerViewHolder> {
    private ArrayList<TopTrack> trackArrayList;
    private Context mcontext;
    public Top_Track_Adapter(ArrayList<TopTrack> recyclerDataArrayList, Context mcontext) {
        this.trackArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public Top_Track_Adapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_track_view, parent, false);
        return new Top_Track_Adapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {


        TopTrack track=trackArrayList.get(position);
        holder.track_title.setText(track.getName());
        holder.track_art.setText(track.getArtistInfo().getName());
        Glide.with(mcontext)
                .load(R.drawable.genere).placeholder(R.drawable.music_holder)
                .into(holder.track_img);
        holder.track_length.setText(track.getListeners()+"");
    }

    @Override
    public int getItemCount() {
        return   trackArrayList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView track_title;
        private ImageView track_img;
        private CardView track_card;
        private  TextView track_art;
        private  TextView track_length;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            track_title = itemView.findViewById(R.id.track_name);
            track_img=itemView.findViewById(R.id.track_img);
            track_card=itemView.findViewById(R.id.track_card);
            track_art=itemView.findViewById(R.id.artist_name);
            track_length=itemView.findViewById(R.id.length);


        }
    }
}
