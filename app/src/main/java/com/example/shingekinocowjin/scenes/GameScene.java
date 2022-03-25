package com.example.shingekinocowjin.scenes;

import com.example.shingekinocowjin.Game;

public class GameScene {
    private Game game;

    public GameScene(Game game){
        this.game = game;
    }

    public Game getGameLoop(){
        return game;
    }
}
