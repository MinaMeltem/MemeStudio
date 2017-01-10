package com.example.queenabergen.memestudio;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewAdapter mAdapter;
    List<Integer> memePhotos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memePhotos.add(R.drawable.meme);
        memePhotos.add(R.drawable.meme);
        memePhotos.add(R.drawable.meme);
        memePhotos.add(R.drawable.meme);
        memePhotos.add(R.drawable.meme);


        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.topToolbar);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        Resources.Theme theme = getTheme();
        ImageView topBannerPhoto = (ImageView) findViewById(R.id.logoBanner);
        topBannerPhoto.setImageResource(R.drawable.meme);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


//        mAdapter = new RecyclerViewAdapter(memePhotos);
        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager();
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
