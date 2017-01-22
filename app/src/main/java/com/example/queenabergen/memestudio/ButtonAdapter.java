package com.example.queenabergen.memestudio;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on meme22/12/17.
 */

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonHolder> {
    private Context mContext;
    private final static int FADE_DURATION = 1800;

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
                            Intent moveToYojanaFragment = new Intent(v.getContext(), LandingPage.class);
                            v.getContext().startActivity(moveToYojanaFragment);
                            break;

                        case 1:
                            Intent moveToMelFragment = new Intent(v.getContext(), PaintOnImageActivity.class);
                            v.getContext().startActivity(moveToMelFragment);
                            break;
                        case 2:
                            Intent moveToJozyFragment = new Intent(v.getContext(), Demotivational.class);
                            v.getContext().startActivity(moveToJozyFragment);
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
    public void onBindViewHolder(ButtonHolder holder, int i) {
        Picasso.with(mContext).load(memeChooserOptions[i]).resize(550, 550).into(holder.button_photo);
        setScaleAnimation(holder.itemView);

    }


    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return memeChooserOptions.length;
    }

}
