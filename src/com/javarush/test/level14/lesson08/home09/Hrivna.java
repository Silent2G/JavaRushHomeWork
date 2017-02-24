package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Admin on 05.02.2017.
 */
public class Hrivna extends Money {
    Hrivna(double amount) {
        super(amount);
    }
    public String getCurrencyName() {
        return "HRN";
    }
}
