package com.example.queenabergen.memestudio;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on 1/8/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ImageView imageView;

    private int[] memeOptions = {R.drawable.meme1,
            R.drawable.meme2,
            R.drawable.meme3,
            R.drawable.meme4,
            R.drawable.memes5,
            R.drawable.meme6,
            R.drawable.meme7,
            R.drawable.meme8,
            R.drawable.meme9,
            R.drawable.meme10,
            R.drawable.meme11,
            R.drawable.meme12,
            R.drawable.meme13,
            R.drawable.meme14,
            R.drawable.meme15,
            R.drawable.meme16,
            R.drawable.meme17,
            R.drawable.meme18};

    public RecyclerViewAdapter(Context context , int[] memeOptions) {
        getApplicationContext();
        this.memeOptions = memeOptions;

    }

    public Context getApplicationContext(){
        return getApplicationContext();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imageView;
        public TextView textView;


        public MyViewHolder(View itemview) {
            super(itemview);
            cardView = (CardView) itemview.findViewById(R.id.cardView);
            imageView = (ImageView) itemview.findViewById(R.id.holderImageView);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, "Making Sure It Works" + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int i) {

        holder.imageView.setImageResource(memeOptions[i]);
        Picasso.with(getApplicationContext()).load(memeOptions[i]).into(imageView);
    }

    @Override
    public int getItemCount() {
        return memeOptions.length;
    }

}
