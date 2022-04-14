package com.example.shingekinocowjin;

public enum GameState {
    PLAYING,
    WELCOME,
    CONFIG,
    KEYBOARD,
    GAMEOVER;

    public static GameState gamestate = WELCOME;

    public static void SetGameState(GameState state) {
        gamestate = state;
    }
    public static GameState getGamestate() {return gamestate;}
}
