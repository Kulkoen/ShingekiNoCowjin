package com.example.shingekinocowjin.farmers;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Farmer {
    private float x, y;
    private int health;
    private int ID;
    private int enemyType;
    private Rect bounds; // for hitbox
    int farmerBodyColor = Color.RED;

    public Farmer(float x, float y, int ID, int enemyType) {
        this.x = x;
        this.y = y;
        this.ID = ID;
        this.enemyType = enemyType;
        switch (enemyType) {
            case 0:
                health = 100;
                break;
            case 1:
                health = 80;
                break;
            case 2:
                health = 50;
                break;
        }
    }

    public void drawFarmer(Canvas canvas) {
        drawFarmerBody(canvas);
        drawFarmerOutline(canvas);
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void drawFarmerBody(Canvas canvas) {
        Paint farmerBody = new Paint();
        farmerBody.setColor(farmerBodyColor);
        canvas.drawCircle(x, y, 35, farmerBody);
    }

    public void drawFarmerOutline(Canvas canvas) {
        Paint farmerOutline = new Paint();
        farmerOutline.setStrokeWidth(1);
        farmerOutline.setColor(Color.BLACK);
        farmerOutline.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(x, y, 35, farmerOutline);
    }

    public float getXCoordinate() {
        return x;
    }

    public float getYCoordinate() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public void setFarmerBody(int newColor) {
        farmerBodyColor = newColor;
    }
}
