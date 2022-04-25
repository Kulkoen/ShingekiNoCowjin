package com.example.shingekinocowjin.scenes;

import static java.lang.System.currentTimeMillis;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.Player;
import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.farmers.Farmer;
import com.example.shingekinocowjin.managers.CowManager;
import com.example.shingekinocowjin.managers.FarmerManager;
import com.example.shingekinocowjin.ui.MyButton;
import com.example.shingekinocowjin.ui.Shop;

public class PlayScene implements SceneMethods {
    private MyButton startCombat;
    private MyButton upgradeCows;
    private Bitmap image;
    private Bitmap mageCow;
    private Bitmap cCCow;
    private Bitmap basicCow;
    private Bitmap cannonCow;
    private Rect display;
    private ConfigScene configScene;
    private Player player;
    private FarmerManager farmerManager;
    private CowManager cowManager;
    private Shop shop;
    private int wave;
    private boolean start = false;
    Canvas can;

    private Cow selectedCow;

    public PlayScene(Bitmap bmp, Bitmap[] bit) {
        image = bmp;
        this.basicCow = bit[0];
        this.cannonCow = bit[1];
        this.mageCow = bit[2];
        this.cCCow = bit[3];
        configScene = new ConfigScene(bmp);
        player = new Player(100, 5, "");
        farmerManager = new FarmerManager(this);
        cowManager = new CowManager(this, basicCow, cannonCow, mageCow, cCCow);
        shop = new Shop(this, bit);
        initButtons();
    }

    private void initButtons() {
        startCombat = new MyButton("START", 50, 800,
                300, 900);
        upgradeCows = new MyButton("UPGRADE", 350, 800,
                700, 900);
    }

    private void drawButtons(Canvas canvas) {
        startCombat.drawButton(canvas);
        upgradeCows.drawButton(canvas);
    }

    // Draw methods
    public void drawPlay(Canvas canvas) {
        canvas.drawBitmap(image, null, display, null);
        //drawTiles(canvas);

        shop.setShopDisplay(display);
        shop.drawShop(canvas);
        drawWaves(canvas);
        drawButtons(canvas);
        if (start) {
            if(wave >= 5){
                farmerManager.drawBoss(canvas);
                farmerManager.bossUpdate();
            }else {
                farmerManager.drawEnemies(canvas);
                farmerManager.update();
            }
        }
        cowManager.drawTowers(canvas);
        can = canvas;
    }

    /*public void drawTiles(Canvas canvas) {

        Paint gridLines = new Paint();
        gridLines.setStrokeWidth(1);
        gridLines.setColor(Color.BLACK);
        gridLines.setStyle(Paint.Style.STROKE);

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 15; x++) {
                canvas.drawRect(150 * x, 150 * y, (150 * x) + 150,
                        (150 * y) + 150, gridLines);
            }
        }
    }*/

    public void update() {
        if (farmerManager.getNormalFarmer().getX() == 2001
                || (farmerManager.getFasterFarmer().getX() == 2000)
                || (farmerManager.getFastestFarmer().getX() == 2000)) {
            player.setMonumentHealth(player.getMonumentHealth() - 10);
            if (player.getMonumentHealth() <= 0) {
                GameState.setGameState(GameState.GAMEOVER);
            }
        }
        if(farmerManager.getBossFarmer().getX() >= 2000){
            farmerManager.resetBoss();
            player.setMonumentHealth(player.getMonumentHealth() - 90);
            startCombat.setPressed(false);
            start = false;
            if (player.getMonumentHealth() <= 0) {
                GameState.setGameState(GameState.GAMEOVER);
            }
        }
        if (farmerManager.getNormalFarmer().getX() >= 2001
                && (farmerManager.getFasterFarmer().getX() >= 2000)
                && (farmerManager.getFastestFarmer().getX() >= 2000)) {
            startCombat.setPressed(false);
            farmerManager.resetFarmers();
            start = false;
        }
        for (int i = 0; i < cowManager.getCows().size(); i++) {
            if (isInRange(cowManager.getCows().get(i), farmerManager.getNormalFarmer())) {
                if (currentTimeMillis() % 5 == 0) {
                    farmerManager.getNormalFarmer().setHealth(farmerManager.getNormalFarmer()
                            .getHealth() - cowManager.getCows().get(i).getTowerDamage());
                }
            }
            if (isInRange(cowManager.getCows().get(i), farmerManager.getFasterFarmer())) {
                if (currentTimeMillis() % 5 == 0) {
                    farmerManager.getFasterFarmer().setHealth(farmerManager.getFasterFarmer()
                        .getHealth() - cowManager.getCows().get(i).getTowerDamage());
                }
            }
            if (isInRange(cowManager.getCows().get(i), farmerManager.getFastestFarmer())) {
                if (currentTimeMillis() % 5 == 0) {
                    farmerManager.getFastestFarmer().setHealth(farmerManager
                        .getFastestFarmer().getHealth() - cowManager.getCows()
                        .get(i).getTowerDamage());
                }
            }
            if (isInRange(cowManager.getCows().get(i), farmerManager.getBossFarmer())) {
                if (currentTimeMillis() % 5 == 0) {
                    farmerManager.getBossFarmer().setHealth(farmerManager
                            .getBossFarmer().getHealth() - cowManager.getCows()
                            .get(i).getTowerDamage());
                }
            }
        }
        if (farmerManager.getNormalFarmer().getHealth() <= 0) {
            farmerManager.getNormalFarmer().move(2500, 0);
            farmerManager.getNormalFarmer().setHealth(1);
            player.setMoney(player.getMoney() + 10);

        }
        if (farmerManager.getFasterFarmer().getHealth() <= 0) {
            farmerManager.getFasterFarmer().move(2500, 0);
            farmerManager.getFasterFarmer().setHealth(1);
            player.setMoney(player.getMoney() + 15);
        }
        if (farmerManager.getFastestFarmer().getHealth() <= 0) {
            farmerManager.getFastestFarmer().move(2500, 0);
            farmerManager.getFastestFarmer().setHealth(1);
            player.setMoney(player.getMoney() + 20);
        }
        if(farmerManager.getBossFarmer().getHealth() <= 0){
            GameState.setGameState(GameState.GAMEWON);
        }
    }

    @Override
    public void touched(int x, int y, MotionEvent event) {
        if (y >= display.height() / 1.1) {
            shop.touched(x, y, event);
        } else if (startCombat.getBounds().contains(x, y)) {
            startCombat.setBodyColor(Color.parseColor("#66FF00"));
            startCombat.setPressed(true);
            farmerManager.resetBoss();
            start = true;
        } else {
            if (selectedCow != null) {
                if (isTileGrass(x, y) && (player.getMoney() >= configScene.getCowPrice())) {
                    cowManager.addCow(selectedCow, x, y);
                    player.setMoney(player.getMoney() - configScene.getCowPrice());
                    selectedCow = null;
                    shop.getClickedButton().setBodyColor(Color.parseColor("#FDA4BA"));
                }
            }
        }
        if (upgradeCows.getBounds().contains(x, y) && player.getMoney() >= 100) {
            for (Cow c : cowManager.getCows()) {
                c.setCowRange(c.getCowRange() + 50);
                c.setTowerDamage(c.getTowerDamage() + 50);
                c.drawCowRange(can);
            }
            player.setMoney(player.getMoney() - 100);
            upgradeCows.setBodyColor(Color.parseColor("#FDA4BA"));
        }
        if (player.getMoney() >= 40) {
            upgradeCows.setBodyColor(Color.parseColor("#ebdff2"));
            upgradeCows.drawButton(can);
        }
    }

    public void drawWaves(Canvas canvas){
        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(50);
        canvas.drawText(wave+"",100,100,textPaint);
    }
    private boolean isInRange(Cow cow, Farmer farmer) {
        double range = getHypoDistance(cow.getX(), cow.getY(), farmer.getX(), farmer.getY());
        return range < (cow.getCowRange() + 50);
    }

    private boolean isTileGrass(int x, int y) {
        boolean one = (((y > 275 - 50) && (y < 400 + 50)) && ((x > 0) && (x < 315 + 50)));
        boolean two = (((y > 275 - 50) && (y < 710 + 50)) && ((x > 190 - 50) && (x < 315 + 50)));
        boolean three = (((y > 585 - 50) && (y < 710 + 50)) && ((x > 190 - 50) && (x < 650 + 50)));
        boolean four = (((y > 0) && (y < 710 + 50)) && ((x > 500 - 50) && (x < 650 + 50)));
        boolean five = (((y > 0) && (y < 170 + 50)) && ((x > 500 - 50) && (x < 975 + 50)));
        boolean six = (((y > 0) && (y < 930 + 50)) && ((x > 825 - 50) && (x < 975 + 50)));
        boolean seven = (((y > 790 - 50) && (y < 930 + 50)) && ((x > 825 - 50) && (x < 1350 + 50)));
        boolean eight = (((y > 375 - 50) && (y < 930 + 50)) && ((x > 1200 - 50)
                && (x < 1350 + 50)));
        boolean nine = (((y > 375 - 50) && (y < 485 + 50)) && ((x > 1200 - 50) && (x < 1860 + 50)));
        boolean ten = (((y > 375 - 50) && (y < 710 + 50)) && ((x > 1720 - 50) && (x < 1860 + 50)));
        boolean eleven = (((y > 590 - 50) && (y < 710 + 50)) && ((x > 1720 - 50)
                && (x < 2200 + 50)));

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

    public Bitmap getBasicCow() {
        return basicCow;
    }

    public Bitmap getMageCow() {
        return mageCow;
    }

    public Bitmap getCCCow() {
        return cCCow;
    }

    public Bitmap getCannonCow() {
        return cannonCow;
    }

    public static double getHypoDistance(int x1, int y1, float x2, float y2) {
        double xDiff = (double) Math.abs((x1 - (int) x2));
        double yDiff = (double) Math.abs((y1 - (int) y2));

        return (double) Math.hypot(xDiff, yDiff);
    }

    public void setWave(int wave) {
        this.wave = wave;
    }
    public int getWave() {
        return wave;
    }
}
