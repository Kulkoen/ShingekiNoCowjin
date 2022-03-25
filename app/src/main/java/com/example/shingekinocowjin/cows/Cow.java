package com.example.shingekinocowjin.cows;

public abstract class Cow {
    private int health = 0;
    private int cost = 0;
    private int attackSpeed = 0;
    private int damage = 0;
    private int level = 0;
    private float range = 0;

    public Cow(int health, int cost, int attackSpeed, int damage, int level, float range) {
        this.health = health;
        this.cost = cost;
        this.attackSpeed = attackSpeed;
        this.damage = damage;
        this.level = level;
        this.range = range;
    }


    abstract void attackEnemy();
    public int getHealth() {
        return health;
    }
    public int getCost() {
        return cost;
    }
    public int getAttackSpeed() {
        return attackSpeed;
    }
    public int getDamage() {
        return damage;
    }
    public int getLevel() {
        return level;
    }
    public float getRange() {
        return range;
    }
}
