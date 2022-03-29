package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.shingekinocowjin.managers.FarmerManager;
import com.example.shingekinocowjin.ui.MyButton;

public class PlayScene {
    private MyButton startCombat;
    private Bitmap image;
    private Rect display;
    private FarmerManager farmerManager;

    public PlayScene(Bitmap bmp){
        image = bmp;
        farmerManager = new FarmerManager(this);
    }


    //Draw methods
    public void drawPlay(Canvas canvas) {
        canvas.drawBitmap(image, null,display, null);
        drawTiles(canvas);
        farmerManager.drawEnemeies(canvas);

    }
    private void drawButtons(Canvas canvas) {
    }

    public void drawTiles(Canvas canvas){

        Paint gridLines = new Paint();
        gridLines.setStrokeWidth(1);
        gridLines.setColor(Color.BLACK);
        gridLines.setStyle(Paint.Style.STROKE);

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 15; x++){
                canvas.drawRect(150*x,150*y,(150*x)+150,(150*y)+150,gridLines);
            }
        }
    }

    public void update(){
        farmerManager.update();
    }

    //Helper Methods
    public void setPlayingDisplay(Rect rectangle){
        display = rectangle;
    }
}
