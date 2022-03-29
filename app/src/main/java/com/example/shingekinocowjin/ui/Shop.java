package com.example.shingekinocowjin.ui;

import static java.security.AccessController.getContext;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.core.content.ContextCompat;

import com.example.shingekinocowjin.R;
import com.example.shingekinocowjin.scenes.PlayScene;

public class Shop {
    private final PlayScene playScene;
    private float left,right,top,bottom;
    private Rect display;

    public Shop(PlayScene playScene) {
        this.playScene = playScene;
    }

    public void drawShop(Canvas canvas){
        Paint barBody = new Paint();
        barBody.setColor(Color.rgb(165,42,42));
        canvas.drawRect(0,display.height()/(float)1.1,display.width(), display.height(),barBody);

    }
    public void setShopDisplay(Rect rectangle){
        display = rectangle;
    }
}
