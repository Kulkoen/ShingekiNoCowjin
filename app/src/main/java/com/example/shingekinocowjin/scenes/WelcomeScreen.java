package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class WelcomeScreen{
    private Bitmap image;

    public WelcomeScreen(Bitmap bmp) {
        image = bmp;
    }

    public void drawWelcome(Canvas canvas) {
        
        canvas.drawBitmap(image, 0, 0, null);
    }
}


