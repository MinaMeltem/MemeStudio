package com.example.queenabergen.memestudio;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter mAdapter;
    private Context context = this;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView topBannerPhoto = (ImageView) findViewById(R.id.logoBanner);
        topBannerPhoto.setImageResource(R.drawable.memestudiologo);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        mAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(mAdapter);

    }

}
