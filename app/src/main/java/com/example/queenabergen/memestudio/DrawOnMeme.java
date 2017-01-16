package com.example.queenabergen.memestudio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by meltemyildirim on 1/16/17.
 */

public class DrawOnMeme extends ImageView {

    private Paint paintLine =  new Paint();
    private Path path  = new Path();

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

    //getter
    public Paint getPaintLine() {
        return paintLine;
    }

    public Path getPath() {
        return path;
    }

    //setter
    public void setPaintLine(Paint paintLine) {
        this.paintLine = paintLine;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        paintLine.setColor(Color.BLACK);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(10);
    }

    //button methods
    public void setStrokeRed (AttributeSet attrs){
         paintLine.setColor(Color.RED);
    }

    public void setStrokeGreen (AttributeSet attrs){
        paintLine.setColor(Color.GREEN);
    }

    public void setStrokeBlue (AttributeSet attrs){
        paintLine.setColor(Color.BLUE);
    }

    public void setStrokeYellow (AttributeSet attrs) {
        paintLine.setColor(Color.YELLOW);
    }

    public void setStrokeThick (AttributeSet attrs) {
        paintLine.setStrokeWidth(20);
    }

    public void setStrokeThin (AttributeSet attrs) {
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setStrokeWidth(10);
    }


    @Override
        protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
            canvas.drawPath(path, paintLine);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;

            case MotionEvent.ACTION_UP:
                path.moveTo(touchX, touchY);
                break;
        }

        invalidate();

        return true;
    }


}
