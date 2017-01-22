package com.example.queenabergen.memestudio;

import android.animation.Animator;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.queenabergen.memestudio.R.drawable.meme100;
import static com.example.queenabergen.memestudio.R.drawable.meme11;
import static com.example.queenabergen.memestudio.R.drawable.meme12;
import static com.example.queenabergen.memestudio.R.drawable.meme13;
import static com.example.queenabergen.memestudio.R.drawable.meme14;
import static com.example.queenabergen.memestudio.R.drawable.meme15;
import static com.example.queenabergen.memestudio.R.drawable.meme16;
import static com.example.queenabergen.memestudio.R.drawable.meme17;
import static com.example.queenabergen.memestudio.R.drawable.meme18;
import static com.example.queenabergen.memestudio.R.drawable.meme19;
import static com.example.queenabergen.memestudio.R.drawable.meme200;
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
import static com.example.queenabergen.memestudio.R.drawable.meme400;
import static com.example.queenabergen.memestudio.R.drawable.meme40;
import static com.example.queenabergen.memestudio.R.drawable.meme600;
import static com.example.queenabergen.memestudio.R.drawable.meme700;
import static com.example.queenabergen.memestudio.R.drawable.meme800;
import static com.example.queenabergen.memestudio.R.drawable.meme900;
import static com.example.queenabergen.memestudio.R.drawable.memes20;
import static com.example.queenabergen.memestudio.R.drawable.memes5;
import static com.example.queenabergen.memestudio.R.drawable.memestudio;


class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final static int FADE_DURATION = 3000;
    private ImageView imageView;
    private ButtonAdapter bAdapter;
    private Context mContext;
    private RecyclerView.LayoutManager layoutManager;

    private Animator mCurrentAnimator;
    private int mShortAnimationDuration;


    private int[] memeOptions = {R.drawable.meme221,
            R.drawable.memestudio, meme200, meme3, meme400, memes5, meme600, meme700,
            meme800, meme900, meme100, meme11, meme12, meme13, meme14,
            meme15, meme16, meme17, meme18, memestudio, meme19, memes20, meme21,
            meme22, meme23, meme24, meme25, meme26,
            meme27, meme28, meme29, meme30, meme31, meme33, memestudio, meme37, meme38, meme40};


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public ImageView imageView;
        public RecyclerView recyclerView;
        public FloatingActionButton floatingActionButton;

        public TextView textView;
        /*
        Add a method that will address to putting the memestudio head in the recycler view at a certain rate.
        i think with a memeapi i could get
         */


        public MyViewHolder(final View itemview) {
            super(itemview);
            cardView = (CardView) itemview.findViewById(R.id.cardView);
            imageView = (ImageView) itemview.findViewById(R.id.holderImageView);
            recyclerView = (RecyclerView) itemview.findViewById(R.id.recyclerView2);
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
        setScaleAnimation(holder.itemView);

    }


    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }


    @Override
    public int getItemCount() {

        return memeOptions.length;
    }


}
