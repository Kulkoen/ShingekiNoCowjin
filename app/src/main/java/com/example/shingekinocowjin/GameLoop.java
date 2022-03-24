package com.example.shingekinocowjin;

import android.graphics.Canvas;
import android.view.Surface;
import android.view.SurfaceHolder;

import java.util.Observer;

public class GameLoop extends Thread {
    private boolean isRunning = false;
    private SurfaceHolder surfaceHolder;
    private GameScreen gameScreen;

    public GameLoop(GameScreen gameScreen, SurfaceHolder surfaceHolder) {
        this.gameScreen = gameScreen
        this.surfaceHolder = surfaceHolder;
    }

    public double getAverageUPS() {
        return 0;
    }

    public double getAverageFPS() {
        return 0;
    }

    public void startLoop() {
        isRunning = true;
        start();
        //Game Loop
        Canvas canvas;
        while (isRunning){
            //Try to update and render game
            try()
            canvas = surfaceHolder.lockCanvas();
            gameScreen.update();
            gameScreen.draw(canvas);
            //Pause game Loop to not exceed target UPS
            //Skip frames to keep with target UPS
            //Calculate avg UPS and FPS
        }
    }

}
