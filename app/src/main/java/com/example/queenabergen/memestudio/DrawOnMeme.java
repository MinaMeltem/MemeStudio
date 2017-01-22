
package com.example.queenabergen.memestudio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.util.LinkedHashMap;

import static android.graphics.Color.argb;

/**
 * Created by meltemyildirim on 1/16/17.
 */

public class DrawOnMeme extends ImageView {


    int currentStrokeWidth;
    int currentColor;
    private LinkedHashMap<Path, Paint> paths = new LinkedHashMap<>();
    private Path currentPath = new Path();

    //Constructors
    public DrawOnMeme(Context context) {
        super(context);
        init(null, 0);
    }

    public DrawOnMeme(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DrawOnMeme(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        currentColor = Color.BLACK;
        currentStrokeWidth = 7;
    }

    private Paint getPaint() {
        Paint paint = new Paint();
        paint.setColor(currentColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(currentStrokeWidth);
        return paint;
    }


    //button methods
    public void setStrokeBlack() {
        currentColor = Color.BLACK;
    }

    public void setStrokeWhite() {
        currentColor = Color.WHITE;
    }

    public void setStrokeGreen() {
        currentColor = Color.GREEN;
    }

    public void setStrokeRed() {
        currentColor = Color.RED;
    }

    public void setStrokeOrange() {
        currentColor = Color.argb(255, 238, 72, 1);
    }

    public void setStrokeYellow() {
        currentColor = Color.YELLOW;
    }

    public void setStrokeBlue() {
        currentColor = Color.BLUE;
    }

    public void setStrokePurple() {
        currentColor = argb(255, 150, 64, 255);
    }

    public void setStrokePink() {
        currentColor = argb(255, 230, 70, 251);
    }

    public void setStrokeThick() {
        currentStrokeWidth = 20;
    }

    public void setStrokeThin() {
        currentStrokeWidth = 10;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Path path : paths.keySet()) {
            canvas.drawPath(path, paths.get(path));
        }

    }


    public void undo() {
        paths.remove(currentPath);
        this.invalidate();
    }


    public void clearCanvas() {
        currentPath.reset();
        paths.clear();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                currentPath = new Path();
                paths.put(currentPath, getPaint());
                currentPath.moveTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_UP:
                currentPath.moveTo(touchX, touchY);
                break;


        }

        invalidate();

        return true;
    }

}
