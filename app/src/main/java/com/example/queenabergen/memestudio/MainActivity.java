package com.example.queenabergen.memestudio;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter mAdapter;
    private Context context = this;
    private LinearLayoutManager mylinearLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private Context mContext;
    private ImageView imageView;
    private ButtonAdapter bAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CollapsingToolbarLayout collapsy = new CollapsingToolbarLayout(this);
        collapsy.setExpandedTitleGravity(50);
        collapsy.setCollapsedTitleGravity(50);


        ImageView logobanner = (ImageView) findViewById(R.id.logoBanner);
        Picasso.with(this).load(R.drawable.memestudiologo).into(logobanner);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setBackgroundColor(getResources().getColor(R.color.white));
        mylinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mylinearLayoutManager);
        mAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(mAdapter);




    }

}
