package com.example.shingekinocowjin;

public enum GameState {
    PLAYING,
    WELCOME,
    CONFIG,
    GAMEOVER;

    public static GameState gamestate = WELCOME;

    public static void SetGameState(GameState state) {
        gamestate = state;
    }
}
