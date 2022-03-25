package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.inputs.TouchInput;

public class WelcomeScreen implements SceneMethods {
    private Bitmap image;

    public WelcomeScreen(Bitmap bmp) {
        image = bmp;
    }

    public void drawWelcome(Canvas canvas) {

        canvas.drawBitmap(image, 0, 0, null);
    }

    @Override
    public void touched(int x, int y) {
        GameState.SetGameState(GameState.CONFIG);
    }
}


