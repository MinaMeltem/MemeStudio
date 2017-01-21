package com.example.queenabergen.memestudio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by yojanasharma on 1/20/17.
 */

public class SecondActivity extends AppCompatActivity {
    ImageView imageview;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        imageview = (ImageView) findViewById(R.id.second_image);
        editText = (EditText) findViewById(R.id.memetext_top);
        editText = (EditText) findViewById(R.id.memetext_bottom);
        Button button = (Button) findViewById(R.id.save_image_button);

       final Integer id = (Integer) getIntent().getExtras().get(getResources().getString(R.string.image_to_pass));

        Picasso.with(getApplicationContext())
                .load(id)
                .resize(1000, 1000)
                .centerInside()
                .into(imageview);
        Bitmap icon = BitmapFactory.decodeResource(getResources(), id);
        Bitmap mutableBitmap = icon.copy(Bitmap.Config.ARGB_8888, true);


        Canvas canvas = new Canvas(mutableBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(200);
        //paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER)); // Text Overlapping Pattern

        canvas.drawBitmap(mutableBitmap, 0, 0, paint);
        canvas.drawText("Testing...", mutableBitmap.getHeight() /3 ,mutableBitmap.getWidth() /3, paint);
        canvas.drawText("Testing...", 500, 1000, paint);
        canvas.save();

        imageview.setImageBitmap(mutableBitmap);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //2 strings
                //saveimage(icon, "toptest", "bottomtest");
            }
        });

    }

    public void saveimage(Bitmap bitmap, String top, String bottom) {





    }
}
