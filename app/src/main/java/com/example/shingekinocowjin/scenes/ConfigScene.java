package com.example.shingekinocowjin.scenes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.content.Context;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.MainActivity;
import com.example.shingekinocowjin.ui.MyButton;

public class ConfigScene implements SceneMethods {
    private Bitmap image;
    private Rect display;
    private MyButton easy, medium, hard, start, changeName;
    private int difficulty = 0;// 1 = easy, 2 = medium, 3 = hard
    private boolean nameChosen = false;

    public ConfigScene(Bitmap bmp) {
        image = bmp;
        initButtons();
    }

    private void initButtons() {
        easy = new MyButton("EASY", 900, 150, 1300, 400);
        medium = new MyButton("MEDIUM", 900, 450, 1300, 700);
        hard = new MyButton("HARD", 900, 750, 1300, 1000);
        start = new MyButton("START", 1800, 800, 2000, 900);
        changeName = new MyButton("Change Name", 75, 50, 625, 200);
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
        changeName.drawButton(canvas);
    }

    @Override
    public void touched(int x, int y, MotionEvent event) {

        if (easy.getBounds().contains(x, y)) {
            easy.setBodyColor(Color.parseColor("#FFED5F"));

            easy.setPressed(true);
            medium.setPressed(false);
            hard.setPressed(false);
            difficulty = 1;
        } else if (medium.getBounds().contains(x, y)) {

            medium.setBodyColor(Color.parseColor("#ff8b3d"));

            easy.setPressed(false);
            medium.setPressed(true);
            hard.setPressed(false);
            difficulty = 2;
        }else if (hard.getBounds().contains(x, y)) {

            hard.setBodyColor(Color.parseColor("#dc143c"));

            easy.setPressed(false);
            medium.setPressed(false);
            hard.setPressed(true);
            difficulty = 3;
        }
        if(start.getBounds().contains(x, y) && difficulty != 0){
            GameState.SetGameState(GameState.PLAYING);
        }
        if(changeName.getBounds().contains(x,y)) {
            changeName.setPressed(true);
            changeName.setText("COWMANDER");
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
