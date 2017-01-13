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

import static com.example.queenabergen.memestudio.R.drawable.meme10;
import static com.example.queenabergen.memestudio.R.drawable.meme11;
import static com.example.queenabergen.memestudio.R.drawable.meme12;
import static com.example.queenabergen.memestudio.R.drawable.meme13;
import static com.example.queenabergen.memestudio.R.drawable.meme14;
import static com.example.queenabergen.memestudio.R.drawable.meme15;
import static com.example.queenabergen.memestudio.R.drawable.meme16;
import static com.example.queenabergen.memestudio.R.drawable.meme17;
import static com.example.queenabergen.memestudio.R.drawable.meme18;
import static com.example.queenabergen.memestudio.R.drawable.meme19;
import static com.example.queenabergen.memestudio.R.drawable.meme2;
import static com.example.queenabergen.memestudio.R.drawable.meme21;
import static com.example.queenabergen.memestudio.R.drawable.meme22;
import static com.example.queenabergen.memestudio.R.drawable.meme23;
import static com.example.queenabergen.memestudio.R.drawable.meme24;
import static com.example.queenabergen.memestudio.R.drawable.meme25;
import static com.example.queenabergen.memestudio.R.drawable.meme26;
import static com.example.queenabergen.memestudio.R.drawable.meme27;
import static com.example.queenabergen.memestudio.R.drawable.meme28;
import static com.example.queenabergen.memestudio.R.drawable.meme29;
import static com.example.queenabergen.memestudio.R.drawable.meme3;
import static com.example.queenabergen.memestudio.R.drawable.meme30;
import static com.example.queenabergen.memestudio.R.drawable.meme31;
import static com.example.queenabergen.memestudio.R.drawable.meme33;
import static com.example.queenabergen.memestudio.R.drawable.meme37;
import static com.example.queenabergen.memestudio.R.drawable.meme38;
import static com.example.queenabergen.memestudio.R.drawable.meme4;
import static com.example.queenabergen.memestudio.R.drawable.meme40;
import static com.example.queenabergen.memestudio.R.drawable.meme6;
import static com.example.queenabergen.memestudio.R.drawable.meme7;
import static com.example.queenabergen.memestudio.R.drawable.meme8;
import static com.example.queenabergen.memestudio.R.drawable.meme9;
import static com.example.queenabergen.memestudio.R.drawable.memes20;
import static com.example.queenabergen.memestudio.R.drawable.memes5;
import static com.example.queenabergen.memestudio.R.drawable.memestudio;

/**
 * Created by queenabergen on meme22/8/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ImageView imageView;
    private Context mContext ;

    private int[] memeOptions = {R.drawable.meme1,
            R.drawable.memestudio, meme2, meme3,meme4, memes5, meme6, meme7,
            meme8, meme9, meme10, meme11, meme12, meme13, meme14,
            meme15, meme16, meme17, meme18,memestudio, meme19, memes20, meme21,
            meme22, meme23,meme24,meme25,meme26,
    meme27, meme28,meme29,meme30, meme31, meme33,memestudio, meme37,meme38,meme40};


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imageView;
        public TextView textView;
        /*
        Add a method that will address to putting the memestudio head in the recycler view at a certain rate.
        i think with a memeapi i could get
         */


        private Context getContext() {
            return mContext;
        }


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
        Picasso.with(mContext).load(memeOptions[i]).resize(160, 160).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return memeOptions.length;
    }

}
