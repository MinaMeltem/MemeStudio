package com.example.queenabergen.memestudio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by queenabergen on meme22/12/17.
 */

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ButtonHolder> {

    private String[] listofTypes = {"Vanilla Memes",
            "Dog Memes", "Bordered Memes", "Random Memes",
            "Tuesday Memes", "WWJD Memes"};


    public class ButtonHolder extends RecyclerView.ViewHolder {
        public Button memeButton;

        public ButtonHolder(View itemView) {
            super(itemView);
           memeButton = (Button) itemView.findViewById(R.id.memeButton);
        }
    }

    @Override
    public ButtonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.buttonholder, parent, false);

        return new ButtonHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ButtonHolder holder, int position) {
        holder.memeButton.setText(listofTypes[position]);
    }

    @Override
    public int getItemCount() {
        return listofTypes.length;
    }
}
