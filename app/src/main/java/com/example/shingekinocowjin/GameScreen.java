package com.example.shingekinocowjin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.core.content.ContextCompat;

/*
* Game manages all objects in the game and is responsible for updating all states and render
* all objects in the screen
*/
public class GameScreen extends SurfaceView implements SurfaceHolder.Callback {
    private final Player player;
    private GameLoop gameLoop;

    public GameScreen(Context context) {
        super(context);

        //Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        gameLoop = new GameLoop(this, surfaceHolder);

        //Initialize player

        player = new Player(0,0,"Bob");


        setFocusable(true);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Handle touch events

        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        gameLoop.startLoop();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.white);
        paint.setColor(color);
        canvas.drawRect(0,0,200,200, paint);
        drawUPS(canvas);
        drawFPS(canvas);

    }

    //Updates Per Second = Object changing property and states.
    public void drawUPS(Canvas canvas){
        String averageUPS = Double.toString(gameLoop.getAverageUPS());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.yellow);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("UPS " + averageUPS, 100, 100, paint);
    }

    //Frames Per Second = Rendering portion of the game. Visual updates in the game that are drawn.
    public void drawFPS(Canvas canvas){
        String averageFPS = Double.toString(gameLoop.getAverageFPS());
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
}
