package com.example.queenabergen.memestudio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on meme22/12/17.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);
        ImageView studiologo = (ImageView) findViewById(R.id.splash_logo);
        Picasso.with(getApplicationContext()).load(R.drawable.memestudio).into(studiologo);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LandingPage.class);
                startActivity(intent);
                finish();
            }
        }, 2700);
    }
}
