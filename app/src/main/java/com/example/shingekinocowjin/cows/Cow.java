package com.example.shingekinocowjin.cows;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cow {
    private int x;
    private int y;
    private int left;
    private int top;
    private int bottom;
    private int right;
    private int cowBodyColor = Color.BLACK;
    private int towerDamage;
    private int towerRange;
    private int id;
    private int towerType = 0; // 0 = basic, 1 = mage, 2 = cannon, 3 = cc

    public Cow(int x, int y, int id, int towerType) {
        this.id = id;
        this.towerType = towerType;
        this.x = x;
        this.y = y;
        left = x - 50;
        top = y - 50;
        bottom = y + 50;
        right = x + 50;
    }

    public void drawCow(Canvas canvas) {
        drawCowBody(canvas);
        drawCowOutline(canvas);
        drawCowRange(canvas);
    }

    public void drawCowBody(Canvas canvas) {
        Paint cowBody = new Paint();
        switch (towerType) {
        case 0:
            cowBodyColor = Color.BLUE;
            towerDamage = 1;
            towerRange = 200;
            break;
        case 1:
            cowBodyColor = Color.GREEN;
            towerDamage = 5;
            towerRange = 200;
            break;
        case 2:
            cowBodyColor = Color.RED;
            towerDamage = 5;
            towerRange = 200;
            break;
        case 3:
            cowBodyColor = Color.WHITE;
            towerDamage = 1;
            towerRange = 200;
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

    public void drawCowRange(Canvas canvas) {
        Paint cowOutline = new Paint();
        cowOutline.setStrokeWidth(1);
        cowOutline.setColor(Color.WHITE);
        cowOutline.setStyle(Paint.Style.STROKE);
        canvas.drawOval(left - (towerRange), top - (towerRange),
                right + (towerRange), bottom + (towerRange), cowOutline);
    }

    public int getTowerType() {
        return towerType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCowRange() {
        return towerRange;
    }

    public int getTowerDamage() {
        return towerDamage;
    }

}
