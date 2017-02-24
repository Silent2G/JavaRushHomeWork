package com.javarush.test.level14.lesson06.home01;

/**
 * Created by Admin on 02.02.2017.
 */
class MoldovanHen extends Hen implements Country{
    int getCountOfEggsPerMonth() {
        return 1000;
    }
    String getDescription() {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth()+ " яиц в месяц.";
    }

}