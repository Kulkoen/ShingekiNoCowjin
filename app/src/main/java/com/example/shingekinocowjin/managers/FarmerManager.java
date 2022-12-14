package com.example.shingekinocowjin.managers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.shingekinocowjin.farmers.Farmer;
import com.example.shingekinocowjin.scenes.PlayScene;

import java.util.ArrayList;

public class FarmerManager {
    private PlayScene playScene;
    private ArrayList<Farmer> farmers;
    private Farmer normalFarmer;
    private Farmer fasterFarmer;
    private Farmer fastestFarmer;
    private Farmer bossFarmer;
    private Bitmap pickaxe;
    private Bitmap basic;
    private Bitmap tractor;
    private Bitmap hat;
    private Bitmap[] bit = new Bitmap[4];
    private int hpBarWidth = 45;

    public FarmerManager(PlayScene playScene, Bitmap pickaxe, Bitmap basic, Bitmap tractor, Bitmap hat) {
        this.playScene = playScene;
        bit[0] = pickaxe;
        bit[1] = basic;
        bit[2] = tractor;
        bit[3] = hat;
        normalFarmer = new Farmer(0, 310, 0, 0, bit[0]);
        // farmers.add(normalFarmer);
        fasterFarmer = new Farmer(0, 310, 1, 1, bit[1]);
        // farmers.add(fasterFarmer);
        fastestFarmer = new Farmer(0, 310, 2, 2, bit[3]);
        // farmers.add(fastestFarmer);
        bossFarmer = new Farmer(0, 310, 3, 3, bit[2]);
    }

    public void drawEnemies(Canvas canvas) {

        drawFarmerType(normalFarmer, canvas);
        drawHealthBar(normalFarmer, canvas);

        fasterFarmer.setFarmerBody(Color.BLUE);
        drawFarmerType(fasterFarmer, canvas);
        drawHealthBar(fasterFarmer, canvas);

        fastestFarmer.setFarmerBody(Color.YELLOW);
        drawFarmerType(fastestFarmer, canvas);
        drawHealthBar(fastestFarmer, canvas);
    }

    private void drawHealthBar(Farmer farmer, Canvas canvas) {
        Paint healthBar = new Paint();
        healthBar.setColor(Color.RED);
        canvas.drawRect(farmer.getX() - getNewBarWidth(farmer) + 10, farmer.getY() - 120,
                farmer.getX() + getNewBarWidth(farmer) + 10, farmer.getY() - 110, healthBar);
    }

    private int getNewBarWidth(Farmer farmer) {
        return (int) (hpBarWidth * farmer.getHealthBarFloat());
    }

    public void drawFarmerType(Farmer f, Canvas canvas) {
        f.drawFarmer(canvas);
    }

    public void drawBoss(Canvas canvas){
        bossFarmer.setFarmerBody(Color.BLACK);
        drawFarmerType(bossFarmer, canvas);
        drawHealthBar(bossFarmer, canvas);
    }

    public void moveFarmer(Farmer farmer, float speed) {
        if ((farmer.getX() < 240
                || (farmer.getY() >= 650 && farmer.getX() < 575))
                || (farmer.getY() <= 100 && farmer.getX() < 905)
                || (farmer.getY() >= 860 && farmer.getX() < 1300)
                || (farmer.getY() >= 425 && farmer.getY() <= 430
                        && farmer.getX() >= 1300 && farmer.getX() < 1800)
                || (farmer.getY() > 650 && farmer.getX() >= 1800)) {
            farmer.move(speed, 0);
        } else if ((farmer.getX() >= 240 && farmer.getX() < 575
                && farmer.getY() < 650)
                || (farmer.getX() >= 905 && farmer.getY() < 860
                        && farmer.getX() < 1300)
                || (farmer.getX() >= 1800 && farmer.getY() < 1000)) {
            farmer.move(0, speed);
        } else {
            farmer.move(0, -speed);
        }
    }

    public void resetFarmers() {
        farmers = new ArrayList<Farmer>();
        normalFarmer = new Farmer(0, 310, 0, 0, bit[0]);
        normalFarmer.setHealth(normalFarmer.getMaxHealth() + 75);
        normalFarmer.setMaxHealth(normalFarmer.getMaxHealth() + 75);
        fasterFarmer = new Farmer(0, 310, 1, 1, bit[1]);
        fastestFarmer.setMaxHealth(fasterFarmer.getMaxHealth() + 75);
        fasterFarmer.setHealth(fasterFarmer.getMaxHealth() + 75);
        fastestFarmer = new Farmer(0, 310, 2, 2, bit[3]);
        fastestFarmer.setMaxHealth(fastestFarmer.getMaxHealth() + 75);
        fastestFarmer.setHealth(fastestFarmer.getMaxHealth() + 75);
        playScene.setWave(playScene.getWave()+1);
    }

    public void resetBoss(){
        bossFarmer = new Farmer(0, 310, 3, 3, bit[2]);
        bossFarmer.setMaxHealth(20000);
        bossFarmer.setHealth(20000);

    }

    public void update() {
        moveFarmer(normalFarmer, (float) 3);
        moveFarmer(fasterFarmer, (float) 4);
        moveFarmer(fastestFarmer, (float) 5);
    }

    public void bossUpdate(){
        moveFarmer(bossFarmer, (float) 4);
    }

    public Farmer getNormalFarmer() {
        return normalFarmer;
    }

    public Farmer getFasterFarmer() {
        return fasterFarmer;
    }

    public Farmer getFastestFarmer() {
        return fastestFarmer;
    }

    public Farmer getBossFarmer() {
        return bossFarmer;
    }

    public ArrayList<Farmer> getFarmers() {
        return farmers;
    }
}
