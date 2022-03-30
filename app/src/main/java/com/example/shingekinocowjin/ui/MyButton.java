package com.example.shingekinocowjin.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class MyButton {
    private int left, top, right, bottom;
    private String text;
    private Rect bounds;
    int bodyColor = Color.BLUE;
    private boolean pressed;

    public MyButton(String text, int left, int top, int right, int bottom) {
        this.text = text;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        initBounds();
    }

    private void initBounds() {
        this.bounds = new Rect(left, top, right, bottom);
    }

    public void drawButton(Canvas canvas) {
        // Body
        drawBody(canvas);
        // Border
        drawBorder(canvas);
        // Text
        drawButtonText(canvas);

    }

    private void drawButtonText(Canvas canvas) {
        Paint textPaint = new Paint();
        int textColor = Color.BLACK;
        textPaint.setColor(textColor);
        textPaint.setTextSize(50);
        Rect textBounds = new Rect();
        textPaint.getTextBounds(text, 0, text.length(), textBounds);
        int height = textBounds.height();
        int width = textBounds.width();
        canvas.drawText(text, ((right + left) - width) / 2, ((bottom + top) + height) / 2, textPaint);
    }

    private void drawBorder(Canvas canvas) {
        Paint borderPaint = new Paint();
        borderPaint.setStrokeWidth(1);
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(left, top, right, bottom, borderPaint);
    }

    private void drawBody(Canvas canvas) {
        Paint bodyPaint = new Paint();
        if(pressed){
            bodyPaint.setColor(bodyColor);
            canvas.drawRect(left, top, right, bottom, bodyPaint);
        } else {
            bodyPaint.setColor(Color.GRAY);
            canvas.drawRect(left, top, right, bottom, bodyPaint);
        }
    }

    public Rect getBounds() {
        return bounds;
    }

    public void setBodyColor(int color) {
        bodyColor = color;
    };

    public void setPressed(boolean pressed){
        this.pressed = pressed;
    }

}
