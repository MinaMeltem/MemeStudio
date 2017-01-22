package com.example.queenabergen.memestudio;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
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

<<<<<<< HEAD
=======
//        CollapsingToolbarLayout collapsy = new CollapsingToolbarLayout(this);
//        collapsy.setTitle("MEME STUDIO");
//        collapsy.setExpandedTitleGravity(50);
//        collapsy.setCollapsedTitleGravity(50);

        initCollapsingToolbar();

>>>>>>> 0e1d348716c83cb0ece107791b201c1f430a9307
        ImageView logobanner = (ImageView) findViewById(R.id.logoBanner);
        Picasso.with(this).load(R.drawable.memestudiologo).into(logobanner);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setBackgroundColor(getResources().getColor(R.color.white));
        mylinearLayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false);
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

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
//        collapsingToolbar.setTitle("Meme Studio");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle("Meme Studio");
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle("");
                    isShow = false;
                }
            }
        });
    }



}
