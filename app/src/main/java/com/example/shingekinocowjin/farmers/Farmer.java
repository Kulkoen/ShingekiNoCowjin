package com.example.shingekinocowjin.farmers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Farmer {
    private float x;
    private float y;
    private int health;
    private int maxHealth;
    private int id;
    private int enemyType;
    private Rect bounds; // for hitbox
    private Bitmap sprite;
    private int farmerBodyColor = Color.RED;

    public Farmer(float x, float y, int id, int enemyType, Bitmap sprite) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.id = id;
        this.enemyType = enemyType;
        switch (enemyType) {
        case 0:
            health = 500;
            maxHealth = 500;
            break;
        case 1:
            health = 300;
            maxHealth = 300;
            break;
        case 2:
            health = 200;
            maxHealth = 200;
            break;
        case 3:
            health = 30000;
            maxHealth = 30000;
            break;
        default:
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
        //canvas.drawCircle(x, y, 35, farmerBody);
        canvas.drawBitmap(sprite, x - 105, y - 120, null);
    }

    public void drawFarmerOutline(Canvas canvas) {
        Paint farmerOutline = new Paint();
        farmerOutline.setStrokeWidth(1);
        farmerOutline.setColor(Color.BLACK);
        farmerOutline.setStyle(Paint.Style.STROKE);
        //canvas.drawCircle(x, y, 35, farmerOutline);
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int newHealth) {
        health = newHealth;
    }

    public int getMaxHealth() { return maxHealth; }

    public void setFarmerBody(int newColor) {
        farmerBodyColor = newColor;
    }

    public void setMaxHealth(int newMaxHealth) {
        maxHealth = newMaxHealth;
    }

    public float getHealthBarFloat() {
        return health / (float) maxHealth;

    }
}
