package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.Player;
import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.managers.CowManager;
import com.example.shingekinocowjin.managers.FarmerManager;
import com.example.shingekinocowjin.ui.MyButton;
import com.example.shingekinocowjin.ui.Shop;

public class PlayScene implements SceneMethods {
    private MyButton startCombat;
    private Bitmap image;
    private Rect display;
    private ConfigScene configScene;
    private Player player;
    private FarmerManager farmerManager;
    private CowManager cowManager;
    private Shop shop;
    private boolean start = false;
    int xPos, yPos;

    private Cow selectedCow;

    public PlayScene(Bitmap bmp) {
        image = bmp;
        configScene = new ConfigScene(bmp);
        player = new Player(100, 5, "");
        farmerManager = new FarmerManager(this);
        cowManager = new CowManager(this);
        shop = new Shop(this);
        initButtons();
    }

    private void initButtons() {
        startCombat = new MyButton("START", 50, 800, 300, 900);
    }

    private void drawButtons(Canvas canvas) {
        startCombat.drawButton(canvas);
    }

    // Draw methods
    public void drawPlay(Canvas canvas) {
        canvas.drawBitmap(image, null, display, null);
        drawTiles(canvas);

        shop.setShopDisplay(display);
        shop.drawShop(canvas);
        drawButtons(canvas);
        if (start) {
            farmerManager.drawEnemies(canvas);
            farmerManager.update();
        }
        cowManager.drawTowers(canvas);
    }

    public void drawTiles(Canvas canvas) {

        Paint gridLines = new Paint();
        gridLines.setStrokeWidth(1);
        gridLines.setColor(Color.BLACK);
        gridLines.setStyle(Paint.Style.STROKE);

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 15; x++) {
                canvas.drawRect(150 * x, 150 * y, (150 * x) + 150, (150 * y) + 150, gridLines);
            }
        }
    }

    public void update() {
        if (farmerManager.getNormalFarmer().getXCoordinate() == 2001
            || (farmerManager.getFasterFarmer().getXCoordinate() == 2000)
            || (farmerManager.getFastestFarmer().getXCoordinate() == 2000)) {
            player.setMonumentHealth(player.getMonumentHealth() - 10);
        } else if (farmerManager.getNormalFarmer().getXCoordinate() == 2001
                && (farmerManager.getFasterFarmer().getXCoordinate() == 2000)
                && (farmerManager.getFastestFarmer().getXCoordinate() == 2000)) {
            startCombat.setPressed(false);
            farmerManager.resetFarmers();
            start = false;
        }
    }

    @Override
    public void touched(int x, int y, MotionEvent event) {
        if (y >= display.height() / 1.1) {
            shop.touched(x, y, event);
        } else if (startCombat.getBounds().contains(x, y)) {
            startCombat.setBodyColor(Color.parseColor("#66FF00"));
            startCombat.setPressed(true);
            start = true;
        } else {
            if (selectedCow != null) {
                if (isTileGrass(x, y) && (player.getMoney() >= configScene.getCowPrice())) {
                    cowManager.addCow(selectedCow, x, y);
                    player.setMoney(player.getMoney() - configScene.getCowPrice());
                    selectedCow = null;
                }
            }
            xPos = x;
            yPos = y;

        }
    }

    private boolean isTileGrass(int x, int y) {
        boolean one = (((y > 275 - 50) && (y < 400 + 50)) && ((x > 0) && (x < 315 + 50)));
        boolean two = (((y > 275 - 50) && (y < 710 + 50)) && ((x > 190 - 50) && (x < 315 + 50)));
        boolean three = (((y > 585 - 50) && (y < 710 + 50)) && ((x > 190 - 50) && (x < 650 + 50)));
        boolean four = (((y > 0) && (y < 710 + 50)) && ((x > 500 - 50) && (x < 650 + 50)));
        boolean five = (((y > 0) && (y < 170 + 50)) && ((x > 500 - 50) && (x < 975 + 50)));
        boolean six = (((y > 0) && (y < 930 + 50)) && ((x > 825 - 50) && (x < 975 + 50)));
        boolean seven = (((y > 790 - 50) && (y < 930 + 50)) && ((x > 825 - 50) && (x < 1350 + 50)));
        boolean eight = (((y > 375 - 50) && (y < 930 + 50)) && ((x > 1200 - 50) && (x < 1350 + 50)));
        boolean nine = (((y > 375 - 50) && (y < 485 + 50)) && ((x > 1200 - 50) && (x < 1860 + 50)));
        boolean ten = (((y > 375 - 50) && (y < 710 + 50)) && ((x > 1720 - 50) && (x < 1860 + 50)));
        boolean eleven = (((y > 590 - 50) && (y < 710 + 50)) && ((x > 1720 - 50) && (x < 2200 + 50)));

        if (one || two || three || four || five || six || seven || eight || nine || ten || eleven) {
            return false;
        }
        return true;
    }

    // Helper Methods
    public void setPlayingDisplay(Rect rectangle) {
        display = rectangle;
    }

    public void setSelectedTower(Cow selectedCow) {
        this.selectedCow = selectedCow;
    }
}
