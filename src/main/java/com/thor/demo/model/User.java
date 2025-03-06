package com.thor.demo.model;

import java.io.Serializable;

public class User implements Serializable {

    private final String charId;
    private String name;
    private String items;
    private int strength;
    private int health;


    public User(String charId, String name, String items, int health, int strength) {

        this.charId = charId;
        this.name = name;
        this.items = items;
        this.health = health;
        this.strength = strength;
    }

    @Override
    public String toString() {
        return name + "{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", health=" + health +
                '}';
    }

    public String getCharId() {
        return charId;
    }

    public String getItems() {
        return items;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
