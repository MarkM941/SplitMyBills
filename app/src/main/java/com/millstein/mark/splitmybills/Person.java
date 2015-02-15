package com.millstein.mark.splitmybills;

/**
 * Created by mark on 2/15/15.
 */
public class Person {
    private int singles;
    private int fives;
    private int tens;
    private int twenties;
    private int fifties;
    private int hundreds;

    public Person(int singles, int fives, int tens, int twenties, int fifties, int hundreds) {
        this.singles = singles;
        this.fives = fives;
        this.tens = tens;
        this.twenties = twenties;
        this.fifties = fifties;
        this.hundreds = hundreds;
    }
}
