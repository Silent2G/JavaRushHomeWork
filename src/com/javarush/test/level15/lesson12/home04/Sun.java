package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Admin on 12.02.2017.
 */
public final class Sun implements Planet {
    private Sun() {}
    private static Sun instance;
    public static Sun getInstance() {
        if(instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}
