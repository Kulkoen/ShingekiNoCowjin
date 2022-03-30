package com.example.shingekinocowjin;

public class Player {
    int monumentHealth = 25;
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

    public void setName(String newName) {
        name = newName;
    }

    public void removeOneMonumentHealth() {
        monumentHealth--;
        if (monumentHealth <= 0) {
            System.out.println("Game Over"); // replace this with the game over screen soon TM.
        }
    }
}
