package com.example.queenabergen.memestudio;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter mAdapter;
    private ButtonAdapter bAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsy = new CollapsingToolbarLayout(this);
        collapsy.setExpandedTitleGravity(50);
        collapsy.setCollapsedTitleGravity(50);

        ImageView topBannerPhoto = (ImageView) findViewById(R.id.logoBanner);
        Picasso.with(this).load(R.drawable.memestudiologo).into(topBannerPhoto);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        mAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(mAdapter);

//        RecyclerView recyclerView1 = (RecyclerView)findViewById(R.id.create_Buttons);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView1.setLayoutManager(layoutManager);
//        bAdapter = new ButtonAdapter();
//        recyclerView1.setAdapter(bAdapter);


    }

}
