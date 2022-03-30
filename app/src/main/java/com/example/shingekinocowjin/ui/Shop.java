package com.example.shingekinocowjin.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.scenes.ConfigScene;
import com.example.shingekinocowjin.scenes.PlayScene;
import com.example.shingekinocowjin.scenes.SceneMethods;

public class Shop implements SceneMethods {
    private final PlayScene playScene;
    private Rect display;
    private MyButton[] cowTower;
    private String[] buttonNames = {"Basic Cow", "Mage Cow", "Cannon Cow", "CC Cow"};
    private Cow selectedCow;


    public Shop(PlayScene playScene) {
        this.playScene = playScene;
        initButtons();
    }

    public void drawShop(Canvas canvas){
        Paint barBody = new Paint();
        barBody.setColor(Color.parseColor("#fae2e3"));
        Paint borderPaint = new Paint();
        borderPaint.setStrokeWidth(20.5f);
        borderPaint.setColor(Color.BLACK);
        borderPaint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(50, display.height()/(float)1.15,display.width() - 50, display.height(),borderPaint);
        canvas.drawRect(50,display.height()/(float)1.15,display.width() - 50, display.height(),barBody);
        drawTowersInShop(canvas);
    }


    public void drawTowersInShop(Canvas canvas){
        for(MyButton b : cowTower){
            b.drawButton(canvas);
        }

    }

    //Helper
    public void setShopDisplay(Rect rectangle){
        display = rectangle;
    }
    public void initButtons(){

        cowTower = new MyButton[4];

        int left = 550;
        int top = 972;
        int right = 75;
        int bottom = 1055;

        for(int i = 0; i < cowTower.length; i++){
            cowTower[i] = new MyButton(buttonNames[i],left+(1*i*left),top,right+(1*i*left),bottom);
            cowTower[i].setBodyColor(Color.parseColor("#e87c83"));
        }

    }

    @Override
    public void touched(int x, int y, MotionEvent event) {
        for(MyButton b : cowTower){
            if(b.getBounds().contains(x,y)){
                b.setPressed(true);

                selectedCow = new Cow(0,0,0,0);
                playScene.setSelectedTower(selectedCow);
                return;
            } else {
                b.setPressed(true);
            }
        }
    }

}
