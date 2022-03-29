package com.example.shingekinocowjin.cows;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cow {
    private int left, top, bottom, right;
    private int cowBodyColor = Color.BLACK;

    public Cow(int left, int top, int bottom, int right){
        this.left = left;
        this.top = top;
        this.bottom = bottom;
        this.right = right;
    }

    public void drawCow(Canvas canvas){

        drawCowBody(canvas);
        drawFarmerOutline(canvas);
    }

    public void drawCowBody(Canvas canvas){
        Paint cowBody = new Paint();
        cowBody.setColor(cowBodyColor);
        canvas.drawRect(left,top,right,bottom,cowBody);
    }
    public void drawFarmerOutline(Canvas canvas){
        Paint cowOutline = new Paint();
        cowOutline.setStrokeWidth(1);
        cowOutline.setColor(Color.BLACK);
        cowOutline.setStyle(Paint.Style.STROKE);
        canvas.drawRect(left,top,right,bottom,cowOutline);
    }

    public void setCowBodyColor(int newColor){
        cowBodyColor = newColor;
    }
}
