package com.example.queenabergen.memestudio;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by yojanasharma on 1/20/17.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {
    private View view;
    private ImageView imageView;


    public ImageViewHolder(ViewGroup parent) {
        super(inflate(parent));
        view = itemView;
        imageView = (ImageView) view.findViewById(R.id.image_button);

    }

    private static View inflate(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.item_view, parent, false);
    }

    public void bind(final Image image) {

        int height = view.getLayoutParams().height;
        int width = view.getLayoutParams().width;

        Picasso.with(view.getContext())
                .load(image.getResId())
                .resize(500, 500)
                .centerInside()
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                intent.putExtra(v.getResources().getString(R.string.image_to_pass)
                        ,image.getResId());
                itemView.getContext().startActivity(intent);

            }
        });
    }
}
