package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;


public class ConfigScreen{
    private Bitmap image;

    public ConfigScreen(Bitmap bmp) {
        image = bmp;
    }

    public void drawConfig(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);
    }
}
