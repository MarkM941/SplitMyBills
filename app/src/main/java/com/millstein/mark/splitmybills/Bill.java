package com.millstein.mark.splitmybills;

import java.util.ArrayList;

/**
 * Created by mark on 2/15/15.
 */
public class Bill {
    private ArrayList<Person> people;
    private float billTotal;

    public Bill(ArrayList<Person> people, float billTotal) {
        this.people = people;
        this.billTotal = billTotal;
    }

    public void setBillTotal(float billTotal) {
        this.billTotal = billTotal;
    }
    
    public void addPerson(Person pNewPerson) {
        people.add(pNewPerson);
    }
}
