package com.example.queenabergen.memestudio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on meme22/12/17.
 */

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonHolder> {
    private Context mContext;
    private ImageView imageView;
    private ButtonAdapter bAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private int[] memeChooserOptions = {
            R.drawable.classmeme, R.drawable.drawonmeme, R.drawable.borderedmeme
    };


    public class ButtonHolder extends RecyclerView.ViewHolder {
        public ImageView button_photo;


        public ButtonHolder(final View itemView) {
            super(itemView);
            button_photo = (ImageView) itemView.findViewById(R.id.button_reel_photo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    switch (position) {
                        case 0:
                        case 1:
                        case 2:
                            break;
                    }
                }
            });
        }
    }


    @Override
    public ButtonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buttonreel, parent, false);
        return new ButtonHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ButtonHolder holder, int position) {
        Picasso.with(mContext).load(memeChooserOptions[position]).resize(550, 550).into(holder.button_photo);
    }

    @Override
    public int getItemCount() {
        return memeChooserOptions.length;
    }

}
