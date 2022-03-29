package com.example.shingekinocowjin.managers;

import android.graphics.Canvas;

import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.scenes.PlayScene;

public class CowManager {
    private PlayScene playScene;
    private Cow basicCow;

    public CowManager(PlayScene playScene){
        this.playScene = playScene;
        basicCow = new Cow(1000, 600, 700, 1100);
    }

    public void drawTowers(Canvas canvas){
        drawCowType(basicCow,canvas);

    }

    public void drawCowType(Cow c,Canvas canvas){
        c.drawCow(canvas);
    }
}
