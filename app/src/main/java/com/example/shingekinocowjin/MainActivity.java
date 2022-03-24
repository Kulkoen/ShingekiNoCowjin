package com.example.shingekinocowjin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;

/*
* The entry point in our application. This will be the "welcome screen".
*/
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set content view to game, so objects in GameScreen class can be rendered to the screen
        setContentView(new GameScreen(this));

        //Set window size to fullscreen (hides status bar)
        Window window = getWindow();
        window.getInsetsController().hide(WindowInsets.Type.statusBars()|
                WindowInsets.Type.navigationBars());


    }
}