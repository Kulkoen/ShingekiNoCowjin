package com.example.shingekinocowjin;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowMetrics;

import androidx.core.content.ContextCompat;

import com.example.shingekinocowjin.managers.FarmerManager;
import com.example.shingekinocowjin.scenes.ConfigScene;
import com.example.shingekinocowjin.scenes.PlayScene;
import com.example.shingekinocowjin.scenes.WelcomeScene;
import com.example.shingekinocowjin.ui.Shop;

/*
* Game manages all objects in the game and is responsible for updating all states and render
* all objects in the screen
*/
public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private final Player player;
    private Game game;
    private WelcomeScene welcomeScene;
    private ConfigScene configScene;
    private PlayScene playScene;
    private Rect display;

    public GameScreen(Context context) {
        super(context);

        //Window Metrics
        WindowMetrics windowMetrics = ((Activity)getContext()).getWindowManager().getCurrentWindowMetrics();
        display = windowMetrics.getBounds();

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        getHolder().addCallback(this);

        // Initialize Game State
        GameState.gamestate = GameState.WELCOME;
        game = new Game(this, surfaceHolder);

        // Initialize player
        player = new Player(300, 300,"Bob");

        setFocusable(true);
    }

    // Inputs from player
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Handle touch events based on game state
        switch(GameState.gamestate){
            case WELCOME:
                    welcomeScene.touched((int)event.getX(),(int)event.getY(), event);
                break;
            case CONFIG:
                    configScene.touched((int)event.getX(),(int)event.getY(), event);
                break;
            case PLAYING:
                    playScene.touched((int)event.getX(),(int)event.getY(), event);
                break;
            default:
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        welcomeScene = new WelcomeScene(BitmapFactory.decodeResource(getResources(),
                R.drawable.shingeki_no_cowjin_background));
        configScene = new ConfigScene(BitmapFactory.decodeResource(getResources(),
                R.drawable.config_cow));
        playScene = new PlayScene(BitmapFactory.decodeResource(getResources(),
                R.drawable.map));
        game.startLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    // Rendering of things onto the screen
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            switch (GameState.gamestate) {
                case WELCOME:
                    welcomeScene.setWelcomeDisplay(display);
                    welcomeScene.drawWelcome(canvas);
                    break;
                case CONFIG:
                    configScene.setConfigDisplay(display);
                    configScene.drawConfig(canvas);
                    break;
                case PLAYING:
                    playScene.setPlayingDisplay(display);
                    playScene.drawPlay(canvas);
                    break;
                default:
                    break;
            }

            drawUPS(canvas);
            drawFPS(canvas);
        }
    }

    // Updates Per Second = Object changing property and states.
    public void drawUPS(Canvas canvas) {
        String averageUPS = Double.toString(game.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.red);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS " + averageUPS, 100, 100, paint);
    }

    // Frames Per Second = Rendering portion of the game. Visual updates in the game
    // that are drawn.
    public void drawFPS(Canvas canvas) {
        String averageFPS = Double.toString(game.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.red);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS " + averageFPS, 100, 200, paint);
    }

    public void update() {
        switch (GameState.gamestate) {
            case WELCOME:
                break;
            case CONFIG:
                break;
            case PLAYING:
                playScene.update();
                break;
            default:
                break;
        }

    }

    public WelcomeScene getWelcomeScreen() {
        return welcomeScene;
    }

    public ConfigScene getConfigScreen() {
        return configScene;
    }


}
