package com.harshad.musicwiki.HomeScreen.Adapter;

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
import com.harshad.musicwiki.GenreDetailScreen.GenreDetailActivity;
import com.harshad.musicwiki.HomeScreen.Models.Genre;
import com.harshad.musicwiki.R;

import java.util.ArrayList;

public class GenerRecyclerViewAdapter extends RecyclerView.Adapter<GenerRecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<String> genreDataArrayList;
    private Context mcontext;
    private  int limit=10;
    public GenerRecyclerViewAdapter(ArrayList<String> recyclerDataArrayList, Context mcontext) {
        this.genreDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gemres_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenerRecyclerViewAdapter.RecyclerViewHolder holder, int position) {
        String genre_str = genreDataArrayList.get(position);
        holder.genre_name.setText(genre_str);
        Glide.with(mcontext)
                .load(R.drawable.genere)
                .into(holder.genre_image);
        holder.genre_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mcontext, GenreDetailActivity.class);
                intent.putExtra("genreName",genre_str);
                mcontext.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        if(genreDataArrayList.size()>limit){
            return limit;

        }else{
            return  genreDataArrayList.size();
        }
    }

    public void setLimitItem(){
        this.limit=10;
        notifyDataSetChanged();

    }
    public  void setAllItem(){
        this.limit=genreDataArrayList.size();
        notifyDataSetChanged();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView genre_name;
        private ImageView genre_image;
        private CardView genre_card;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            genre_name = itemView.findViewById(R.id.genre_name);
            genre_image=itemView.findViewById(R.id.genre_image);
            genre_card=itemView.findViewById(R.id.genre_card);

        }
    }
}