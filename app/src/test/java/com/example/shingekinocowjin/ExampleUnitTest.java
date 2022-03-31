package com.example.shingekinocowjin;

import org.junit.Test;
int difficulty1 = 1;
import static org.junit.Assert.*;

import android.graphics.Bitmap;

import com.example.shingekinocowjin.scenes.ConfigScene;
import com.example.shingekinocowjin.ui.MyButton;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    int difficulty1 = 1;
    int difficulty2 = 2;
    int difficulty3 = 3;
    int cowPriceEasy = 1;
    int cowPriceMedium = 3;
    int cowPriceHard = 5;
    int easyMoney = 3;
    int mediumMoney = 6;
    int hardMoney = 9;
    int gameOverHealth = 0;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    //monument health = 0 when gameover screen pop ups

    public void checkGameOverHealth() {
        assertEquals(0, gameOverHealth);
    }

    //difficulty variable = 1 when gamemode = easy

    public void checkEasyDifficulty() {
        assertEquals(1 , difficulty1);
    }

    //difficulty variable = 2 when gamemode = medium

    public void checkMediumDifficulty() {
        assertEquals(2, difficulty2);
    }

    //difficulty variable = 3 when gamemode = hard

    public void checkHardDifficulty() {
        assertEquals(3, difficulty3);
    }

    //cow price = 1 when gamemode = easy

    public void checkEasyCowPrice() {
        assertEquals(1, cowPriceEasy);
    }

    //cow price = 3 when gamemode = medium

    public void checkMediumCowPrice() {

    }

    //cow price = 5 when gamemode = hard

    public void checkHardCowPrice() {

    }

    //money is set to 3 when gamemode = easy

    public void checkEasyMoney() {

    }

    //money is set to 6 when gamemode = medium

    public void checkMediumMoney() {

    }

    //money is set to 9 when gamemode = hard

    public void checkHardMoney() {

    }
}
/**
 * Test to see if full screen is properly done on the android phone.
 */