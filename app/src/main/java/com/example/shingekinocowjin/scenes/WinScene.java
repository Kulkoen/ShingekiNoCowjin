package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.ui.MyButton;

public class WinScene implements SceneMethods {
    private Bitmap image;
    private MyButton menu;
    private MyButton win;
    private Rect display;

    public WinScene(Bitmap bmp) {
        image = bmp;
        initButtons();
    }

    public void drawWin(Canvas canvas) {

        canvas.drawBitmap(image, null, display, null);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(200);
        canvas.drawText("WINNER", 500, 450, p);
        drawButtons(canvas);
    }

    private void initButtons() {

        menu = new MyButton("MENU", 900, 750, 1300, 1000);
        win = new MyButton("WINNER: ", 900, 150, 1300, 400);
    }

    private void drawButtons(Canvas canvas) {
        menu.drawButton(canvas);
        // gameOver.drawButton(canvas);
    }


    @Override
    public void touched(int x, int y, MotionEvent event) {
        if (menu.getBounds().contains(x, y)) {
            menu.setPressed(true);

            GameState.setGameState(GameState.WELCOME);
        }
    }
    public void setWinDisplay(Rect rectangle) {
        display = rectangle;
    }
}
