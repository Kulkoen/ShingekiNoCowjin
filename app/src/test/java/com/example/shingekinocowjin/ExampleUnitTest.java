package com.example.shingekinocowjin;

import org.junit.Test;
import static org.junit.Assert.*;

import android.graphics.Bitmap;

import com.example.shingekinocowjin.scenes.ConfigScene;
import com.example.shingekinocowjin.ui.MyButton;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintSet;

import com.example.shingekinocowjin.GameState;
import com.example.shingekinocowjin.ui.MyButton;
import com.example.shingekinocowjin.GameScreen;
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    TestClass testClass;


    @Test
    public void addition_isCorrect() {

        testClass = new TestClass();
        assertEquals(4, 2 + 2);
    }

    //monument health = 0 when gameover screen pop ups
    @Test
    public void checkGameOverHealth() {
        testClass = new TestClass();

        assertEquals(0, testClass.getGameOverHealth());
    }

    //difficulty variable = 1 when gamemode = easy

    @Test
    public void checkEasyDifficulty() {
        testClass = new TestClass();

        assertEquals(1 , testClass.getDifficulty1());
    }

    //difficulty variable = 2 when gamemode = medium

    @Test
    public void checkMediumDifficulty() {
        testClass = new TestClass();

        assertEquals(2, testClass.getDifficulty2());
    }

    //difficulty variable = 3 when gamemode = hard

    @Test
    public void checkHardDifficulty() {
        testClass = new TestClass();

        assertEquals(3, testClass.getDifficulty3());
    }

    //cow price = 1 when gamemode = easy

    @Test
    public void EasyCowPrice() {
        testClass = new TestClass();

        assertEquals(1, testClass.getCowPriceEasy());
    }

    //cow price = 3 when gamemode = medium

    @Test
    public void MediumCowPrice() {
        testClass = new TestClass();

        assertEquals(3, testClass.getCowPriceMedium());
    }

    //cow price = 5 when gamemode = hard

    @Test
    public void HardCowPrice() {
        testClass = new TestClass();

        assertEquals(5, testClass.getCowPriceHard());
    }

    //money is set to 3 when gamemode = easy

    @Test
    public void checkEasyMoney() {
        testClass = new TestClass();

        assertEquals(3, testClass.getEasyMoney());
    }

    //money is set to 6 when gamemode = medium

    @Test
    public void checkMediumMoney() {
        testClass = new TestClass();

        assertEquals(6, testClass.getMediumMoney());
    }

    //money is set to 9 when gamemode = hard

    @Test
    public void checkHardMoney() {
        testClass = new TestClass();

        assertEquals(9, testClass.getHardMoney());
    }

    @Test
    public void checkGameOverMoney() {
        testClass = new TestClass();

        assertEquals(0, testClass.getGameOverMoney());
    }

    @Test
    public void checkGameOverCowCost() {
        testClass = new TestClass();

        assertEquals(0, testClass.getGameOverCowCost());
    }

    @Test
    public void checkGameOverDifficulty() {
        testClass = new TestClass();

        assertEquals(0, testClass.getGameOverDifficulty());
    }


    //@Test


}
/**
 * Test to see if full screen is properly done on the android phone.
 */