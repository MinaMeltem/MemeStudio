package com.example.queenabergen.memestudio;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by queenabergen on 1/8/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private List<Drawable> memePhotos;

    public RecyclerViewAdapter(List<Drawable> photoList) {
        this.memePhotos= photoList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imageView;


        public MyViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.cardView);
            imageView = (ImageView) view.findViewById(R.id.holderImageView);

        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageDrawable(memePhotos.get(0));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
