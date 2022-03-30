package com.example.shingekinocowjin.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

import com.example.shingekinocowjin.cows.Cow;
import com.example.shingekinocowjin.scenes.PlayScene;
import com.example.shingekinocowjin.scenes.SceneMethods;

public class Shop implements SceneMethods {
    private final PlayScene playScene;
    private Rect display;
    private MyButton[] cowTower;
    private String[] buttonNames = {"Basic Cow", "Mage Cow", "Cannon Cow"};
    private Cow selectedCow;


    public Shop(PlayScene playScene) {
        this.playScene = playScene;
        initButtons();
    }

    public void drawShop(Canvas canvas){
        Paint barBody = new Paint();
        barBody.setColor(Color.rgb(165,42,42));
        canvas.drawRect(0,display.height()/(float)1.1,display.width(), display.height(),barBody);
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

        cowTower = new MyButton[3];

        int left = 100;
        int top = 1000;
        int right = 350;
        int bottom = 1050;

        for(int i = 0; i < cowTower.length; i++){
            cowTower[i] = new MyButton(buttonNames[i],left+(3*i*left),top,right+(3*i*left),bottom);
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
