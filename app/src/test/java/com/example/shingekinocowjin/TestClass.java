package com.example.shingekinocowjin;

public class TestClass {

    public int getDifficulty1() {
        return difficulty1;
    }

    public int getDifficulty2() {
        return difficulty2;
    }

    public int getDifficulty3() {
        return difficulty3;
    }

    public int getCowPriceEasy() {
        return cowPriceEasy;
    }

    public int getCowPriceMedium() {
        return cowPriceMedium;
    }

    public int getCowPriceHard() {
        return cowPriceHard;
    }

    public int getEasyMoney() {
        return easyMoney;
    }

    public int getMediumMoney() {
        return mediumMoney;
    }

    public int getHardMoney() {
        return hardMoney;
    }

    public int getGameOverHealth() {
        return gameOverHealth;
    }

    int cowPriceMedium = 3;

    public void setCowPriceMedium(int cowPriceMedium) {
        this.cowPriceMedium = cowPriceMedium;
    }

    public void setCowPriceHard(int cowPriceHard) {
        this.cowPriceHard = cowPriceHard;
    }

    public void setEasyMoney(int easyMoney) {
        this.easyMoney = easyMoney;
    }

    public void setMediumMoney(int mediumMoney) {
        this.mediumMoney = mediumMoney;
    }

    public void setHardMoney(int hardMoney) {
        this.hardMoney = hardMoney;
    }

    public void setGameOverHealth(int gameOverHealth) {
        this.gameOverHealth = gameOverHealth;
    }

    public void setDifficulty3(int difficulty3) {
        this.difficulty3 = difficulty3;
    }

    public void setCowPriceEasy(int cowPriceEasy) {
        this.cowPriceEasy = cowPriceEasy;
    }

    int cowPriceHard = 5;
    int easyMoney = 3;
    int mediumMoney = 6;
    int hardMoney = 9;
    int gameOverHealth = 0;
    int difficulty1 = 1;
    int difficulty2 = 2;
    int difficulty3 = 3;
    int cowPriceEasy = 1;

    public int getGameOverDifficulty() {
        return gameOverDifficulty;
    }

    public int getGameOverMoney() {
        return gameOverMoney;
    }

    public int getGameOverCowCost() {
        return gameOverCowCost;
    }

    int gameOverDifficulty = 0;

    public void setDifficulty1(int difficulty1) {
        this.difficulty1 = difficulty1;
    }

    public void setDifficulty2(int difficulty2) {
        this.difficulty2 = difficulty2;
    }

    public void setGameOverDifficulty(int gameOverDifficulty) {
        this.gameOverDifficulty = gameOverDifficulty;
    }

    public void setGameOverMoney(int gameOverMoney) {
        this.gameOverMoney = gameOverMoney;
    }

    public void setGameOverCowCost(int gameOverCowCost) {
        this.gameOverCowCost = gameOverCowCost;
    }

    int gameOverMoney = 0;
    int gameOverCowCost = 0;

}
