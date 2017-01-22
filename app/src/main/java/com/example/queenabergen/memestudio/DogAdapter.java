package com.example.queenabergen.memestudio;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on 1/22/17.
 */

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogHolder> {
    private final static int FADE_DURATION = 1000;
    private Context mContext;

    private int[] dogMemes = {R.drawable.dogmeme, R.drawable.dogmem2, R.drawable.dogmem3,
            R.drawable.dogmeme4, R.drawable.dogmeme5, R.drawable.dogmeme6, R.drawable.dogmeme7,
            R.drawable.dogmeme8, R.drawable.dogmeme9, R.drawable.dogmeme10, R.drawable.dogmeme11, R.drawable.dogmeme12,
            R.drawable.dogmeme13, R.drawable.dogmeme14, R.drawable.dogmeme15, R.drawable.dogmeme16};


    public class DogHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public RecyclerView recyclerView;
        public ImageView imageView;
        /*
        Add a method that will address to putting the memestudio head in the recycler view at a certain rate.
        i think with a memeapi i could get
         */


        public DogHolder(final View itemview) {
            super(itemview);
            cardView = (CardView) itemview.findViewById(R.id.dog_cardView);
            imageView = (ImageView) itemview.findViewById(R.id.dog_ImageView);
            recyclerView = (RecyclerView) itemview.findViewById(R.id.dog_RecView);
        }
    }

    @Override
    public DogHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dogholder, parent, false);
        return new DogAdapter.DogHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DogHolder holder, int position) {
        Picasso.with(mContext).load(dogMemes[position]).resize(160, 160).into(holder.imageView);
        setScaleAnimation(holder.itemView);
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return dogMemes.length;
    }

}
