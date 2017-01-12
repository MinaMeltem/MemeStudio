package com.example.queenabergen.memestudio;

import android.content.Context;
import android.content.Intent;
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
import static com.example.queenabergen.memestudio.R.drawable.meme3;
import static com.example.queenabergen.memestudio.R.drawable.meme4;
import static com.example.queenabergen.memestudio.R.drawable.meme6;
import static com.example.queenabergen.memestudio.R.drawable.meme7;
import static com.example.queenabergen.memestudio.R.drawable.meme8;
import static com.example.queenabergen.memestudio.R.drawable.meme9;
import static com.example.queenabergen.memestudio.R.drawable.memes20;
import static com.example.queenabergen.memestudio.R.drawable.memes5;

/**
 * Created by queenabergen on 1/8/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ImageView imageView;
    private Context mContext;

    private int[] memeOptions = {R.drawable.meme1,
            R.drawable.meme2, meme3, meme4, memes5,  meme6, meme7,
    meme8, meme9, meme10, meme11, meme12,meme13,meme14, meme15,meme16,meme17,meme18,meme19,memes20};



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView imageView;
        public TextView textView;

//
//        public byte[] getByteForPhotos(int [] memeoptions){
//
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.meme1);
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            byte[] bitMapData = stream.toByteArray();
//
//            return bitMapData;
//        }

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
                    Intent intent = new Intent(getContext(), MakeAMeme.class);
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
//        holder.imageView.setImageResource(memeOptions[i]);
        Picasso.with(mContext).load(memeOptions[i]).resize(160,160).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return memeOptions.length;
    }

}
