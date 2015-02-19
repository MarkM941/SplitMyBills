package com.millstein.mark.splitmybills;

/**
 * Created by Mark on 2/19/15.
 */
public class Person {
    private String name;
    private int singles;
    private int fives;
    private int tens;
    private int twenties;
    private int fifties;
    private int hundreds;

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

    public Person(String name, int singles, int fives, int tens, int twenties, int fifties, int hundreds) {
        this.name = name;
        this.singles = singles;
        this.fives = fives;
        this.tens = tens;
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
    }
}
