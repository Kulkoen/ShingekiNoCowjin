package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintSet;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.ui.MyButton;
import com.example.shingekinocowjin.GameScreen;

public class ConfigScene implements SceneMethods {
    private Bitmap image;
    private Rect display;
    private MyButton easy, medium, hard, start;
    private int difficulty = 0;// 1 = easy, 2 = medium, 3 = hard
    private boolean nameChosen = false;

    public ConfigScene(Bitmap bmp) {
        image = bmp;
        initButtons();
    }

    private void initButtons() {
        easy = new MyButton("EASY", 1000, 200, 1200, 300);
        medium = new MyButton("MEDIUM", 1000, 500, 1200, 600);
        hard = new MyButton("HARD", 1000, 800, 1200, 900);
        start = new MyButton("START", 1800, 800, 2000, 900);
    }

    public void drawConfig(Canvas canvas) {

        canvas.drawBitmap(image, null,display, null);
        drawButtons(canvas);
    }

    private void drawButtons(Canvas canvas) {
        easy.drawButton(canvas);
        medium.drawButton(canvas);
        hard.drawButton(canvas);
        start.drawButton(canvas);
    }

    @Override
    public void touched(int x, int y, MotionEvent event) {

        if (easy.getBounds().contains(x, y)) {
            easy.setBodyPaint(Color.GREEN);
            easy.setPressed(true);
            medium.setPressed(false);
            hard.setPressed(false);
            difficulty = 1;
        } else if (medium.getBounds().contains(x, y)) {
            medium.setBodyPaint(Color.YELLOW);
            easy.setPressed(false);
            medium.setPressed(true);
            hard.setPressed(false);
            difficulty = 2;
        }else if (hard.getBounds().contains(x, y)) {
            hard.setBodyPaint(Color.RED);
            easy.setPressed(false);
            medium.setPressed(false);
            hard.setPressed(true);
            difficulty = 3;
        }

        if(start.getBounds().contains(x, y) && difficulty != 0){
            GameState.SetGameState(GameState.PLAYING);
        }
    }

    //Helper Methods
    public int getDifficulty(){
        return difficulty;
    }

    public boolean isNameChosen(){
        return nameChosen;
    }

    public void setConfigDisplay(Rect rectangle){
        display = rectangle;
    }

}
