package com.example.queenabergen.memestudio;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class LandingPage extends AppCompatActivity {
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mylinearLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private ImageView imageView;
    private ButtonAdapter bAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        CollapsingToolbarLayout collapsy = new CollapsingToolbarLayout(this);
        collapsy.setExpandedTitleGravity(50);
        collapsy.setCollapsedTitleGravity(50);


        ImageView logobanner = (ImageView) findViewById(R.id.logoBanner);
        Picasso.with(this).load(R.drawable.memestudiologo).into(logobanner);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setBackgroundColor(getResources().getColor(R.color.white));
        mylinearLayoutManager = new GridLayoutManager(getApplicationContext(), 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mylinearLayoutManager);
        mAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(mAdapter);

        RecyclerView buttonReelRec = (RecyclerView) findViewById(R.id.recyclerView2);
        buttonReelRec.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        buttonReelRec.setLayoutManager(layoutManager);
        bAdapter = new ButtonAdapter();
        buttonReelRec.setAdapter(bAdapter);

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(5000);
        itemAnimator.setRemoveDuration(5000);
        recyclerView.setItemAnimator(itemAnimator);

    }

}
