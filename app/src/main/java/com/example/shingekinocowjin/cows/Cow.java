package com.example.shingekinocowjin.cows;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cow {
    private int x, y, left, top, bottom, right;
    private int cowBodyColor = Color.BLACK;
    private int ID;
    private int towerType = 0;//0 = nothing, 1 = basic, 2 = mage, 3 = cannon, 4 = CC

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
        switch(towerType){
            case 0:
                cowBodyColor = Color.BLUE;
                break;
            case 1:
                cowBodyColor = Color.GREEN;
                break;
            case 2:
                cowBodyColor = Color.RED;
                break;
            case 3:
                cowBodyColor = Color.WHITE;
                break;
            default:
                break;
        }
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

    public int getTowerType(){
        return towerType;
    }

}
