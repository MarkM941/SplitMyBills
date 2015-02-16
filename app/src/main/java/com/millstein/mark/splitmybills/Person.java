package com.millstein.mark.splitmybills;

/**
 * Created by mark on 
 * * 2/15/15.
 */
public class Person {
    private String name;
    private int singles;
    private int fives;
    private int tens;
    private int twenties;
    private int fifties;
    private int hundreds;

    public Person(String name, int singles, int fives, int tens, int twenties, int fifties, int hundreds) {
        this.name = name;
        this.singles = singles;
        this.fives = fives;
        this.tens = tens;
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSingles(int singles) {
        this.singles = singles;
    }

    public void setFives(int fives) {
        this.fives = fives;
    }

    public void setTens(int tens) {
        this.tens = tens;
    }

    public void setTwenties(int twenties) {
        this.twenties = twenties;
    }

    public void setFifties(int fifties) {
        this.fifties = fifties;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }

    public String getName() {
        return name;
    }

    public int getSingles() {
        return singles;
    }

    public int getFives() {
        return fives;
    }

    public int getTens() {
        return tens;
    }

    public int getTwenties() {
        return twenties;
    }

    public int getFifties() {
        return fifties;
    }

    public int getHundreds() {
        return hundreds;
    }
}
