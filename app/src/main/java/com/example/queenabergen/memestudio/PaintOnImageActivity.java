package com.example.queenabergen.memestudio;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by meltemyildirim on 1/9/17.git
 */

public class PaintOnImageActivity extends AppCompatActivity {

    // this is the action code we use in our intent,
    // this way we know we're looking at the response from our own action
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;

    private Button fromGallery;
    private Button fromCamera;
    private Button greenBtn;
    private Button redBtn;
    private Button blueBtn;
    private Button yellowBtn;
    private Button strokeThin;
    private Button strokeThick;
    private DrawOnMeme selectedImage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_from_device_xml);

        fromGallery = (Button) findViewById(R.id.from_gallery_bt);
        redBtn = (Button) findViewById(R.id.color_red_button);
        yellowBtn = (Button) findViewById(R.id.color_yellow_button);
        blueBtn = (Button) findViewById(R.id.color_blue_button);
        greenBtn = (Button) findViewById(R.id.color_green_button);
        strokeThick = (Button) findViewById(R.id.stroke_thick_button);
        strokeThin = (Button) findViewById(R.id.stroke_thin_button);
        selectedImage = (DrawOnMeme) findViewById(R.id.chosen_image_iv);


        fromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(galleryIntent.createChooser(galleryIntent, "Select Picture"), SELECT_PICTURE);



            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);


                selectedImage.setImageURI(selectedImageUri);


            }

        }
    }


    public String getPath(Uri uri){
        if (uri == null){
            Toast.makeText(this, "URL path is empty", Toast.LENGTH_SHORT).show();
            return null;
        }
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);

        if (cursor != null) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String path = cursor.getString(column_index);
            cursor.close();
            return path;
        }
        return uri.getPath();
    }

}
