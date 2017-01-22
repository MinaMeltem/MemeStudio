package com.example.queenabergen.memestudio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yojanasharma on 1/20/17.
 */

public class ImageAdapter extends RecyclerView.Adapter {

    List<Image> imageList = Arrays.asList(
            new Image("meme1", R.drawable.meme1),
            new Image("meme2", R.drawable.meme2),
            new Image("meme3", R.drawable.meme3),
            new Image("meme4", R.drawable.meme4),
            new Image("meme5", R.drawable.meme5),
            new Image("meme6", R.drawable.meme6),
            new Image("meme7", R.drawable.meme7),
            new Image("meme8", R.drawable.meme8),
            new Image("meme9", R.drawable.meme9),
            new Image("meme10", R.drawable.meme10)
    );
    Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ImageViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageViewHolder viewHolder = (ImageViewHolder) holder;
        final Image image = imageList.get(position);
        viewHolder.bind(image);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}
