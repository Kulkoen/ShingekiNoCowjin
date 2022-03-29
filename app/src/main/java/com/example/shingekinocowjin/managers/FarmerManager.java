package com.example.shingekinocowjin.managers;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.shingekinocowjin.farmers.Farmer;
import com.example.shingekinocowjin.scenes.PlayScene;

public class FarmerManager {
    private PlayScene playScene;
    private Farmer normalFarmer;
    private Farmer fasterFarmer;
    private Farmer fastestFarmer;

    public FarmerManager(PlayScene playScene){
        this.playScene = playScene;
        normalFarmer = new Farmer(75,300,0,0);
        fasterFarmer = new Farmer(50,300,0,0);
        fastestFarmer = new Farmer(10,300,0,0);
    }
    public void drawEnemeies(Canvas canvas){
        drawFarmerType(normalFarmer,canvas);

        fasterFarmer.setFarmerBody(Color.BLUE);
        drawFarmerType(fasterFarmer,canvas);

        fastestFarmer.setFarmerBody(Color.YELLOW);
        drawFarmerType(fastestFarmer,canvas);
    }
    public void drawFarmerType(Farmer f, Canvas canvas){
        f.drawFarmer(canvas);
    }

    public void update(){
        normalFarmer.move((float).5,0);
        fasterFarmer.move((float)1,(float)0);
        fastestFarmer.move((float)2,(float)0);
    }
}
