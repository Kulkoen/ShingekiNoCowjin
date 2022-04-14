package com.example.shingekinocowjin.cows;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Cow {
    private int x, y, left, top, bottom, right;
    private int cowBodyColor = Color.BLACK;
    private int towerDamage;
    private int towerRange;
    private int ID;

    private Bitmap image;
    private Bitmap mageCow;
    private Bitmap cCCow;
    private Bitmap basicCow;
    private Bitmap cannonCow;
    private int towerType = 0;// 0 = basic, 1 = mage, 2 = cannon, 3 = cc

    public Cow(int x, int y, int ID, int towerType, Bitmap basicCow,
               Bitmap cannonCow, Bitmap mageCow, Bitmap cCCow) {
        this.ID = ID;
        this.towerType = towerType;
        this.basicCow = basicCow;
        this.cannonCow = cannonCow;
        this.mageCow = mageCow;
        this.cCCow = cCCow;
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
                //cowBodyColor = Color.BLUE;
                image = basicCow;
                towerDamage = 1;
                towerRange = 200;
                break;
            case 1:
                //cowBodyColor = Color.GREEN;
                image = mageCow;
                towerDamage = 5;
                towerRange = 200;
                break;
            case 2:
                //cowBodyColor = Color.RED;
                towerDamage = 5;
                towerRange = 200;
                image = cannonCow;
                break;
            case 3:
                //cowBodyColor = Color.WHITE;
                towerDamage = 1;
                towerRange = 200;
                image = cCCow;
                break;
            default:
                break;
        }
        //cowBody.setColor(cowBodyColor);
        //canvas.drawRect(left, top, right, bottom, cowBody);
        canvas.drawBitmap(image, left - 50, top - 50, null);
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
