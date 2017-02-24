package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Admin on 12.02.2017.
 */
public final class Moon implements Planet {
    private Moon() {}
    private static Moon instance;
    public static Moon getInstance() {
        if(instance == null) {
            instance = new Moon();
        }
        return instance;
    }
}
