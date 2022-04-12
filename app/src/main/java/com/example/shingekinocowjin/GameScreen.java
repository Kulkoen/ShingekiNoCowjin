package com.example.shingekinocowjin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowMetrics;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.shingekinocowjin.scenes.ConfigScene;
import com.example.shingekinocowjin.scenes.GameOverScene;
import com.example.shingekinocowjin.scenes.PlayScene;
import com.example.shingekinocowjin.scenes.WelcomeScene;
import com.example.shingekinocowjin.ui.MyButton;

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
    private GameOverScene gameOverScene;
    private Rect display;
    private Context contextm;
    private MyButton[] buttons = new MyButton[26];
    private MyButton space = new MyButton("SPACE", 650, 800, 1150, 950);
    private MyButton done = new MyButton("DONE", 1580, 500, 1850, 770);
    private MyButton back = new MyButton("Back", 1580, 100, 1850, 250);
    public GameScreen(Context context) {
        super(context);
        contextm = context;

        // Window Metrics
        WindowMetrics windowMetrics = ((Activity) getContext()).getWindowManager().getCurrentWindowMetrics();
        display = windowMetrics.getBounds();

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        getHolder().addCallback(this);

        // Initialize Game State
        GameState.gamestate = GameState.WELCOME;
        game = new Game(this, surfaceHolder);

        // Initialize player
        player = new Player(100, 5, "");

        setFocusable(true);
    }

    // Inputs from player
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Handle touch events based on game state
        switch (GameState.gamestate) {
            case WELCOME:
                welcomeScene.touched((int) event.getX(), (int) event.getY(), event);
                break;
            case CONFIG:
                configScene.touched((int) event.getX(), (int) event.getY(), event);
                break;
            case PLAYING:
                playScene.touched((int) event.getX(), (int) event.getY(), event);
                break;
            case GAMEOVER:
                gameOverScene.touched((int)event.getX(),(int)event.getY(), event);
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        welcomeScene = new WelcomeScene(BitmapFactory.decodeResource(getResources(),
                R.drawable.welcome_screen));
        configScene = new ConfigScene(BitmapFactory.decodeResource(getResources(),
                R.drawable.cow_background));
        playScene = new PlayScene(BitmapFactory.decodeResource(getResources(),
                R.drawable.map));
        gameOverScene = new GameOverScene(BitmapFactory.decodeResource(getResources(),
                R.drawable.game_over));
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
                case KEYBOARD:
                    drawKeyboard(canvas);
                    createKeyboardButtons();
                    drawKeyboardButtons(canvas);
                    break;
                case PLAYING:
                    playScene.setPlayingDisplay(display);
                    playScene.drawPlay(canvas);
                    drawUPS(canvas);
                    drawFPS(canvas);
                    drawBarn(canvas);
                    drawMonumentHealth(canvas);
                    drawMoney(canvas);
                    drawCowPrice(canvas);
                    break;
                case GAMEOVER:
                    gameOverScene.setGameOverDisplay(display);
                    gameOverScene.drawGameOver(canvas);
                    break;
                default:
                    break;
            }
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

    public void createKeyboardButtons(){
        char letter = 'A';
        int top = 500, left = 150, right = 230, bottom = 620;
        for(int i = 0; i < 26; i++) {
            buttons[i] = new MyButton(toString((char)(letter++)), left, top, right, bottom);

            if (i == 12) {
                top += 150;
                bottom += 150;
                left = 150;
                right = 230;
            } else {
                left += 110;
                right += 110;
            }
        }
    }
    public void drawKeyboardButtons(Canvas canvas) {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].drawButton(canvas);
        }
        space.drawButton(canvas);
        done.drawButton(canvas);
        back.drawButton(canvas);
        Rect r = new Rect();
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        Paint paint1 = new Paint();
        paint1.setStrokeWidth(10.0f);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.BLACK);
        canvas.drawRect(150, 100, 1550, 250, paint1);
        r.set(150, 100, 1550, 250);
        canvas.drawRect(r, paint);
    }

    private String toString(char c) {
        String str = c + "";
        return str;
    }

    public void drawMonumentHealth(Canvas canvas) {
        String theMonumentHealth = Double.toString(player.getMonumentHealth());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.red);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("Health: " + theMonumentHealth, 1650, 100, paint);
    }
    public void drawKeyboard(Canvas canvas) {
        Rect r = new Rect();
        r.set(0,0, 3000,1400);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#FCF2F3"));
        canvas.drawRect(r, paint);
    }
    public void drawMoney(Canvas canvas) {
        String theMoney = Double.toString(player.getMoney());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.green);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("Money: " + theMoney, 1350, 100, paint);
    }

    public void drawCowPrice(Canvas canvas) {
        String theCowPrice = Double.toString(configScene.getCowPrice());
        Paint paint = new Paint();
        int color = ContextCompat.getColor(getContext(), R.color.green);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("Cow Price: " + theCowPrice, 1650, 900, paint);
    }

    public void drawBarn(Canvas canvas) {
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.red_barn);
        canvas.drawBitmap(b, 1910, 335, null);
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
