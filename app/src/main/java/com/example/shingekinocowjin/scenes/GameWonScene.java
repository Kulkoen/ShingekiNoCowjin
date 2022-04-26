package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.Player;
import com.example.shingekinocowjin.scenes.SceneMethods;
import com.example.shingekinocowjin.ui.MyButton;

public class GameWonScene implements SceneMethods {
    private Bitmap image;
    private MyButton menu;
    private MyButton gameOver;
    private Player player = new Player(100, 0, "");
    private Rect display;
    private MyButton stat1;
    private MyButton stat2;
    private MyButton stat3;
    //private string testString = "Test";

    public GameWonScene(Bitmap bmp) {
        image = bmp;
        initButtons();
    }

    public void drawGameWon(Canvas canvas) {

        canvas.drawBitmap(image, null, display, null);
        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(200);

        Paint n = new Paint();
        n.setColor(Color.BLACK);
        n.setTextSize(100);

        canvas.drawText("GAME WON", 500, 200, p);
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
    public void setGameWonDisplay(Rect rectangle) {
        display = rectangle;
    }
}
