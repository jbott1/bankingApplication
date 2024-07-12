package com.thor.demo;
import java.io.Serializable;
public class User {

     private String name;
     private int strength;
     private int health;
    public User(){
        super();
        this.name = "*";
        this.health = 100;
        this.strength = 10;
    }

    @Override
    public String toString() {
        return  name + "{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", health=" + health +
                '}';
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
