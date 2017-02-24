package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Admin on 06.02.2017.
 */
public final class Singleton {
    private static final Singleton singleton = new Singleton();
    public static Singleton getInstance() {
       return singleton;
    }
    private Singleton() {

    }
}
