package com.example.shingekinocowjin;

public class Player {
    int monumentHealth;
    int money;
    String name;

    public Player(int monumentHealth, int money, String name) {
        this.monumentHealth = monumentHealth;
        this.money = money;
        this.name = name;
    }

    public void update() {

    }

    public int getMonumentHealth() {
        return monumentHealth;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName){
        name = newName;
    }
}
