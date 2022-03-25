package com.example.shingekinocowjin.scenes;

import com.example.shingekinocowjin.GameLoop;

public class GameScene {
    private GameLoop game;

    public GameScene(GameLoop game){
        this.game = game;
    }

    public GameLoop getGameLoop(){
        return game;
    }
}
