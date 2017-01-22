package com.example.queenabergen.memestudio;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

import static com.example.queenabergen.memestudio.Demotivational.getScreenShot;

public class DogMemes extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST = 1;
    private static final int RESULT_LOAD_IMAGE = 2;
    public LinearLayoutManager linearLayoutManager;
    public DogAdapter dogAdapter;
    String currentImage = " ";


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

        final ImageView save_btn = (ImageView) findViewById(R.id.save_Dog_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View content = findViewById(R.id.lay);
                Bitmap bitmap = getScreenShot(content);
//                currentImage = "meme" + System.currentTimeMillis() + "png";
                store(bitmap); // or currentImage
                save_btn.setEnabled(true);
            }
        });
        ImageView load_btn = (ImageView)findViewById(R.id.load_btn);
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImagefromGallery(view);
            }
        });
        ImageView share_btn = (ImageView) findViewById(R.id.share_Dog_btn);
        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareImage(currentImage);
            }
        });
        EditText editText = (EditText) findViewById(R.id.edit_dog_words);
        editText.addTextChangedListener(new TextWatcherClass(textView1, editText));
        Picasso.with(getApplicationContext()).load(R.drawable.savebutton).into(save_btn);
        Picasso.with(getApplicationContext()).load(R.drawable.sharebutton).into(share_btn);
        Picasso.with(getApplicationContext()).load(R.drawable.upload).into(load_btn);
        textView1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    // Offsets are for centering the TextView on the touch location
                    v.setX(event.getRawX() - v.getWidth());
                    v.setY(event.getRawY() - v.getHeight());
                }
                return true;
            }
        });


    }

    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_REQUEST: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    if (ContextCompat.checkSelfPermission(DogMemes.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    }
                } else {
                    Toast.makeText(this, "No permission granted!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
            return;
        }
    }


    public void store(Bitmap bm) {
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MEME";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        try {
            MediaStore.Images.Media.insertImage(getContentResolver(), bm, "", "");
            Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

            Toast.makeText(this, "Error saving.", Toast.LENGTH_SHORT).show();
        }
    }

    private void shareImage(String fileName) {

        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MEME";
        Uri uri = Uri.fromFile(new File(dirPath, fileName));
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, uri);

        try {
            startActivity(Intent.createChooser(intent, "Share via "));

        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No sharing app found.", Toast.LENGTH_SHORT).show();
        }
    }
}
