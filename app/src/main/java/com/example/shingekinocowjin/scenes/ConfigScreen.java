package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.ui.MyButton;


public class ConfigScreen implements SceneMethods{
    private Bitmap image;
    private MyButton easy, medium, hard, start;

    public ConfigScreen(Bitmap bmp) {
        image = bmp;
        initButtons();
    }

    private void initButtons() {
        easy = new MyButton("EASY", 1000, 200, 1200, 300);
    }

    public void drawConfig(Canvas canvas) {
        canvas.drawBitmap(image, 0, 0, null);
        drawButtons(canvas);
    }

    private void drawButtons(Canvas canvas) {
        easy.drawButton(canvas);
    }

    @Override
    public void touched(int x, int y) {
        if(easy.getBounds().contains(x,y)){
            GameState.SetGameState(GameState.PLAYING);
            easy.setBodyPaint(Color.GREEN);
        }
    }
}
