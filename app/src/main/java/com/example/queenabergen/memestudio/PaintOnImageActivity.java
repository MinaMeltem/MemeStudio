package com.example.queenabergen.memestudio;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by meltemyildirim on 1/9/17.git
 */

public class PaintOnImageActivity extends AppCompatActivity {
    private static final int SELECT_PICTURE = 1;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    private String selectedImagePath;
    private DrawOnMeme customViewObj;
    private Button fromGallery;
    private Button fromCamera;
    private Button blackBtn;
    private Button greenBtn;
    private Button redBtn;
    private Button orangeBtn;
    private Button blueBtn;
    private Button purpleBtn;
    private Button pinkBtn;
    private Button yellowBtn;
    private Button whiteBtn;
    private ImageButton undo;
    private ImageButton strokeThin;
    private ImageButton strokeThick;
    private ImageButton save;
    private ImageButton share;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_from_device_xml);

        fromGallery = (Button) findViewById(R.id.from_gallery_bt);
        fromCamera = (Button)findViewById(R.id.from_camera_bt);
        blackBtn = (Button) findViewById(R.id.color_black_button);
        greenBtn = (Button) findViewById(R.id.color_green_button);
        redBtn = (Button) findViewById(R.id.color_red_button);
        orangeBtn = (Button) findViewById(R.id.color_orange_button);
        blueBtn = (Button) findViewById(R.id.color_blue_button);
        purpleBtn = (Button) findViewById(R.id.color_purple_button);
        pinkBtn = (Button) findViewById(R.id.color_pink_button);
        yellowBtn = (Button) findViewById(R.id.color_yellow_button);
        strokeThick = (ImageButton) findViewById(R.id.stroke_thick_button);
        strokeThin = (ImageButton) findViewById(R.id.stroke_thin_button);
        whiteBtn = (Button)findViewById(R.id.color_white_button);
        undo = (ImageButton)findViewById(R.id.undo_button);
        customViewObj = (DrawOnMeme) findViewById(R.id.chosen_image_iv);
        save = (ImageButton) findViewById(R.id.save_bt);
        share = (ImageButton)findViewById(R.id.share_bt) ;


        fromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(galleryIntent.createChooser(galleryIntent, "Select Picture"), SELECT_PICTURE);
            }
        });

        fromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });

        blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeBlack();
            }

        });

        whiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeWhite();
            }
        });

        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeGreen();
            }

        });

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeRed();
            }
        });

        orangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeOrange();
            }

        });

        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeBlue();
            }

        });

        purpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokePurple();
            }

        });

        pinkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokePink();
            }
        });

        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeYellow();
            }
        });

        strokeThin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeThin();
            }

        });

        strokeThick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.setStrokeThick();
            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               save();
            }
        });

        share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                share();
            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewObj.undo();
            }
        });


    }

    private void share() {
        String uri = save();
        Intent intentshare = new Intent();
        intentshare.setAction(Intent.ACTION_SEND);
        intentshare.setType("image/*");
        intentshare.putExtra(Intent.EXTRA_STREAM, Uri.parse(uri));
        startActivity(Intent.createChooser(intentshare, "Share"));
    }

    private String save() {

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1 );
        customViewObj.setDrawingCacheEnabled(true);
        Bitmap b = customViewObj.getDrawingCache();
        String uri = MediaStore.Images.Media.insertImage(getContentResolver(), b, "image1", "an image");
        Toast.makeText(this,"Image has Saved in Gallery", Toast.LENGTH_LONG ).show();
        return uri;
    }

    private void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                customViewObj.setImageURI(selectedImageUri);
            }
        }

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap b = (Bitmap) extras.get("data");
            customViewObj.setImageBitmap(b);

        }
    }

    public String getPath(Uri uri) {
        if (uri == null) {
            Toast.makeText(this, "URL path is empty", Toast.LENGTH_SHORT).show();
            return null;
        }
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);

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





