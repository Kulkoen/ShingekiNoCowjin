package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.Player;
import com.example.shingekinocowjin.ui.MyButton;

public class GameOverScene implements SceneMethods {
    private Bitmap image;
    private MyButton menu;
    private MyButton gameOver;
    private Player player = new Player(100, 0, "");
    private Rect display;

    public GameOverScene(Bitmap bmp) {
        image = bmp;
        initButtons();
    }

    public void drawGameOver(Canvas canvas) {

        canvas.drawBitmap(image, null, display, null);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(200);

        Paint n = new Paint();
        n.setColor(Color.BLACK);
        n.setTextSize(100);

        canvas.drawText("GAME OVER", 500, 200, p);
        canvas.drawText("Farmers Killed: " + player.getFarmersKilled(), 500, 400, n);
        canvas.drawText("Number of Units: " + player.getUnitsBought(), 500, 500, n);
        canvas.drawText("Upgrades Purchases: " + player.getUpgradesBought(), 500, 600, n);
        drawButtons(canvas);
    }

    private void initButtons() {

        menu = new MyButton("MENU", 900, 750, 1300, 1000);
    }

    private void drawButtons(Canvas canvas) {
        menu.drawButton(canvas);
        // gameOver.drawButton(canvas);
    }


    @Override
    public void touched(int x, int y, MotionEvent event) {
        ConfigScene configScene = new ConfigScene(image);
        if (menu.getBounds().contains(x, y)) {
            menu.setPressed(true);
            player.setFarmersKilled(0);
            player.setUpgradesBought(0);
            player.setUnitsBought(0);
            configScene.setChangeName("Change Name");
            GameState.setGameState(GameState.WELCOME);
        }

    }
    public void setGameOverDisplay(Rect rectangle) {
        display = rectangle;
    }
}
