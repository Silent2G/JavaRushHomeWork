package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 02.02.2017.
 */
class BelarusianHen extends Hen implements Country{
    int getCountOfEggsPerMonth() {
        return 4000;
    }
    String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}