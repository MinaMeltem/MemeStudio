package com.example.queenabergen.memestudio;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MakeAmeme extends AppCompatActivity {
    private RecyclerViewAdapter mAdapter;
    private ButtonAdapter bAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Context context = this;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private FloatingActionButton floatingActionButton;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsy = new CollapsingToolbarLayout(this);
        collapsy.setExpandedTitleGravity(50);
        collapsy.setCollapsedTitleGravity(50);


        ImageView logobanner = (ImageView) findViewById(R.id.logoBanner);
        Picasso.with(this).load(R.drawable.memestudiologo).into(logobanner);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setBackgroundColor(getResources().getColor(R.color.black));
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        mAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(mAdapter);
//
//        RecyclerView recyclerView1 = (RecyclerView)findViewById(R.id.create_Buttons);
//        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView1.setLayoutManager(layoutManager);
//        bAdapter = new ButtonAdapter();
//        recyclerView1.setAdapter(bAdapter);

//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MakeAMeme.class);
//                startActivity(intent);
//            }
//        });
//    }

    }
}
