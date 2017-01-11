package com.example.queenabergen.memestudio;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;


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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.topToolbar);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        Resources.Theme theme = getTheme();
        ImageView topBannerPhoto = (ImageView) findViewById(R.id.logoBanner);
        topBannerPhoto.setImageResource(R.drawable.collapsebanner);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        mAdapter = new RecyclerViewAdapter(context, memeOptions );
        recyclerView.setAdapter(mAdapter);
    }
}
