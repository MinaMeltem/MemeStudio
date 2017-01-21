package com.example.queenabergen.memestudio;

import java.io.File;
import java.io.FileOutputStream;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MakeAMeme extends AppCompatActivity {

    // Whateever button we press to come to this screen to meme

    private static final int MY_PERMISSION_REQUEST = 1;
    private static final int RESULT_LOAD_IMAGE = 2;
    private String imgDecodableString;
    private Button load, save, share, go;
    private TextView textView1, textView2;
    private EditText editText1, editText2;
    private ImageView imageView;
    private String currentImage = " ";

//    TextView textTargetUri;
//    ImageView targetImage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_meme);

        // Would check if we have permissions, but works without

//        if (ContextCompat.checkSelfPermission(MakeAMeme.this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(MakeAMeme.this,
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//                ActivityCompat.requestPermissions(MakeAMeme.this,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
//
//            } else {
//                ActivityCompat.requestPermissions(MakeAMeme.this,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
//            }
//
//        } else {
//            // do nothing
//        }



//        Cast

        imageView = (ImageView) findViewById(R.id.imageView);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        editText1 = (EditText) findViewById(R.id.edit_text1);
        editText2 = (EditText) findViewById(R.id.edit_text2);
        load = (Button) findViewById(R.id.load);
        save = (Button) findViewById(R.id.save);
        share = (Button) findViewById(R.id.share);
        go = (Button) findViewById(R.id.go);
        save.setEnabled(false);
        share.setEnabled(false);


//        Set onClicks

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadImagefromGallery(view);
            }
//            @Override
//            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, 0);
//            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View content = findViewById(R.id.lay);
                Bitmap bitmap = getScreenShot(content);
                currentImage = "meme" + System.currentTimeMillis() + "png";
                store(bitmap, currentImage);
                share.setEnabled(true);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareImage(currentImage);
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText(editText1.getText().toString());
                textView2.setText(editText2.getText().toString());
                editText1.setText("");
                editText2.setText("");
            }
        });

//        Button buttonLoadImage = (Button) findViewById(R.id.loadimage);
//        textTargetUri = (TextView) findViewById(R.id.targeturi);
//        targetImage = (ImageView) findViewById(R.id.targetimage);
//
//        buttonLoadImage.setOnClickListener(new Button.OnClickListener() {
//
//            @Override
//            public void onClick(View arg0) {
//                // TODO Auto-generated method stub
//                Intent intent = new Intent(Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                startActivityForResult(intent, 0);
//            }
//        });
    }

//Load images

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

                    if (ContextCompat.checkSelfPermission(MakeAMeme.this,
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

    public static Bitmap getScreenShot(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }


//    Should fix to save to internal

    public void store(Bitmap bm, String fileName) {
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MEME";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dirPath, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
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

        intent.putExtra(Intent.EXTRA_SUBJECT, " ");
        intent.putExtra(Intent.EXTRA_TEXT, " ");
        intent.putExtra(Intent.EXTRA_STREAM, uri);

        try {
            startActivity(Intent.createChooser(intent, "Share via "));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No sharing app found.", Toast.LENGTH_SHORT).show();

        }

    }

//Method needed to load image

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_LOAD_IMAGE ) { // && resultCode == RESULT_OK && null != data
//            Uri selectedImage = data.getData();
//            String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//            cursor.moveToFirst();
//
//            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//            String picturePath = cursor.getString(columnIndex);
//            cursor.close();
//
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
//            save.setEnabled(true);
//            share.setEnabled(false);


        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.imageView);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));
                save.setEnabled(true);
                share.setEnabled(false);

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }

//        @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // TODO Auto-generated method stub
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (resultCode == RESULT_LOAD_IMAGE) {
//            Uri targetUri = data.getData();
//            textView1.setText(targetUri.toString());
//            Bitmap bitmap;
//            try {
//                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
//                imageView.setImageBitmap(bitmap);
//            } catch (FileNotFoundException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//    }
}