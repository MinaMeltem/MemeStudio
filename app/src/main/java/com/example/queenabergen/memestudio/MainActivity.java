package com.example.queenabergen.memestudio;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.queenabergen.memestudio.R.id.floatingActionButton;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.topToolbar);
        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(floatingActionButton);
        int red = R.color.red;
        floatingActionButton.setBackgroundColor(getColor(red));
    }
}
