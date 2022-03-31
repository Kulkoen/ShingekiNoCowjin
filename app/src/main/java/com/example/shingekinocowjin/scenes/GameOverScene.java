package com.example.shingekinocowjin.scenes;
import static com.example.shingekinocowjin.GameState.*;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.Game;
import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.ui.MyButton;

public class GameOverScene implements SceneMethods {
    private Bitmap image;
    private MyButton menu, gameOver;
    private Rect display;

    public GameOverScene(Bitmap bmp) {
        image = bmp;
        initButtons();
    }

    public void drawGameOver(Canvas canvas) {

        canvas.drawBitmap(image, null, display, null);
        drawButtons(canvas);
    }


    private void initButtons() {

        menu = new MyButton("MENU", 900, 750, 1300, 1000);
        gameOver = new MyButton("GAME OVER: ", 900, 150, 1300, 400);
    }

    private void drawButtons(Canvas canvas) {
        menu.drawButton(canvas);
        gameOver.drawButton(canvas);
    }


    @Override
    public void touched(int x, int y, MotionEvent event) {
        if (menu.getBounds().contains(x, y)) {
            menu.setPressed(true);
            GameState.SetGameState(GameState.WELCOME);
        }


    }

    public void setGameOverDisplay(Rect rectangle) {
        display = rectangle;
    }
}
