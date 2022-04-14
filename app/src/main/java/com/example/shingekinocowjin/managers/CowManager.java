package com.example.shingekinocowjin.managers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.scenes.PlayScene;
import com.example.shingekinocowjin.scenes.SceneMethods;

import java.util.ArrayList;

public class CowManager implements SceneMethods {
    private PlayScene playScene;
    private ArrayList<Cow> cows = new ArrayList<>();
    private int cowAmount = 0;
    private Bitmap basicCow;
    private Bitmap cannonCow;
    private Bitmap mageCow;
    private Bitmap cCCow;

    public CowManager(PlayScene playScene, Bitmap basicCow,
                      Bitmap cannonCow, Bitmap mageCow, Bitmap cCCow) {
        this.basicCow = basicCow;
        this.cannonCow = cannonCow;
        this.mageCow = mageCow;
        this.cCCow = cCCow;
    }

    public void drawTowers(Canvas canvas) {
        for (Cow c : cows) {
            c.drawCow(canvas);
        }
    }

    public void addCow(Cow selectedCow, int x, int y) {
        cows.add(new Cow(x, y, cowAmount++, selectedCow.getTowerType(),
                basicCow, cannonCow, mageCow, cCCow));
    }

    public void update() {
    }

    @Override
    public void touched(int x, int y, MotionEvent event) {

    }
    public ArrayList<Cow> getCows() {
        return cows;
    }
}
