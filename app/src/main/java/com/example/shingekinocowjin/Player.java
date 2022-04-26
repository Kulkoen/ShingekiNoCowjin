package com.example.shingekinocowjin;

public class Player {
    private static int monumentHealth = 1;
    private static int farmersKilled;
    private static int upgradesBought;
    private static int unitsBought;
    private static int money;
    private String name;

    public Player(int health, int money, String name) {
        monumentHealth = health;
        this.money = money;
        this.name = name;
    }

    public void update() {

    }

    public int getFarmersKilled() {
        return farmersKilled;
    }

    public int getUnitsBought() {
        return unitsBought;
    }

    public int getUpgradesBought() {
        return upgradesBought;
    }

    public void setFarmersKilled(int newFarmersKilled) {
        farmersKilled = newFarmersKilled;
    }

    public void setUnitsBought(int newUnitsBought) {
        unitsBought = newUnitsBought;
    }

    public void setUpgradesBought(int newUpgradesBought) {
        upgradesBought = newUpgradesBought;
    }

    public int getMonumentHealth() {
        return monumentHealth;
    }

    public int getMoney() {
        return money;
    }

    public void setMonumentHealth(int health) {
        monumentHealth = health;
    }

    public void setMoney(int newMoney) {
        money = newMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
}
