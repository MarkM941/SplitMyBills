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

    public int getBillCount(int pBill) {
        switch (pBill) {
            case 0:
                return singles;
            case 1:
                return fives;
            case 2:
                return tens;
            case 3:
                return twenties;
            case 4:
                return fifties;
            case 5:
                return hundreds;
            default:
                throw new RuntimeException("Tried getting bill count for unknown bill");
        }
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
