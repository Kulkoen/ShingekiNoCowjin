package com.example.shingekinocowjin;

public enum GameState {
    PLAYING,
    WELCOME,
    CONFIG,
    KEYBOARD,
    GAMEWON,
    GAMEOVER;

    private static GameState gamestate = GAMEWON;

    public static void setGameState(GameState state) {
        gamestate = state;
    }

    public static GameState getGamestate() {
        return gamestate;
    }
}
