package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 02.02.2017.
 */
abstract class Hen {
    abstract int getCountOfEggsPerMonth();
    String getDescription() {
        return "Я курица.";
    }
}
