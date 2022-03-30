package com.example.shingekinocowjin.managers;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.scenes.PlayScene;
import com.example.shingekinocowjin.scenes.SceneMethods;

import java.util.ArrayList;

public class CowManager implements SceneMethods {
    private PlayScene playScene;
    private Cow cow;
    private Boolean beingPlaced = false;

    public CowManager(PlayScene playScene){
        this.playScene = playScene;
    }

    public void drawTowers(Canvas canvas){

    }


    @Override
    public void touched(int x, int y, MotionEvent event) {

    }
}
