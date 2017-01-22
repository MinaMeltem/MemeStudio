package com.example.queenabergen.memestudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

public class DogMemes extends AppCompatActivity {
    public LinearLayoutManager linearLayoutManager;
    public DogAdapter dogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dog_memes);
        RecyclerView dogRecView = (RecyclerView) findViewById(R.id.dog_RecView);
        dogRecView.setNestedScrollingEnabled(false);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        dogRecView.setLayoutManager(linearLayoutManager);
        dogAdapter = new DogAdapter();
        dogRecView.setAdapter(dogAdapter);

        ImageView save_btn = (ImageView) findViewById(R.id.save_Dog_btn);
        ImageView share_btn = (ImageView) findViewById(R.id.share_Dog_btn);
        EditText editText = (EditText) findViewById(R.id.edit_dog_words);

        Picasso.with(getApplicationContext()).load(R.drawable.savebutton).into(save_btn);
        Picasso.with(getApplicationContext()).load(R.drawable.sharebutton).into(share_btn);



    }
}
