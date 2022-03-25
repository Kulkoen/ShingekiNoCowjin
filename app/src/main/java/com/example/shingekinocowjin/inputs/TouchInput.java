package com.example.shingekinocowjin.inputs;

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.example.shingekinocowjin.Game;
import com.example.shingekinocowjin.GameState;

public class TouchInput implements View.OnTouchListener {
    private Game game;
    private SurfaceHolder surfaceHolder;


    public TouchInput(Game game){
        this.game = game;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(motionEvent.getAction() == MotionEvent.ACTION_UP) {
            switch (GameState.gamestate) {
                case CONFIG:
                    game.getGameScreen().getConfigScreen().touched((int) motionEvent.getX(),
                            (int) motionEvent.getY());
                    break;
                case PLAYING:
                    break;
                default:
                    break;
            }
        }
        return true;
    }
}
