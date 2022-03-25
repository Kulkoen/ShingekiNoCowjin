package com.example.shingekinocowjin;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.content.ContextCompat;

import com.example.shingekinocowjin.inputs.TouchInput;
import com.example.shingekinocowjin.scenes.ConfigScreen;
import com.example.shingekinocowjin.scenes.WelcomeScreen;

/*
* Game manages all objects in the game and is responsible for updating all states and render
* all objects in the screen
*/
public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private final Player player;
    private Game game;
    private WelcomeScreen welcomeScreen;
    private ConfigScreen configScreen;
    private TouchInput touchInput;



    public GameScreen(Context context) {
        super(context);

        //Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        getHolder().addCallback(this);

        //Initialize Game State
        GameState.gamestate = GameState.WELCOME;
        game = new Game(this, surfaceHolder);

        //Initialize player
        player = new Player(0,0,"Bob");



        setFocusable(true);
    }

    //Inputs from player
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Handle touch events
        if(event.getAction() == MotionEvent.ACTION_DOWN && GameState.gamestate == GameState.WELCOME){
            GameState.gamestate = GameState.CONFIG;
            return true;
        }
        return super.onTouchEvent(event);
    }




    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        welcomeScreen = new WelcomeScreen(BitmapFactory.decodeResource(getResources(),
                R.drawable.shingeki_no_cowjin_background));
        configScreen = new ConfigScreen(BitmapFactory.decodeResource(getResources(),
                R.drawable.config_cow));
        game.startLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    //Rendering of things onto the screen
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas != null) {
            switch(GameState.gamestate){
                case WELCOME:
                    welcomeScreen.drawWelcome(canvas);
                    break;
                case CONFIG:
                    configScreen.drawConfig(canvas);
                    break;
                case PLAYING:

                    break;
                default:
                    break;
            }

            drawUPS(canvas);
            drawFPS(canvas);
        }
    }

    //Updates Per Second = Object changing property and states.
    public void drawUPS(Canvas canvas){
        String averageUPS = Double.toString(game.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.yellow);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS " + averageUPS, 100, 100, paint);
    }

    //Frames Per Second = Rendering portion of the game. Visual updates in the game that are drawn.
    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(game.getAverageFPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.yellow);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("FPS " + averageFPS, 100, 200, paint);
    }



    public void update(){
        //Update game state
        player.update();
    }

    public WelcomeScreen getWelcomeScreen(){
        return welcomeScreen;
    }
    public ConfigScreen getConfigScreen(){
        return configScreen;
    }

}
