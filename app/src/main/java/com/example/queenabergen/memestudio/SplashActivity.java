package com.example.queenabergen.memestudio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on meme22/12/17.
 */

public class SplashActivity extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splashactivity);
            Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
            ImageView studiologo = (ImageView)findViewById(R.id.splash_logo);
            Picasso.with(getApplicationContext()).load(R.drawable.memestudio).into(studiologo);
            ImageView cuelogo = (ImageView) findViewById(R.id.cue_logo);
            Picasso.with(getApplicationContext()).load(R.drawable.splash_logo).into(cuelogo);
            cuelogo.setAnimation(anim);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 3500);
    }
}
