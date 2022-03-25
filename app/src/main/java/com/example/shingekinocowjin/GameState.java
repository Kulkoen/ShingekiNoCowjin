package com.example.shingekinocowjin;

public enum GameState {
    PLAYING,
    WELCOME,
    CONFIG;

    public static GameState gamestate = WELCOME;

    public static void SetGameState(GameState state){
        gamestate = state;
    }
}

