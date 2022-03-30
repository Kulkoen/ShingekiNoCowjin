package com.example.shingekinocowjin.scenes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.managers.CowManager;
import com.example.shingekinocowjin.managers.FarmerManager;
import com.example.shingekinocowjin.ui.MyButton;
import com.example.shingekinocowjin.ui.Shop;

public class PlayScene implements SceneMethods{
    private MyButton startCombat;
    private Bitmap image;
    private Rect display;
    private FarmerManager farmerManager;
    private CowManager cowManager;
    private Shop shop;
    int xPos, yPos;

private Cow selectedCow;

    public PlayScene(Bitmap bmp){
        image = bmp;
        farmerManager = new FarmerManager(this);
        cowManager = new CowManager(this);
        shop = new Shop(this);
        initButtons();
    }

    private void initButtons() {

    }

    //Draw methods
    public void drawPlay(Canvas canvas) {
        canvas.drawBitmap(image, null,display, null);
        drawTiles(canvas);
        farmerManager.drawEnemies(canvas);

        shop.setShopDisplay(display);
        shop.drawShop(canvas);
        cowManager.drawTowers(canvas);
//        drawSelectedCow(canvas,xPos,yPos);
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

    @Override
    public void touched(int x, int y, MotionEvent event) {
        if(y >= display.height()/1.1) {
            shop.touched(x, y, event);
        } else {
            if(selectedCow != null){
                if(isTileGrass(x,y)){
                    cowManager.addCow(selectedCow,x,y);
                    selectedCow = null;
                }
            }
            xPos = x;
            yPos = y;

        }
    }

    private boolean isTileGrass(int x, int y) {
        if((x < 240
                || (y >= 650 && x < 575))
                || (y <= 100 && x < 905)
                || (y >= 860 && x < 1300)
                || (y >= 425 && y <= 430
                && x >= 1300 && x < 1800)
                || (y > 650 && x>= 1800)){
            return false;
        }
        return true;
    }

    //Helper Methods
    public void setPlayingDisplay(Rect rectangle){
        display = rectangle;
    }

    public void setSelectedTower(Cow selectedCow) {
        this.selectedCow = selectedCow;
    }
}
