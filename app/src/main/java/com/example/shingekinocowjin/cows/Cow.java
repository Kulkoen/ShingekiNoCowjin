package com.example.shingekinocowjin.cows;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cow {
    private int x, y, left, top, bottom, right;
    private int cowBodyColor = Color.BLACK;
    private int ID, towerType;

    public Cow(int x, int y, int ID, int towerType) {
        this.ID = ID;
        this.towerType = towerType;
        left = x - 50;
        top = y - 50;
        bottom = y + 50;
        right = x + 50;
    }

    public void drawCow(Canvas canvas) {

        drawCowBody(canvas);
        drawCowOutline(canvas);
    }

    public void drawCowBody(Canvas canvas) {
        Paint cowBody = new Paint();
        cowBody.setColor(cowBodyColor);
        canvas.drawRect(left, top, right, bottom, cowBody);
    }

    public void drawCowOutline(Canvas canvas) {
        Paint cowOutline = new Paint();
        cowOutline.setStrokeWidth(1);
        cowOutline.setColor(Color.BLACK);
        cowOutline.setStyle(Paint.Style.STROKE);
        canvas.drawRect(left, top, right, bottom, cowOutline);
    }
}
